package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GradientTextApplet extends Applet {
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        Graphics2D g2 = (Graphics2D) g;// �ରGraphics2D���A
        String value = "���h���r";// ø�s���¤�r
        int x = 15; // �¤�r��m����y��
        int y = 120; // �¤�r��m���a�y��
        Font font = new Font("����", Font.BOLD, 60); // �إߦr��ﹳ
        g2.setFont(font); // �]�w�r��
        GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100, 120,
                Color.RED, true);// �إߴ`�����h��GradientPaint�ﹳ
        g2.setPaint(paint);// �]�w���h
        g2.drawString(value, x, y); // ø�s�¤�r
    }
}
