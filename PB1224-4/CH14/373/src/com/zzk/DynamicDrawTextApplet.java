package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DynamicDrawTextApplet extends Applet implements Runnable {
    int x = 20;// �_�l�I��x�y��
    int y = 30;// �_�l�I��y�y��
    String textStrings = "�p���ε{�����Y��ϧ�\n�p���ε{����½��ϧ�\n�p���ε{��������ϧ�\n�p���ε{�����ɱ׹ϧ�";// �ݭn�ʺAø�s���r��
    String value = "";// �x�s�r�ꤤ����@�r��
    public void init() {
        Thread thread = new Thread(this);// �إ߽u�{�ﹳ
        thread.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) {
        Font font = new Font("�ؤ巢��", Font.BOLD, 20);// �إߦr��ﹳ
        g.setFont(font);// ���w�r��
        g.setColor(Color.RED);// ���w�C��
        g.drawString(value, x, y);// ø�s�¤�r
    }
    public void update(Graphics g) {// ���s�w�qupdate��k�A����L�k���ø�s���Ҧ����e
        paint(g);// �I�spaint()��k
    }
    public void run() {
        try {
            for (int i = 0; i < textStrings.length(); i++) {
                Thread.sleep(400); // �ثe�u�{��v400�@��
                value = textStrings.substring(i, i + 1);// �I���r�ꤤ���@�Ӧr��
                if (value.equals("\n")) {// �O�����
                    x = 20;// �U�@��_�l�I��x�y��
                    y += 30;// �U�@��¤�r��y�y��
                } else {// ���O�T�{�δ����
                    x += 20;// �ثe��U�@�Ӧr��x�y��
                }
                repaint();// �I�spaint()��k
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
