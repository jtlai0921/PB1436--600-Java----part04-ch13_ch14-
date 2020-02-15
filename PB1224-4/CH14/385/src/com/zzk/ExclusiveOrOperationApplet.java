package com.zzk;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class ExclusiveOrOperationApplet extends Applet {
    public void paint(Graphics g) { // ���s�w�qpaint()��k
        Graphics2D g2d = (Graphics2D) g; // �j���ରGraphics2D�ﹳ
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(30, 80, 180, 80);// �إ߾��ﹳ
        Ellipse2D.Float ellipse2 = new Ellipse2D.Float(80, 30, 80, 180);// �إ߾��ﹳ
        Area area1 = new Area(ellipse1);// �إ߾��ϰ�
        Area area2 = new Area(ellipse2);// �إ߾��ϰ�
        area1.exclusiveOr(area2);// ��Ӱϰ�ϧζi�椬���B��
        g2d.fill(area1);// ø�s�����B��᪺�ϰ�ϧ�
        Ellipse2D.Float ellipse3 = new Ellipse2D.Float(270, 80, 180, 80);// �إ߾��ﹳ
        Ellipse2D.Float ellipse4 = new Ellipse2D.Float(270, 30, 80, 180);// �إ߾��ﹳ
        Area area3 = new Area(ellipse3);// �إ߾��ϰ�
        Area area4 = new Area(ellipse4);// �إ߾��ϰ�
        area3.exclusiveOr(area4);// ø�s�����B��᪺�ϰ�ϧ�
        g2d.fill(area3);// ø�s�����B��᪺�ϰ�ϧ�
    }
}
