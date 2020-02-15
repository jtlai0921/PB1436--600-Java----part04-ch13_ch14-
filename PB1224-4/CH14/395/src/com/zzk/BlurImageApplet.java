package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BlurImageApplet extends Applet {
    private BufferedImage image;// �ŧi�w�Ĺϧιﹳ
    public void paint(Graphics g) {
        Image img = null;// �ŧi�إ߹ϧιﹳ
        String value = "�ҽk�ϧ�";
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg");// ��o�Ϥ���T
        int a = img.getWidth(this); // ��o�Ϥ��e�׽ᵹ�ܼ�a
        int b = img.getHeight(this);// ��o�Ϥ����׽ᵹ�ܼ�b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// �إ߽w�Ĺϧιﹳ
            image.getGraphics().drawImage(img, 0, 0, null);// �b�w�Ĺϧιﹳ�Wø�s�ϧ�
            float[] data = { 0.0532f, 0.132f, 0.0532f, 0.132f, 0.19f, 0.138f,
                    0.0532f, 0.132f, 0.0532f };// �ŧi��ܹ������q���}�C
            Kernel kernel = new Kernel(3, 3, data); // �إ� Kernel�ﹳ
            ConvolveOp op = new ConvolveOp(kernel);// �إ�ConvolveOp�ﹳ
            image = op.filter(image, null); // �L�o�w�Ĺϧιﹳ
            g.drawImage(img, 25, 35, this);// ø�s�w�Ĺϧιﹳ
            g.drawImage(image, 215, 35, this);// ø�s�w�Ĺϧιﹳ
            g.drawString(value, 268, 186);// ø�s�¤�r
        }
    }
}