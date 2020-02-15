package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawPasswordWithDisturbApplet extends Applet {
    int WIDTH = 120;// �]�w�e��
    int HEIGHT = 35;// �]�w����
    private String num = "";// ���ҽX
    Random random = new Random();// ��Ҥ�Random
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);// ��Ҥ�BufferedImage
        Graphics gs = image.getGraphics(); // ��oGraphics���O���ﹳ
        if (!num.isEmpty()) {
            num = "";// �M�����ҽX
        }
        Font font = new Font("����", Font.BOLD, 20); // �z�LFont�غc�r��
        gs.setFont(font);// �]�w�r��
        gs.fillRect(0, 0, WIDTH, HEIGHT);// ��R�@�ӯx��
        Image img = null;
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg"); // �إ߹ϧιﹳ
        gs.drawImage(img, 0, 0, WIDTH, HEIGHT, this);// �b�w�Ĺϧιﹳ�Wø�s�ϧ�
        int startX1 = random.nextInt(20);// �H����o�Ĥ@���z�Z�u�_�I��x�y��
        int startY1 = random.nextInt(20);// �H����o�Ĥ@���z�Z�u�_�I��y�y��
        int startX2 = random.nextInt(30) + 35;// �H����o�Ĥ@���z�Z�u���I��x�y�СA�]�O�ĤG���z�Z�u�_�I��x�y��
        int startY2 = random.nextInt(10) + 20;// �H����o�Ĥ@���z�Z�u���I��y�y�СA�]�O�ĤG���z�Z�u�_�I��y�y��
        int startX3 = random.nextInt(30) + 90;// �H����o�ĤG���z�Z�u���I��x�y��
        int startY3 = random.nextInt(10) + 5;// �H����o�ĤG���z�Z�u���I��y�y��
        gs.setColor(Color.RED);
        gs.drawLine(startX1, startY1, startX2, startY2);// ø�s�Ĥ@���z�Z�u
        gs.setColor(Color.BLUE);
        gs.drawLine(startX2, startY2, startX3, startY3);// ø�s�ĤG���z�Z�u
        for (int i = 0; i < 4; i++) {// ��X�H�������Ҥ�r
            char ctmp = (char) (random.nextInt(26) + 65); // ����A~Z���r��
            num += ctmp;// ��s���ҽX
            Color color = new Color(20 + random.nextInt(120), 20 + random
                    .nextInt(120), 20 + random.nextInt(120));// �����H���C��
            gs.setColor(color); // �]�w�C��
            Graphics2D gs2d = (Graphics2D) gs;// �N��r������w����
            AffineTransform trans = new AffineTransform();// ��Ҥ�AffineTransform
            trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
            float scaleSize = random.nextFloat() + 0.8f;// �Y���r
            if (scaleSize > 1f)
                scaleSize = 1f;// �p�GscaleSize�j��1,�h�Ϩ䵥��1
            trans.scale(scaleSize, scaleSize); // �i���Y��
            gs2d.setTransform(trans);// �]�wAffineTransform�ﹳ
            gs2d.drawString(String.valueOf(ctmp), WIDTH / 6 * i + 28, HEIGHT / 2);// �e�X���ҽX
        }
        g.drawImage(image, 85, 80, null);// �b�p���ε{����ø�s�t���Ϥ��M�z�Z�u���ҽX���w�Ĺϧ�
    }
}