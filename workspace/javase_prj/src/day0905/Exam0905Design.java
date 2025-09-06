package day0905;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 문제
 * 9월3일에 했던 것에서
 * 입력 버튼이 눌려지면 번호, 이름, 나이, 전화번호를 Default List Model(DLM)에 추가. -> JList에 반영.
 * 이후 입력되었던 JTextField(JTF)가 초기화 되고, 번호에 커서를 위치시킨다.
 * 
 * JList에 아이템이 클릭되면 번호, 이름, 나이, 전화번호를 JTF에 추가한다.
 * 
 * JList의 아이템이 클릭 된 후 
 * 삭제버튼이 눌려지면 해당번째의 DLM에서 아이템을 삭제.
 * JList가 선택되지 않고 클릭 된 경우. "삭제할 아이템을 먼저 선택해주세요."를 messageDialog를 사용하여
 * 사용자에게 보내준다.
 * 
 * (변경은 없음)
 */
public class Exam0905Design extends JFrame{
	static DefaultListModel<String> dlm;
	static JList<String> jl;
	
	private JLabel[] jlblInfo;
	private JTextField jtfNumber;
	private JTextField jtfName;
	private JTextField jtfAge;
	private JTextField jtfPhoneNum;
	
	private JButton jbtn;
	private JButton jbtn2;
	private JButton jbtn3;
	
	public Exam0905Design() {
		super("윈도우 컴포넌트");
		jlblInfo = new JLabel[4];
		jtfNumber = new JTextField();
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfPhoneNum = new JTextField();
		
		JPanel jpInfo = new JPanel();
		
		jlblInfo[0] = new JLabel("번호");
		jlblInfo[1] = new JLabel("이름");
		jlblInfo[2] = new JLabel("나이");
		jlblInfo[3] = new JLabel("전화번호");
		
		// 표시할 정보들 구분
		jpInfo.setLayout(new GridLayout(4, 2));
		
		jpInfo.add(jlblInfo[0]);
		jpInfo.add(jtfNumber);
		jpInfo.add(jlblInfo[1]);
		jpInfo.add(jtfName);
		jpInfo.add(jlblInfo[2]);
		jpInfo.add(jtfAge);
		jpInfo.add(jlblInfo[3]);
		jpInfo.add(jtfPhoneNum);
		
		// JList의 Model, View 생성
		dlm = new DefaultListModel<String>();
		jl = new JList<String>(dlm);
		
		//JList 값 추가
//		dlm.addElement("1,루피,20,010-1234-5678");
		
		//JList 스크롤 생성
		JScrollPane jsp = new JScrollPane(jl);
		
		setLayout(new BorderLayout());
		JPanel showInfo = new JPanel(new GridLayout(1, 2));
		showInfo.add(jpInfo);
		showInfo.add(jsp);
		
		// 버튼 생성 및 컨테이너 컴포넌트에 삽입
		jbtn = new JButton("입력");
		jbtn2 = new JButton("삭제");
		jbtn3 = new JButton("종료");
		JPanel jbtns = new JPanel(new GridLayout(1, 3));
		jbtns.add(jbtn);
		jbtns.add(jbtn2);
		jbtns.add(jbtn3);
		
		add(showInfo, BorderLayout.CENTER);
		add(jbtns, BorderLayout.SOUTH);
		
		Exam0905Event e0905e = new Exam0905Event(this);
		
//		jl.addListSelectionListener(e0905e);
		jbtn.addActionListener(e0905e); // 입력버튼 연동
		jbtn2.addActionListener(e0905e);
		jbtn3.addActionListener(e0905e); 
		jl.addMouseListener(e0905e); // JList 아이템 클릭 연동
		
		setBounds(100, 100, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Exam0905Design();
	}
	


	public JTextField getJtfNumber() {
		return jtfNumber;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAge() {
		return jtfAge;
	}

	public JTextField getJtfPhoneNum() {
		return jtfPhoneNum;
	}

	public JButton getJbtn() {
		return jbtn;
	}

	public JButton getJbtn2() {
		return jbtn2;
	}

	public JButton getJbtn3() {
		return jbtn3;
	}

	
}
