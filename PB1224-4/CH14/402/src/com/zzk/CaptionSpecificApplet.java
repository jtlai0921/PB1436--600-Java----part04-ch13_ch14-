package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class CaptionSpecificApplet extends Applet implements Runnable {
    int x = 50;// �x�sø�s�I��x�y��
    int y = 216;// �x�sø�s�I��y�y��
    String value = "����ϮѺ������}";// �x�sø�s�����e
    public void start() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) {
        g.clearRect(0, 0, 316, 237);// �M��ø�ϤW�U�夺�e
        Image img = null;// �ŧi�Ϥ��ﹳ
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// ø�s�ϧ�
        Font font = new Font("�ؤ巢��", Font.BOLD, 20);// �إߦr��ﹳ
        g.setFont(font);// ���w�r��
        g.setColor(Color.RED);// ���w�C��
        g.drawString(value, x, y);// ø�s�¤�r
    }
    public void run() {
        try {
            while (true) { // Ū�����e
                Thread.sleep(100); // �ثe�u�{��v1��
                if (y <= 216 - 50) {// �p�G�w�g�V�W����50����
                    y = 216;// y�y�Щw���̤U��
                    if (value.equals("����ϮѺ������}")) {
                        value = "http://www.mingribook.com";// ����ø�s�����e
                    } else {
                        value = "����ϮѺ������}";// ����ø�s�����e
                    }
                } else {// �p�G�٨S�V�W���ʨ�50����
                    y -= 2;// y�y�ФW��
                }
                repaint();// �I�spaint()��k
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Graphics g) { // ���s�w�qupdate()��k����{�{
        paint(g);
    }
}
