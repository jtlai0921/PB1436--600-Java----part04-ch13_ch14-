package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageRotateApplet extends Applet {
    public void paint(Graphics g) {
        String value = "����ϧ�";
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD2.jpg");// ��o�Ϥ���T
        Graphics2D g2d = (Graphics2D) g; // �j���ରGraphics2D�ﹳ
        g2d.drawString(value, 180, 150);// ø�s�¤�r
        int x = 50;// �ϧΦ�m����y��
        int y = -10;// �ϧΦ�m���a�y��
        int w = img.getWidth(this);// ��o�Ϥ����e��
        int h = img.getHeight(this);// ��o�Ϥ�������
        g2d.drawImage(img, x, y + 50, w / 5, h / 5, this);// ø�s�ϧ�
        g2d.drawImage(img, x + 150, y + 50, w / 5, h / 5, this);// ø�s�ϧ�
        AffineTransform tr = new AffineTransform();// �إ��ܧιﹳ
        tr.rotate(90, 15, 15, 65);// �]�w���ਤ��
        g2d.setTransform(tr);// �������
        g2d.drawImage(img, x + 150, y + 20, w / 5, h / 5, this);// ø�s�ϧ�
        tr.rotate(35, 15, 30, 65);// �]�w���ਤ��
        g2d.setTransform(tr);// �������
        g2d.drawImage(img, x + 120, y - 60, w / 5, h / 5, this);// ø�s�ϧ�
    }
}