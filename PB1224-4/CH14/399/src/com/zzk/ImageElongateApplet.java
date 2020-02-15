package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class ImageElongateApplet extends Applet implements Runnable {
    private boolean flag = true;// �ŧi�аO�ܼ�
    private static float xw;// �w�q�վ�ϧμe�ת��ܼ�
    public void init(){
        xw = 0.5f;// ��l�ƹϧμe��
    }
    public void start(){
        Thread th = new Thread(this);// �إ߽u�{�ﹳ
        th.start();// �Ұʽu�{�ﹳ
    }
    public void paint(Graphics g) {
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PD4.jpg");// ��o�Ϥ���T
        int w = img.getWidth(this);// �]�w�ϧΪ��e��
        int h = img.getHeight(this);// �]�w�ϧΪ�����
        Graphics2D g2d = (Graphics2D) g;// �Ng�ର�i�H�Q�Ϊ�Graphics2D
        g2d.drawImage(img, w - 50, h, this);// ø�s�ϧ�
        AffineTransform tr = new AffineTransform(xw, 0, 0, 1, 150, h);// �إߥ�g�ܴ��ﹳ�i��]�w�ܴ��]�Ĥ@�ӰѼơ^
        g2d.drawImage(img, tr, this);// ø�s�ϧ�
        
    }
    @Override
    public void run() {
        while (true) {
            if (flag) {// �аO�ܼƬ�true�ɰ���
                xw += 0.1f;// �ϼe���ܤj
                if (xw > 2.0f) {// �e�פj��2.0��
                    flag = false;// �аO�ܼƬ�false
                }
            } else {// �аO�ܼƬ�false�ɰ���
                xw -= 0.1f;// �ϼe���ܤp
                if (xw < 0.5f) {// �e�פp��2.0��
                    flag = true;// �аO�ܼƬ�true
                }
            }
            try {
                Thread.sleep(200);// ��v200�@��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();// ���s�I�spaint()��k
        }
    }
}
