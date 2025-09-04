package day0903;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseMenu extends JFrame{
	
	public UseMenu() {
		super("메뉴바 사용");
		
		//2. 컴포넌트 생성
		//메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		
		//메뉴 생성
		JMenu jmGroup = new JMenu("1조");
		JMenu jmGroup2 = new JMenu("2조");
		JMenu jmSub = new JMenu("하위 메뉴를 제공");
		
		//메뉴아이템 생성
		JMenuItem jmi = new JMenuItem("하지혜");
		JMenuItem jmi2 = new JMenuItem("안세홍");
		JMenuItem jmi3 = new JMenuItem("임다민");
		
		JMenuItem jmi4 = new JMenuItem("최승준");
		JMenuItem jmi5 = new JMenuItem("이지원");
		JMenuItem jmi6 = new JMenuItem("홍길동");
		
		//메뉴에 메뉴아이템 배치
		jmGroup.add(jmi);
		jmGroup.add(jmi2);
		jmGroup.add(jmi3);
		
		jmGroup2.add(jmi4);
		jmGroup2.add(jmi5);
		jmGroup2.addSeparator(); // 구분선
		jmGroup2.add(jmi6);
		//하위메뉴에 메뉴아이템을 배치.
		jmSub.add(new JMenuItem("이것이 자바다"));
		jmSub.add(new JMenuItem("리눅스 실습"));
		jmSub.add(new JMenuItem("AWS인프라 구축"));
		
		jmGroup2.add(jmSub);
		
		//메뉴바에 메뉴를 배치
		jmb.add(jmGroup);
		jmb.add(jmGroup2);
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		//3. 배치관리자 설정
		
		//4. 컴포넌트 배치
		add("Center", jsp);
		
		//메뉴바를 프레임 설정
//		add("North", jmb);
		setJMenuBar(jmb);
		
		//5. 윈도우 크기 설정
		setBounds(100, 200, 600, 500);
		
		//6. 윈도우 가시화
		setVisible(true);
		
		//7. 윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseMenu();
	}
}
