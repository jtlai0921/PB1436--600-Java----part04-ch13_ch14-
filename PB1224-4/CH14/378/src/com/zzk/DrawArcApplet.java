package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawArcApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�e��";
        int x = 35;// ����m����y��
        int y = 65;// ����m���a�y��
        int l = 150;// ��������
        int width = 80;// �����e��
        int startAngle = 10;// �����_�l����
        int endAngle = -120;// �פ�e���e���L������
        g.setColor(Color.red);// �]�w�C��
        g.drawArc(x + 20, y, l, width, startAngle, endAngle);// ø�s��
        
        int x0 = 5;// ����m����y��
        int y0 = 40;// ����m���a�y��
        int l0 = 180;// ��������
        int width0 = 120;// �����e��
        int startAngle0 = 70;// �����_�l����
        int endAngle0 = 180;// �פ�e���e���L������
        g.setColor(Color.red);// �]�w�C��
        g.drawArc(x0 + 20, y0, l0, width0, startAngle0, endAngle0);// ø�s��
        
        int x1 = 19;// ����m����y��
        int y1 = 90;// ����m���a�y��
        int l1 = 200;// ��������
        int width1 = 100;// �����e��
        int startAngle1 = 5;// �����_�l����
        int endAngle1 = 300;// �פ�e���e���L������
        g.setColor(Color.red);// �]�w�C��
        g.drawArc(x1 + 20, y1, l1, width1, startAngle1, endAngle1);// ø�s��
        g.drawString(value, 195, 160);
        
    }
}
