package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class TurnImageApplet extends Applet {
    public void paint(Graphics g) {
        String value = "½��ϧ�";
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD4.jpg");// ��o�Ϥ���T
        int w = img.getWidth(this);// �]�w�ϧΪ��e��
        int h = img.getHeight(this);// �]�w�ϧΪ�����
        Graphics2D g2d = (Graphics2D) g;// �Ng�ର�i�H�Q�Ϊ�Graphics2D
        g2d.drawString(value, 100, 130);// ø�s�¤�r
        AffineTransform tr = new AffineTransform(-1, 0, 0, 1, w, 0);// �إ��ܴ���H�ä���½��
        AffineTransform tr2 = new AffineTransform(1, 0, 0, -1, 0, h);// �إ��ܴ���H�ë���½��
        tr.translate(-20, 40);// �ϧΦ�m������
        tr2.translate(120, -40);// �ϧΦ�m������
        g2d.drawImage(img, tr, this);// ø�s�ϧ�
        g2d.drawImage(img, tr2, this);// ø�s�ϧ�
    }
}
