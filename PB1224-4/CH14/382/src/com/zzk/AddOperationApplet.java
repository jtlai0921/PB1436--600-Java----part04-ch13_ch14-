package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class AddOperationApplet extends Applet {
    public void paint(Graphics g) {
        String value = "�ϧάۥ[�B��";
        Graphics2D g2d = (Graphics2D) g;// p�ର�i�Ϊ�Graphics2D�ﹳ
        Rectangle2D.Float rect1 = new Rectangle2D.Float(20, 70, 185, 60);// �إ߯x�ιﹳ
        Rectangle2D.Float rect2 = new Rectangle2D.Float(120, 20, 65, 160);// �إ߯x�ιﹳ
        Area area1 = new Area(rect1);// �إ߰ϰ�x��
        Area area2 = new Area(rect2);// �إ߰ϰ�x��
        area1.add(area2);// ��Ӱϰ�i��ۥ[
        g2d.draw(area1);// ø�s�ۥ[�᪺�ϰ�x��
        Rectangle2D.Float rect3 = new Rectangle2D.Float(230, 70, 185, 60);// �إ߯x�ιﹳ
        Rectangle2D.Float rect4 = new Rectangle2D.Float(290, 20, 65, 160);// �إ߯x�ιﹳ
        Area area3 = new Area(rect3);// �إ߰ϰ�x��
        Area area4 = new Area(rect4);// �إ߰ϰ�x��
        area3.add(area4);// ��Ӱϰ�i��ۥ[
        g2d.draw(area3);// ø�s�ۥ[�᪺�ϰ�x��
        g2d.drawString(value, 25, 56);// ø�s�¤�r
    }
}
