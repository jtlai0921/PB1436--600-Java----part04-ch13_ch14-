package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class ChangeTextColorApplet extends Applet implements Runnable {
    Color color = new Color(0, 0, 255);// �إ��C��ﹳ
    public void init() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        Graphics2D g2 = (Graphics2D) g;// �ରGraphics2D���A
        String value = "�|�ܦ⪺��r";// ø�s���¤�r
        int x = 10; // �¤�r��m����y��
        int y = 110; // �¤�r��m���a�y��
        Font font = new Font("����", Font.BOLD, 40); // �إߦr��ﹳ
        g2.setFont(font); // �]�w�r��
        g2.setColor(color);// �]�w�C��
        g2.drawString(value, x, y); // ø�s�¤�r
    }
    public void run() {
        Random random = new Random();// �إ��H���ƹﹳ
        while (true) {
            int R = random.nextInt(256);// �H�������C�⪺R��
            int G = random.nextInt(256);// �H�������C�⪺G��
            int B = random.nextInt(256);// �H�������C�⪺B��
            color = new Color(R, G, B);// �إ��C��ﹳ
            repaint();// �I�spaint()��k
            try {
                Thread.sleep(300);// ��v300�@��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
