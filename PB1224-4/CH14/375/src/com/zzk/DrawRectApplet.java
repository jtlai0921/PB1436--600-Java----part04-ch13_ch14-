package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawRectApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�e�x��";
        int x = 42;// �x�Ϊ���y��
        int y = 27;// �x�Ϊ��a�y��
        int width = 122;// �x�Ϊ��e��
        int height = 64;// �x�Ϊ�����
        g.setColor(Color.BLUE);// �]�w�C���Ŧ�
        g.drawRect(x, y, width, height);// ø�s�x��
        int x0 = 54;// �x�Ϊ���y��
        int y0 = 37;// �x�Ϊ��a�y��
        int width0 = 130;// �x�Ϊ��e��
        int height0 = 69;// �x�Ϊ�����
        g.setColor(Color.BLUE);// �]�w�C���Ŧ�
        g.drawRect(x0, y0, width0, height0);// ø�s�x��
        int x1 = 67;// �x�Ϊ���y��
        int y1 = 48;// �x�Ϊ��a�y��
        int width1 = 137;// �x�Ϊ��e��
        int height1 = 73;// �x�Ϊ�����
        g.setColor(Color.BLUE);// �]�w�C���Ŧ�
        g.drawRect(x1, y1, width1, height1);// ø�s�x��
        g.drawString(value, 185, 143);// ø�s�¤�r
    }
}
