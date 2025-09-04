package day0903;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UseJList extends JFrame implements ListSelectionListener{
	private DefaultListModel<String> dlm;
	private JList<String> jl;
	
	public UseJList() {
		super("JList 사용");
		//1. Model객체 생성
		dlm = new DefaultListModel<String>();
		
		//2. View객체 생성. (has a)
		jl = new JList<String>(dlm);
		
		//3. 값 할당
		dlm.addElement("IT엔지니어를 위한 네트워크입문");
		dlm.addElement("이것이 자바다.");
		dlm.addElement("HTML5 웹 프로그래밍 입문");
		dlm.addElement("리눅스 실습");
		dlm.addElement("AWS인프라 구축 가이드");
		dlm.addElement("UML기초와 응용");
		dlm.addElement("스프링 마스터");
		
		dlm.removeElementAt(0);
		
		JScrollPane jsp = new JScrollPane(jl);
		//레이아웃변경
		//배치
		add(jsp);
		
		//이벤트를 등록
		jl.addListSelectionListener(this);
		
		//윈도우 크기 설정
		setBounds(100, 100, 600, 300);
		
		//윈도우 가시화
		setVisible(true);
		
		//윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//리스트에 선택 된 인덱스를 얻어서
		int idx = jl.getSelectedIndex();
		//모델객체에 해당 인덱스번째의 값을 받아와서
		String item = dlm.getElementAt(idx);
		//타이틀 바에 설정
		setTitle("JList사용 - " + item);
		
		
//		setTitle("");
	}
	
	public static void main(String[] args) {
		new UseJList();
	}

}
