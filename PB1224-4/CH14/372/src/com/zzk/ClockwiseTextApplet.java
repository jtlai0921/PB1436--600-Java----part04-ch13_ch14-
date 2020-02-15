package com.zzk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class ClockwiseTextApplet extends JApplet {
    private JTextField textField;
    ClockwiseTextPanel clockwiseTextPanel = new ClockwiseTextPanel(); // �إ߭��O���O�����
    public void init() {
        setLayout(new BorderLayout());
        add(clockwiseTextPanel); // �N���O���O����ҼW�[�쵡��e����
        textField = new JTextField();
        textField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent arg0) {
                String text = textField.getText();// ��o�¤�r�ئr��
                clockwiseTextPanel.setText(text);// �����O����text�ܼƵ�����
            }
        });
        getContentPane().add(textField, BorderLayout.SOUTH);
    }
    class ClockwiseTextPanel extends JPanel { // �إߤ������O���O
        private String text;
        public ClockwiseTextPanel() {
            setOpaque(false);// �]�w���O���z��
            setLayout(null);// �]�w������G��
        }
        public String getText() {
            return text; // ��o�����ܼƪ���
        }
        public void setText(String text) {
            this.text = text;// �������ܼƵ�����
            repaint();// �վ�paint()��k
        }
        public void paint(Graphics g) {// ���s�w�qpaint()��k
            Graphics2D g2 = (Graphics2D) g;// ��oGraphics2D�����
            int width = getWidth();// ��o���O���e��
            int height = getHeight();// ��o���O������
            if (text != null) {
                char[] array = text.toCharArray();// �N�¤�r�ର�r�Ű}�C
                int len = array.length * 5;// �w�q�ꪺ�b�|�A�P�ɥi�H�վ��r���Z��
                Font font = new Font("�ө���", Font.BOLD, 22);// �إߦr��
                g2.setFont(font);// �]�w�r��
                double angle = 0;// �w�q��l����
                for (int i = 0; i < array.length; i++) {// �ˬd�r�ꤤ���r��
                    if (i == 0) {
                        g2.setColor(Color.BLUE);// �Ĥ@�Ӧr�ť��Ŧ�
                    } else {
                        g2.setColor(Color.BLACK);// ��L�r�ťζ¦�
                    }
                    int x = (int) (len * Math.sin(Math.toRadians(angle + 270)));// �p��C�Ӥ�r����y�Ц�m
                    int y = (int) (len * Math.cos(Math.toRadians(angle + 270)));// �p��C�Ӥ�r���a�y�Ц�m
                    g2.drawString(array[i] + "", width / 2 + x, height / 2 - y);// ø�s�r��
                    angle = angle + 360d / array.length;// ���ܨ���
                }
            }
        }
    }
}
