package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ShowParamApplet extends Applet {
    String id;// �ŧi�����ܼ�
    String name;// �ŧi�����ܼ�
    String sex;// �ŧi�����ܼ�
    public void init() {
        id = getParameter("id");// ��o�Ѽ�id����
        name = getParameter("name");// ��o�Ѽ�name����
        sex = getParameter("sex");// ��o�Ѽ�sex����
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);// �]�w�C��
        g.drawString("�Ǹ��G", 30, 10);// ø�s�¤�r
        g.drawString(id, 70, 10);// ø�s��o��id��
        g.drawString("�m�W�G", 30, 30);// ø�s�¤�r
        g.drawString(name, 70, 30);// ø�s��o��name��
        g.drawString("�ʧO�G", 30, 50);// ø�s�¤�r
        g.drawString(sex, 70, 50);// ø�s��o��sex��
    }
}
