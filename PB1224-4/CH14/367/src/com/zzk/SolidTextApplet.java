package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SolidTextApplet extends Applet {
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        String value = "�����r�ĪG";
        int x = 10; // �¤�r��m����y��
        int y = 120; // �¤�r��m���a�y��
        Font font = new Font("�ө���", Font.BOLD, 72); // �إߦr��ﹳ
        g.setFont(font); // �]�w�r��
        g.setColor(Color.GRAY);// �]�w�C�⬰�Ǧ�
        int i = 0;// �`���ܼ�
        while (i < 8) {
            g.drawString(value, x, y); // ø�s�¤�r
            x += 1;// �վ�ø�s�I����y�Э�
            y += 1;// �վ�ø�s�I���a�y�Э�
            i++;// �վ�`���ܼƪ���
        }
        g.setColor(Color.BLACK);// �]�w�C��¦�
        g.drawString(value, x, y); // ø�s�¤�r
    }
}
