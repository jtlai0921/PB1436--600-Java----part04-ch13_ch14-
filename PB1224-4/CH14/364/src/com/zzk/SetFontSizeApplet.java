package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetFontSizeApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("�ө���", Font.PLAIN, 16);// �إߦr���H�A�r��j�p��16
        g.setFont(font);// �]�w�r��
        g.drawString("�r��j�p��16", 30, 20);// ø�s�¤�r
        font = new Font("�ө���", Font.PLAIN, 22);// �إߦr���H�A�r��j�p��22
        g.setFont(font);// �]�w�r��
        g.drawString("�r��j�p��22", 30, 60);// ø�s�¤�r
        font = new Font("�ө���", Font.PLAIN, 36);// �إߦr���H�A�r��j�p��36
        g.setFont(font);// �]�w�r��
        g.drawString("�r��j�p��36", 30, 120);// ø�s�¤�r
    }
}
