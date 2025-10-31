package emp.design.maindesign;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import emp.DTO.UserInfoDTO;

public class EmpProfileDesign extends JPanel {

	private JLabel jlName,jlPname;
	private JTextField jtfEmpId ,jtfDname,jtfTel,jtfEmail;
	
	public EmpProfileDesign () {
		//레이아웃 설정
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
		
		//컴포넌트 생성
		//이름
		jlName = new JLabel("");
		jlName.setFont(new Font("SansSerif", Font.BOLD, 20));
		//직급
		jlPname = new JLabel("");
		jlPname.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		jlPname.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
		//사원번호
		JLabel jlEmpId = new JLabel("사원번호");
        jtfEmpId = new JTextField(10);
        //부서
        JLabel jlDname = new JLabel("부서");
        jtfDname = new JTextField(10);
        //전화번호
        JLabel jlTel = new JLabel("전화번호");
        jtfTel = new JTextField(10);
        //이메일
        JLabel jlEmail = new JLabel("이메일");
        jtfEmail = new JTextField(10);
        
        jtfEmpId.setEditable(false);
        jtfDname.setEditable(false);
        jtfTel.setEditable(false);
        jtfEmail.setEditable(false);
        
        //GridBagConstraints 설정, 배치
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		//이름 배치
		gbc.gridx =0; gbc.gridy =0;
		gbc.anchor = GridBagConstraints.WEST;
		add(jlName, gbc);
		//직급 배치
		gbc.gridx = 1; gbc.gridy = 0;
		add(jlPname, gbc);
		//사원번호 label
		gbc.gridx = 0; gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		add(jlEmpId, gbc);
		//사원번호 textField
		gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // textField는 왼쪽 정렬
        gbc.fill = GridBagConstraints.HORIZONTAL; // 가로로 채우기
        gbc.weightx = 1.0; // 창 크기 조절 시 이 컴포넌트가 가로 여백을 가져감
        add(jtfEmpId, gbc);
        //부서 label
        gbc.gridx = 2; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE; // 채우기 초기화
        gbc.weightx = 0.0; // 여백 설정 초기화
        add(jlDname, gbc);
        //부서 textField
        gbc.gridx = 3;  gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.weightx = 1.0;
        add(jtfDname, gbc);
        //전화번호 label
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        add(jlTel, gbc);
        //전화번호 textField
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(jtfTel, gbc);
        //이메일 label
        gbc.gridx = 2; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        add(jlEmail, gbc);
        //이메일 textField
        gbc.gridx = 3; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(jtfEmail, gbc);
	}//EmpProfileDesign
	
	public void displayUserInfo(UserInfoDTO uid) {
		if (uid == null) {
			return;
		}//end if
	
		jlName.setText(uid.getName());
		jlPname.setText(uid.getPname());
        jtfEmpId.setText(String.valueOf(uid.getEmpId()));
        jtfDname.setText(uid.getDname());
        jtfTel.setText(uid.getTel());
        jtfEmail.setText(uid.getEmail());
        
        revalidate();
        repaint();
        
	}//displayUserInfo

	public JLabel getJlName() {
		return jlName;
	}

	public JLabel getJlPname() {
		return jlPname;
	}

	public JTextField getJtfEmpId() {
		return jtfEmpId;
	}

	public JTextField getJtfDname() {
		return jtfDname;
	}

	public JTextField getJtfTel() {
		return jtfTel;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}
	
	
}//class
