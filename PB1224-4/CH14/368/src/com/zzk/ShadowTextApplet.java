package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ShadowTextApplet extends Applet {
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        String value = "���v��r";
        int x = 10; // �¤�r��m����y��
        int y = 120; // �¤�r��m���a�y��
        Font font = new Font("�ؤ�淢", Font.BOLD, 80); // �إߦr��ﹳ
        g.setFont(font); // �]�w�r��
        g.setColor(Color.GRAY);// �]�w�C�⬰�Ǧ�
        g.drawString(value, x, y); // ø�s�¤�r
        x += 3;// �վ�ø�s�I����y�Э�
        y += 3;// �վ�ø�s�I���a�y�Э�
        g.setColor(Color.BLACK);// �]�w�C��¦�
        g.drawString(value, x, y); // ø�s�¤�r
    }
}
