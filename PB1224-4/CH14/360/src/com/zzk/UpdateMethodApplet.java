package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class UpdateMethodApplet extends Applet {
    boolean flag = false;// �w�q�аO�ܼ�
    public void start() {
        repaint();// ���s�I�spaint��k
    }
    public void paint(Graphics g) {
        g.setColor(Color.RED);// �]�w�C��
        g.drawString("�o�O�ϥ�paint()��kø�s���¤�r�C", 30, 120);// ø�s�¤�r
        g.setColor(Color.BLUE);// �]�w�C��
        g.drawString("�U���O�ϥ�paint()��kø�s���ϧΡC", 30, 140);// ø�s�¤�r
        g.drawRect(30, 150, 50, 40);// ø�s�x��
        update(g);// �I�supdatae��k
    }
    public void update(Graphics g) {
        if (flag) {
            g.clearRect(0, 0, 300, 220);// �аO�ܼƬ�true��,�M�����e
            flag = false;// �]�w�аO�ܼƬ�false
        } else {
            flag = true;// �]�w�аO�ܼƬ�true
        }
        g.setColor(Color.BLUE);// �]�w�C��
        g.drawString("�o�O�ϥ�updatePaint()��kø�s���¤�r�C", 30, 20);// ø�s�¤�r
        g.setColor(Color.RED);// �]�w�C��
        g.drawString("�U���O�ϥ�updatePaint()��kø�s���ϧΡC", 30, 40);// ø�s�¤�r
        g.drawRect(30, 50, 50, 40);// ø�s�x��
    }
}
