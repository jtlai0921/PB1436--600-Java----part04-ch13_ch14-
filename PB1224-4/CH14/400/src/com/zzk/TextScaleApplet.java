package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class TextScaleApplet extends Applet implements Runnable {
    public void start() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    private Image img = null; // �ŧi�ϧιﹳ
    boolean flag = false;// �w�q�аO�ܼ�,�ϥΪ̱���x����
    int x = 12;// �w�q��ܦr��j�p���ܼ�x
    Font font = new Font("�ؤ巢��", Font.BOLD, 42);// �إߦr��ﹳ
    public void paint(Graphics g) {
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// ��o�Ϥ��귽�����|
        Graphics2D g2 = (Graphics2D) g;// ��oGraphics2D�ﹳ
        g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);// ø�s�ϧ�
        g2.setFont(font);// ���w�r��
        g2.setColor(Color.red);// ���w�C��
        g2.drawString("�ǵL���", 30, 120);// ø�s�¤�r
    }
    public void run() {
        while (true) {
            if (flag) { // flag��true��
                x -= 2; // x�i���1�p��
                if (x <= 12) {// x�p�󵥩�12��
                    x = 12; // x����12
                    flag = false;// ��flag�����Ȭ�false
                }
            } else {// flag��false��
                x += 2;// x�i��[1�p��
                if (x >= 72) {// x�j�󵥩�72��
                    x = 72;// x����72
                    flag = true;// ��flag�����Ȭ�true
                }
            }
            font = new Font("�ؤ巢��", Font.BOLD, x);// ���s�إߦr��ﹳ
            repaint();// �I�spaint()��k
            try {
                Thread.sleep(50);// ��v50�@��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//    public void update(Graphics g) {
//        paint(g);
//    }
}
