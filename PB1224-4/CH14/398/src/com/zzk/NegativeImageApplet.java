package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;

public class NegativeImageApplet extends Applet {
    private BufferedImage image;// �ŧi�w�Ĺϧιﹳ
    public void paint(Graphics g) {
        String value = "�ϦV�ϧ�";
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// ��o�Ϥ���T
        int a = img.getWidth(this); // ��o�Ϥ��e�׽ᵹ�ܼ�a
        int b = img.getHeight(this);// ��o�Ϥ����׽ᵹ�ܼ�b
        if (a >= 0 || b >= 0) {
            image = new BufferedImage(img.getWidth(this), img.getHeight(this),
                    BufferedImage.TYPE_INT_RGB);// �إ߽w�Ĺϧιﹳ
            image.getGraphics().drawImage(img, 0, 0, null);// �b�w�Ĺϧιﹳ�Wø�s�ϧ�
            short[] negative = new short[256 * 1];// �إߪ���C��ϦV�����q�}�C
            for (int i = 0; i < 256; i++) {
                negative[i] = (short) (255 - i);// ���}�C������
            }
            ShortLookupTable table = new ShortLookupTable(0, negative);// �إߴM���ﹳ
            LookupOp op = new LookupOp(table, null);// �إ߹�{�q����ؼдM��ާ@��LookupOp�ﹳ
            image = op.filter(image, null);// �I�sLookupOp��H��filter()��k�A��{�ϧΤϦV�\��
            if (image != null) {
                g.drawImage(img, 35, 40, null);// ø�s�w�Ĺϧιﹳ
                g.drawImage(image, 220, 40, null);// ø�s�w�Ĺϧιﹳ
            }
            g.drawString(value, 265, 175);// ø�s�¤�r
        }
    }
}