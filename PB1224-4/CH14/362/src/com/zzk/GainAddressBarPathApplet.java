package com.zzk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

public class GainAddressBarPathApplet extends Applet {
    URL url;// �ŧiURL�ﹳ
    public void start() {
        url = this.getDocumentBase();// ��o�a�}��W���|��URL�ﹳ
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);// �]�w�C��
        g.drawString(url.getFile(), 30, 20);// ø�s�a�}��W�����|
    }
}
