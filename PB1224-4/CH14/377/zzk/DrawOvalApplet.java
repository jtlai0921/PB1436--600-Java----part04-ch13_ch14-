package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class DrawOvalApplet extends Applet{
	public void paint(Graphics g){
		String value = "�e���";
		int x = 25;// ����m��y��
		int y = 40;// ����m
		int xr = 150;// ��ꪺ��y�Хb�|
		int yr = 150;// ��ꪺ�a�y�Хb�|
		g.drawOval(x, y, xr, yr);// ø�s���
		
		int x0 = 67;// ����m��y��
		int y0 = 40;// ����m
		int xr0 = 65;// ��ꪺ��y�Хb�|
		int yr0 = 150;// ��ꪺ�a�y�Хb�|
		g.setColor(Color.blue);// �]�w�C��
		g.drawOval(x0, y0, xr0, yr0);// ø�s���
		g.drawString(value, 150, 210);// ø�s�¤�r
		
	}
}
