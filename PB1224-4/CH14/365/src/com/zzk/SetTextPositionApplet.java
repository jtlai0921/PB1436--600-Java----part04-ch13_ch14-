package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class SetTextPositionApplet extends Applet {
    public void paint(Graphics g) {
        Font font = new Font("�ө���", Font.PLAIN, 32);// �إߦr��ﹳ
        g.setFont(font);// �]�w�r��
        g.drawString("���D", 65, 40);// ø�s�¤�r�A���m�y�Ь�(65�A40)
        font = new Font("�ө���", Font.PLAIN, 16);// �إߦr��ﹳ
        g.setFont(font);// �]�w�r��
        g.drawString("����@�����e", 50, 80);// ø�s�¤�r�A���m�y�Ь�(50�A80)
        g.drawString("����G�����e", 50, 120);// ø�s�¤�r�A���m�y�Ь�(50�A120)
        g.drawString("����T�����e", 50, 160);// ø�s�¤�r�A���m�y�Ь�(50�A160)
    }
}
