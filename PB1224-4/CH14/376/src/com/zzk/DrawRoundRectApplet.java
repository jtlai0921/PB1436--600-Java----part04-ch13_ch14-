package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawRoundRectApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�e�ꨤ�x��";
        int x = 20;// �ꨤ�x�Φ�m����y��
        int y = 20;// �ꨤ�x�Φ�m���a�y��
        int width = 70;// �ꨤ�x�μe��
        int height = 129;// �ꨤ�x�ΰ���
        int xr = 5;                         // �ꨤ�x�ζꨤ����������
        int yr = 7;                         // �ꨤ�x�ζꨤ����������

        g.setColor(Color.blue);// �]�w�C��
        g.drawRoundRect(x, y, width, height, xr, yr); // ø�s�ϧ�
        
        int x0 = 35; // �ꨤ�x�Φ�m����y��
        int y0 = 35; // �ꨤ�x�Φ�m���a�y��
        int width0 = 82; // �ꨤ�x�μe��
        int height0 = 139; // �ꨤ�x�ΰ���
        int xr0 = 10; // �ꨤ�x�ζꨤ����������
        int yr0 = 12; // �ꨤ�x�ζꨤ����������
        g.setColor(Color.blue);// �]�w�C��
        g.drawRoundRect(x0, y0, width0, height0, xr0, yr0);// ø�s�ϧ�
        
        int x1 = 59;// �ꨤ�x�Φ�m����y��
        int y1 = 59;// �ꨤ�x�Φ�m���a�y��
        int width1 = 92;// �ꨤ�x�μe��
        int height1 = 151;// �ꨤ�x�ΰ���
        int xr1 = 20;// �ꨤ�x�ζꨤ����������
        int yr1 = 22;// �ꨤ�x�ζꨤ����������
        g.setColor(Color.blue);// �]�w�C��
        g.drawRoundRect(x1, y1, width1, height1, xr1, yr1);// ø�s�ϧ�
        g.drawString(value, 165, 30);// ø�s�¤�r
    }
}
