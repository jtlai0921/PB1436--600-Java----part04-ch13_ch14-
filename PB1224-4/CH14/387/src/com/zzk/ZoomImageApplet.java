package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class ZoomImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�Y��ϧ�";
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD2.jpg");// ��o�Ϥ���T
        AffineTransform tr = AffineTransform.getScaleInstance(0.25, 0.25);// �إ��ܧΥH��o�Y��ﹳ
        tr.translate(120, 100);// �]�w�ﹳ����
        AffineTransform tr2 = AffineTransform.getScaleInstance(0.15, 0.15);// �إ��ܧΥH��o�Y��ﹳ
        tr2.translate(900, 950);// �]�w�ﹳ����
        Graphics2D g2d = (Graphics2D) g;// �Ng�ഫ���@�ӥi�Ϊ�Graphics2D�ﹳ
        g2d.drawImage(img, tr, this);// ø�s�ϧ�
        g2d.drawImage(img, tr2, this);// ø�s�ϧ�
        g2d.drawString(value, 60, 150);// ø�s�¤�r
    }
}
