package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class TextFlashApplet extends Applet implements Runnable {
    boolean flag = true;// �аO�ܼ�
    String value = "";// �s��ø�s���e���ܼ�
    public void start() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) {
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");
        g.clearRect(0, 0, 310, 230);// �M��ø�ϤW�U�媺���e
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        Font font = new Font("�ؤ巢��", Font.BOLD, 42);// �إߦr��ﹳ
        g.setFont(font);// ���w�r��
        g.setColor(Color.red);// ���w�C��
        g.drawString(value, 30, 110);// ø�s�¤�r
    }
    public void run() {
        try {
            while (true) { // Ū�����e
                Thread.sleep(150);// �ثe�u�{��v150��
                if (flag) {// flag��true
                    flag = false; // �����Ȭ�false
                    value = "JAVA�s�{����";// ��value������
                } else {
                    flag = true;// �����Ȭ�true
                    value = "";// �����Ȭ��Ŧr��«
                }
                repaint();// �I�spaint()��k
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
