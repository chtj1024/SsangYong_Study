package day0903;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UseJTable extends JFrame{
	
	public UseJTable() {
		super("JTable");
		
		String[] columnNames = {"번호", "이름", "나이", "주소"};
		String[][] rowData = {
				{"1","박상현","25","서울시 동대문구 동대문동"},
				{"2","나경원","26","서울시 동작구 사당동"},
				{"3","최승준","24","경기도 수원시 망포구 망포동"},
				{"4","신승덕","25","인천시 계양구 계양동"}
		};
		//1.Model 객체 생성
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		
		//2.View 객체 생성) Model객체화 has a 관계
		JTable jt = new JTable(dtm);
		jt.setRowHeight(25);
		//3. Model객체를 사용하여 추가할 값을 설정
		JScrollPane jsp = new JScrollPane(jt);
		//일차원 배열
		String[] studentArr = {"5", "이준원", "27", "경기도 부천시 부천동"};
		dtm.addRow(studentArr);
		//Vector
		Vector<String> vector = new Vector<String>();
		vector.add("6");
		vector.add("최태준");
		vector.add("25");
		vector.add("서울시 강남구 역삼동");
		dtm.addRow(vector);
		
		add(jsp);
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseJTable();
	}
}
