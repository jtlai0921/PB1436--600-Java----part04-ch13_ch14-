package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class PaintMethodApplet extends Applet {
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);// �]�w�C��
        g.drawString("�o�O�ϥ�paint()��kø�s���¤�r�C", 30, 40);// ø�s�¤�r���e
        g.setColor(Color.RED);// �]�w�C��
        g.drawString("�U���O�ϥ�paint()��kø�s���ϧΡC", 30, 80);// ø�s�¤�r���e
        g.drawRect(30, 100, 50, 40);// ø�s�ϧ�
    }
}
