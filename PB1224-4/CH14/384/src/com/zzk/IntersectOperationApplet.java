package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class IntersectOperationApplet extends Applet {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;// �j���ରGraphics2D�ﹳ
        Rectangle2D.Float rect1 = new Rectangle2D.Float(0, 40, 140, 140);// �إ߯x�ιﹳ
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(80, 40, 140, 140);// �إ߾��ﹳ
        Area area1 = new Area(rect1);// �إ߯x�ΰϰ�
        Area area2 = new Area(ellipse1);// �إ߾��ϰ�
        area1.intersect(area2);// ��Ӱϰ�ۥ�
        g2d.fill(area1);// ø�s�ۥ�᪺�ϰ�ϧ�
        Rectangle2D.Float rect2 = new Rectangle2D.Float(240, 0, 160, 160);// �إ߯x�ιﹳ
        Ellipse2D.Float ellipse2 = new Ellipse2D.Float(190, 60, 140, 140);// �إ߾��ﹳ
        Area area3 = new Area(rect2);// �إ߯x�ΰϰ�
        Area area4 = new Area(ellipse2);// �إ߾��ϰ�
        area3.intersect(area4);// ��Ӱϰ�ۥ�
        g2d.fill(area3);// ø�s�ۥ�᪺�ϰ�ϧ�
    }
}
