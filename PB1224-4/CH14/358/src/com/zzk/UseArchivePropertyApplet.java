package com.zzk;

import javax.swing.JApplet;

public class UseArchivePropertyApplet extends JApplet {
    public void init() {
        // �ϥλPhtml�ɮ����p��NewPanelApp.jar�ɮפ���NewPanel���O�إ߹ﹳ
        npanel.NewPanel npanel = new npanel.NewPanel();
        setLayout(null);// �]�w�e��������G��
        npanel.setBounds(10, 10, 254, 167);// �]�wNewPanel��H����ܦ�m�M�j�p
        add(npanel);// �NNewPanel�ﹳ�W�[��e����
    }
}
