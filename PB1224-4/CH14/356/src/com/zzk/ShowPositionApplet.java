package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class ShowPositionApplet extends Applet {
    String author;// �ŧi�����ܼ�
    public void init() {
        author = "ZhenKun Zhang";// ��l�Ʀ����ܼ�
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);// �]�w�C��
        g.drawString(author, 50, 30);// ø�s�¤�r
    }
}
