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

public class DrawPasswordWithImageApplet extends Applet {
    int WIDTH = 120;// �e��
    int HEIGHT = 35;// ����
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
        Image img = null;// �ŧi�ϧιﹳ
        img = getImage(getCodeBase(), "com/zzk/PPD.jpg"); // �إ߹ϧιﹳ
        gs.drawImage(img, 0, 0, WIDTH, HEIGHT, this);// �b�w�Ĺϧιﹳ�Wø�s�ϧ�
        // ��X�H�������Ҧr��
        for (int i = 0; i < 4; i++) {
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
                scaleSize = 1f;// �p�GscaleSize�j��1,�h����1
            trans.scale(scaleSize, scaleSize); // �i���Y��
            gs2d.setTransform(trans);// �]�wAffineTransform�ﹳ
            gs2d.drawString(String.valueOf(ctmp), WIDTH / 6 * i + 28, HEIGHT / 2);// �e�X���ҽX
        }
        g.drawImage(image, 85, 80, null);// �b�p���ε{����ø�s�t���Ϥ����ҽX���w�Ĺϧ�
    }
}