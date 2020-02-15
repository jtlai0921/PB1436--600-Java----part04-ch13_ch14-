package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class SubtractOperationApplet extends Applet {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;// �j���ରGraphics2D�ﹳ
        Rectangle2D.Float rect1 = new Rectangle2D.Float(80, 20, 160, 160);// �إ߯x�ιﹳ
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(130, 80, 140, 140);// �إ߾��ﹳ
        Area area1 = new Area(rect1);// �إ߰ϰ�x��
        Area area2 = new Area(ellipse1);// �إ߰ϰ���
        area1.subtract(area2);// ��Ӱϰ�ϧά۴�
        g2d.fill(area1);// ø�s�۴�᪺�ϰ�ϧ�
        Rectangle2D.Float rect2 = new Rectangle2D.Float(240, -35, 120, 120);// �إ߯x�ιﹳ
        Ellipse2D.Float ellipse2 = new Ellipse2D.Float(290, 20, 160, 160);// �إ߾��ﹳ
        Area area3 = new Area(rect2);// �إ߯x�ΰϰ�
        Area area4 = new Area(ellipse2);// �إ߾���H���ϰ�ϧ�
        area4.subtract(area3);// ��Ӱϰ�ϧά۴�
        g2d.fill(area4);// ø�s�۴�᪺�ϰ�ϧ�
    }
}
