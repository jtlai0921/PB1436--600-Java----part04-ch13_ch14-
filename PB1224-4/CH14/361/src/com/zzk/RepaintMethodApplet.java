package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class RepaintMethodApplet extends Applet {
    static int iFlag = 0;// �w�q�аO�ܼ�
    public void start() {
        iFlag++;// �վ�аO�ܼƪ���
        repaint();// ���s�I�spaint()��k
    }
    public void paint(Graphics g) {
        if (iFlag == 1) {
            g.drawString("�o�O�ϥ�paint()��kø�s���¤�r�C", 30, 60);// ø�s�¤�r
        } else if (iFlag == 2) {
            g.setColor(Color.RED);// �]�w�C��
            g.drawString("�U���O�ϥ�paint()��kø�s���ϧΡC", 30, 60);// ø�s�¤�r
            g.drawRect(30, 80, 50, 40);// ø�s�x��
        } else if (iFlag == 3) {
            g.setColor(Color.BLUE);// �]�w�C��
            g.drawString("�U���O�ϥ�paint()��kø�s���ϧΡC", 30, 60);// ø�s�¤�r
            g.drawRect(30, 80, 50, 40);// ø�s�x��
        } else {
            g.setColor(Color.GREEN);// �]�w�C��
            g.drawString("�U���O�ϥ�paint()��kø�s���ϧΡC", 30, 60);// ø�s�¤�r
            g.drawRect(30, 80, 50, 40);// ø�s�x��
        }
    }
}
