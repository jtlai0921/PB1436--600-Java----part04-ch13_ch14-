package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetFontStyleApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("�ө���", Font.PLAIN, 16);// �إߦr���H�A�r��˦������q�r��
        g.setFont(font);// �]�w�r��
        g.drawString("���q�r��", 30, 20);// ø�s�¤�r
        font = new Font("�ө���", Font.ITALIC, 22);// �إߦr���H�A�r��˦����ɱצr��
        g.setFont(font);// �]�w�r��
        g.drawString("�ɱצr��", 30, 60);// ø�s�¤�r
        font = new Font("�ө���", Font.BOLD, 28);// �إߦr���H�A�r��˦�������r��
        g.setFont(font);// �]�w�r��
        g.drawString("����r��", 30, 120);// ø�s�¤�r
    }
}
