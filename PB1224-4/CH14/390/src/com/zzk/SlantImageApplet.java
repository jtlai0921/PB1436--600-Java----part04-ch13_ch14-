package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class SlantImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�ɱ׹ϧ�";
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD5.jpg");// ��o�Ϥ���T
        Graphics2D g2d = (Graphics2D) g;// �j���ରGraphics2D�ﹳ
        g2d.drawString(value, 209, 170);// ø�s�¤�r
        AffineTransform tr = new AffineTransform();// �إ�AffineTransform�ﹳ
        tr.translate(210, 32);// �ϧΦ�m������
        tr.shear(3, 3);// �ɱ׹ϧ�
        g2d.drawImage(img, tr, this);// ø�s�ϧ�
        AffineTransform tr1 = AffineTransform.getScaleInstance(3.5, 3.5);// ��oAffineTransform�ﹳ
        tr1.translate(15, 13);// �ϧΦ�m������
        g2d.drawImage(img, tr1, this);// ø�s�ϧ�
    }
}
