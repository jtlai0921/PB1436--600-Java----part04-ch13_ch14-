package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class RollTextApplet extends Applet implements Runnable {
    String value = "����ϮѺ������}�Ghttp://www.mingribook.com";// �s��ø�s�����e
    int x;// �]�w��y��
    int y;// �]�w�a�y��
    public void init() { // ��l�Ƥ�k
        x = 316;// �x�sø�s�I��x�y��
        y = 190;// �x�sø�s�I��y�y��
    }
    public void start() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) {
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD3.jpg");// ��o�Ϥ��귽���|
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);// ø�s�ϧ�
        g.clearRect(0, 0, 0, 230);// �M��ø�ϤW�U�媺���e
        g.setColor(Color.BLACK);// �w�q�C��
        Font font = new Font("�ؤ巢��", Font.BOLD, 20);// �إߦr��ﹳ
        g.setFont(font);// �w�q�r��
        g.drawString(value, x, y);// ø�s�¤�r
    }
    public void run() {
        try {
            while (true) { // Ū�����e
                Thread.sleep(50); // �ثe�u�{��v1��
                if (x <= -440) {// �ӱ���i�H�ھڻݭn�ۦ�վ�
                    x = 316;// x�y�Щw���̥k��
                } else {
                    x -= 2;// x�y�Х���
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