package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class DrawGrainApplet extends Applet {
    private BufferedImage img;// �ŧi�ϧιﹳ
    public void init() { // ��l�Ƥ�k
        img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);// �إ߽w�Ĺﹳ
        Graphics2D g = img.createGraphics();// �إ�Graphics2D�ﹳ
        g.setPaint(Color.yellow);// ���w�C��
        g.draw(new Rectangle(0, 0, 25, 25));// ø�s�x��
        g.setPaint(Color.red);// ���w�C��
        g.fill(new Rectangle(25, 0, 25, 25));// ��R�x��
        g.setPaint(Color.green);// ���w�C��
        g.fill(new Rectangle(0, 0, 25, 25));// ��R�x��
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;// �j���ରGraphics2D�ﹳ
        g2d.setPaint(new TexturePaint(img, new Rectangle(0, 0, 10, 10)));// �إ߯��z�ç⥦�[��Graphics��
        g2d.fill(new Ellipse2D.Double(10, 10, 260, 145));// ��R�ϧ�
    }
}
