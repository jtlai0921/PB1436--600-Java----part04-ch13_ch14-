package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class DrawImageApplet extends Applet {
    public void paint(Graphics g) {// ��l�Ƥ�k
        String value = "ø�s�Ϥ�";
        Image image = null;// �ŧi�ϧιﹳ
        image = getImage(getCodeBase(), "com/zzk/PD2.jpg");// ��o�Ϥ���T
        int x = 10;// �ϧΦ�m����y��
        int y = 20;// �ϧΦ�m���a�y��
        int width = image.getWidth(this);// ��o�ϧΪ��e��
        int height = image.getHeight(this);// ��o�ϧΪ�����
        g.drawImage(image, x + 150, y + 30, width / 5, height / 5, this);// ø�s�ϧ�
        g.drawImage(image, x + 25, y + 10, (int) (width * 0.2),
                (int) (height * 0.3), this);// ø�s�ϧ�
        g.drawString(value, 140, 170);// ø�s�¤�r
    }
}
