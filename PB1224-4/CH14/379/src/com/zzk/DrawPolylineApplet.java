package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPolylineApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�E�X�u";
        int[] x = { 30, 60, 60, 20 };// �ŧi��ܻE�X�u��y�Ъ��}�C
        int[] y = { 30, 70, 150, 80 };// �ŧi��ܻE�X�u�a�y�Ъ��}�C
        int num1 = x.length;// ���Rx,y�y�й�}�C������
        g.setColor(Color.blue);// �]�w�C��
        g.drawPolyline(x, y, num1);// ø�s�E�X�u
        int[] x0 = { 80, 110, 65, 80, 200 };// �ŧi��ܻE�X�u��y�Ъ��}�C
        int[] y0 = { 30, 70, 100, 120, 150 };// �ŧi��ܻE�X�u�a�y�Ъ��}�C
        int num2 = x0.length;// ���Rx0,y0�y�й�}�C������
        g.drawPolyline(x0, y0, num2);// ø�s�E�X�u
        g.drawString(value, 160, 130);// ø�s�¤�r
    }
}
