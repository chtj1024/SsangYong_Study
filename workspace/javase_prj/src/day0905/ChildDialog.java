package day0905;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 부모창에서 부터 생성되는 자식 창. 부모창에서 제공할 수 없는 부가적인 정보를 제공하는 창.
 */
public class ChildDialog extends JDialog implements ActionListener {

	public ChildDialog(ParentFrame pf, boolean modal) {
		super(pf, "부가적인 정보 제공", modal);
		
		JLabel jlblOutput = new JLabel(modal ? "부모창 선택 안됨" : "부모창 선택 가능");
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		Color color = Color.RED;
		
		if(!modal) {
			font = new Font("궁서체", Font.BOLD|Font.ITALIC, 24);
			color = Color.blue;
		}
		
		jlblOutput.setFont(font);
		jlblOutput.setForeground(color);
		
		add("Center", jlblOutput);
		
		JButton jbtnClose = new JButton("닫기");
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtnClose);
		
		add("South", jpSouth);
		jbtnClose.addActionListener(this);
		
//		setBounds(100, 100, 500, 300);
		// 부모창의 좌표를 받아와서 자식창을 띄울 수 있다.
		setBounds(pf.getX()+100, pf.getY()+50, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
