package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class HorseRaceLightTextApplet extends Applet implements Runnable {
    public void start() {
        Thread thread = new Thread(this);// �إ߽u�{
        thread.start();// �Ұʽu�{�ﹳ
    }
    String value = "�֦��s�{����A�ǲ߽s�{�u���P�C";// �x�sø�s�����e
    char[] drawChar = value.toCharArray();// �Nø�s���e�ର�r�Ű}�C
    int[] x = new int[drawChar.length];// �x�s�C�Ӧr��ø�s�Ix�y�Ъ��}�C
    int y = 100;// �x�sø�s�Iy�y��
    
    public void paint(Graphics g) {
        Image img = null;
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg"); // �إ߹ϧιﹳ
        g.clearRect(0, 0, getWidth(), getHeight());// �M��ø�ϤW�U�夺�e
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// ø�s�ϧ�
        Font font = new Font("�ؤ巢��", Font.BOLD, 20);// �إߦr��ﹳ
        g.setFont(font);// ���w�r��
        g.setColor(Color.RED);// ���w�C��
        for (int j = drawChar.length - 1; j >= 0; j--) {
            g.drawString(drawChar[drawChar.length - 1 - j] + "", x[j], y);// ø�s�¤�r
        }
    }
    public void run() {
        boolean flag = false;// ��false�ɪ�ܲĤ@������,x�y�жi�浥�񻼼W,�_�h�i�浥�t����
        while (true) {// Ū�����e
            try {
                for (int i = drawChar.length - 1; i >= 0; i--) {
                    if (!flag) {
                        x[i] = x[i] + 20 * i;// x�y�жi�浥�񻼼W
                    } else {
                        x[i] = x[i] + 20;// x�y�жi�浥�񻼴�
                    }
                    if (x[i] >= 360 - 20) {// �j����e�״�20���Ȯ�
                        x[i] = 0; // x�y�Ь�0
                    }
                }
                repaint();// �I�s paint()��k
                if (!flag) {
                    flag = true;// �����Ȭ�true;
                }
                Thread.sleep(1000);// �ثe�u�{��v300�@��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Graphics g) { // ���s�w�qupdate()��k����{�{
        paint(g);
    }
}
