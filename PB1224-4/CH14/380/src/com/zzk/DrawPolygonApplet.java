package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPolygonApplet extends Applet {
    public void paint(Graphics g) {
        String value = "ø�s�h����";
        int x[] = { 60, 103, 170, 150, 120 };// �ŧi�h���Ϊ���y�а}�C
        int y[] = { 80, 180, 140, 80, 120 };// �ŧi�h���Ϊ��a�y�а}�C
        int num = x.length;// ���o�h����x,y�y�й�}�C������
        g.setColor(Color.blue);// �]�w�C��
        g.drawPolygon(x, y, num);// // ø�s�h����
        g.drawString(value, 120, 70);// ø�s�¤�r
    }
}
