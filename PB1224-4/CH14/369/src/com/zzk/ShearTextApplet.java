package com.zzk;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ShearTextApplet extends Applet {
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        Graphics2D g2 = (Graphics2D) g;// �ରGraphics2D���A
        String value = "�ɱפ�r";// ø�s���¤�r
        int x = 10; // �¤�r��m����y��
        int y = 190; // �¤�r��m���a�y��
        Font font = new Font("�ؤ�淢", Font.BOLD, 72); // �إߦr��ﹳ
        g2.setFont(font); // �]�w�r��
        g2.shear(0.1, -0.4);// �ɱ׵e��
        g2.drawString(value, x, y); // ø�s�¤�r
    }
}
