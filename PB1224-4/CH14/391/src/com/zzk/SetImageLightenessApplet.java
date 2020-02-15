package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class SetImageLightenessApplet extends Applet {
    private BufferedImage image;// �ŧi�w�Ĺϧιﹳ
    public void paint(Graphics g) {
        Image img = null;// �ŧi�ϧιﹳ
        String value = "�վ�Ϥ��G��";
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg");// ��o�ϧιﹳ
        int a = img.getWidth(this); // ��o�Ϥ��e�׽ᵹ�ܼ�a
        int b = img.getHeight(this);// ��o�Ϥ����׽ᵹ�ܼ�b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// �إ߽w�Ĺϧιﹳ
            image.getGraphics().drawImage(img, 0, 0, null);// �b�w�Ĺϧιﹳ�Wø�s�ϧ�
            float fa = 2.0f;// �ŧi��ܹ������q
            float fb = -30.0f;// �ŧi��ܹ������q
            RescaleOp op = new RescaleOp(fa, fb, null);// �إ�RescaleOp�ﹳ
            image = op.filter(image, null); // �L�o�w�Ĺϧι�H�A��{�վ�ϧΫG�ת��\��
            g.drawImage(img, 30, 40, this);// ø�s��ϧιﹳ
            g.drawImage(image, 220, 40, this);// ø�s�վ�G�׫᪺�w�Ĺϧιﹳ
            g.drawString(value, 265, 188);// ø�s�¤�r
        }
    }
}
