package npanel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class NewPanel extends JPanel {
    private JTextField textField;// �ŧi�¤�r��
    public NewPanel() {
        super();// �I�s�W���O���غc��k
        setLayout(null);// �]�w���O������G��
        setBounds(100, 100, 254, 167);// �]�w���O����m�M�j�p
        final JButton button = new JButton();// �إ߫��s
        button.setText("���s�@");// ���w���s���D
        button.setBounds(38, 86, 73, 28);// ���w���s�b���O������ܦ�m�M�j�p
        add(button);// �N���s�W�[�쭱�O�W
        final JButton button_1 = new JButton();// �إ߫��s
        button_1.setText("���s�G");// ���w���s���D
        button_1.setBounds(140, 86, 73, 28);// ���w���s�b���O������ܦ�m�M�j�p
        add(button_1);// �N���s�W�[�쭱�O�W
        textField = new JTextField();// �إ߯¤�r��
        textField.setText("�o�O�@�ӯ¤�r�ر��");// ���w�¤�r�ت����D
        textField.setBounds(38, 35, 175, 22);// �]�w�¤�r�ت���ܦ�m�M�j�p
        add(textField);// �N�¤�r�ؼW�[�쭱�O�W
    }
}
