package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawLineApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�e���u";
        int x = 215;// ���u����y��(�k)
        int y = 45;// ���u���a�y��(�k)
        int x1 = 15;// ���u����y��(��)
        int y1 = 45;// ���u���a�y��(��)
        int x2 = 300;// ���u����y��(�k)
        int y2 = 100;// ���u���a�y��(�k)
        int x3 = 60;// ���u����y��(��)
        int y3 = 100;// ���u���a�y��(��)
        g.setColor(Color.blue);// �]�w�C�����
        g.drawLine(x, y, x1, y1);// ø�s���u
        g.drawLine(x2, y2, x3, y3);// ø�s���u
        g.drawString(value, 120, 75);// ø�s�¤�r
    }
}
