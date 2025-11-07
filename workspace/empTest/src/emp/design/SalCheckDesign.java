package emp.design;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.time.Year;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import emp.event.SalCheckEvt;
import util.TableRendererUtil;

public class SalCheckDesign extends JFrame {
	private JTextField jtfName,jtfJob,jtfHireDate,
	jtfEmpNo,jtfYearSal,jtfMonthSal,jtfBonus;
	private JComboBox<String> jcbYear;
	private JTable jtSalary;
	private DefaultComboBoxModel<String> dfc;
	private DefaultTableModel model;
	
	private SalCheckEvt se;

	  public SalCheckDesign(int emp_id) {
		  	
		  	
	        super("급여조회");
	        setLayout(null);
	        setSize(650, 500);
	        setLocationRelativeTo(null);

	        Font font = new Font("맑은 고딕", Font.BOLD, 13);
	        
//	        int emp_id=1003; //임시로그인     
	        se= new SalCheckEvt(this,emp_id);//임시로그인연결
	        
	      	        
	        // ====== 상단 (사원 정보) ======
	        JLabel jlblTitle = new JLabel("급여 조회", SwingConstants.CENTER);
	        jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
	        jlblTitle.setOpaque(true);
	        jlblTitle.setBackground(new Color(220, 220, 220));
	        jlblTitle.setBounds(20, 10, 600, 30);
	        add(jlblTitle);

	        JLabel jlblName = new JLabel("사원명");
	        jlblName.setFont(font);
	        jlblName.setBounds(50, 60, 100, 30);
	        add(jlblName);
	        jtfName = new JTextField("");
	        jtfName.setBounds(120, 60, 150, 30);
	        jtfName.setEditable(false);
	        add(jtfName);

	        JLabel jlblJob = new JLabel("직급");
	        jlblJob.setFont(font);
	        jlblJob.setBounds(360, 60, 100, 30);
	        add(jlblJob);
	        jtfJob = new JTextField("");
	        jtfJob.setBounds(420, 60, 150, 30);
	        jtfJob.setEditable(false);
	        add(jtfJob);

	        JLabel jlblEmpNo = new JLabel("사원번호");
	        jlblEmpNo.setFont(font);
	        jlblEmpNo.setBounds(50, 100, 100, 30);
	        add(jlblEmpNo);
	        jtfEmpNo = new JTextField("");
	        jtfEmpNo.setBounds(120, 100, 150, 30);
	        jtfEmpNo.setEditable(false);
	        add(jtfEmpNo);

	        JLabel jlblHireDate = new JLabel("입사일");
	        jlblHireDate.setFont(font);
	        jlblHireDate.setBounds(360, 100, 100, 30);
	        add(jlblHireDate);
	        jtfHireDate = new JTextField("");
	        jtfHireDate.setBounds(420, 100, 150, 30);
	        jtfHireDate.setEditable(false);
	        add(jtfHireDate);

	        //==================중간===============
	        JLabel jlblSub = new JLabel("급여상세", SwingConstants.CENTER);
	        jlblSub.setFont(font);
	        jlblSub.setOpaque(true);
	        jlblSub.setBackground(new Color(220, 220, 220));
	        jlblSub.setBounds(20, 150, 600, 30);
	        add(jlblSub);

	        //연봉
	        JLabel jlblYearSal = new JLabel("연봉");
	        jlblYearSal.setBounds(50, 190, 100, 30);
	        jlblYearSal.setFont(font);
	        add(jlblYearSal);
	      
	        jtfYearSal = new JTextField(" ");
	        jtfYearSal.setBounds(90, 190, 150, 30);
	        jtfYearSal.setEditable(false);
	        add(jtfYearSal);
	        
	        //월급
	        JLabel jlblMonth = new JLabel("월급");
	        jlblMonth.setBounds(250, 190, 100, 30);
	        jlblMonth.setFont(font);
	        add(jlblMonth);
	        
	        jtfMonthSal = new JTextField("");
	        jtfMonthSal.setBounds(290, 190, 150, 30);
	        jtfMonthSal.setEditable(false);
	        add(jtfMonthSal);

	        //보너스
	        JLabel jlblBonus = new JLabel("보너스");
	        jlblBonus.setBounds(460, 190, 100, 30);
	        jlblBonus.setFont(font);
	        add(jlblBonus);
	       
	        jtfBonus = new JTextField("");
	        jtfBonus.setBounds(510, 190, 80, 30);
	        jtfBonus.setEditable(false);
	        add(jtfBonus);
	        
	        JLabel jlblSal=new JLabel("급여명세서"); 
	        jlblSal.setBounds(50, 240, 150, 30);
	        jlblSal.setFont(font);
	        add(jlblSal);
	        
	        //콤보박스설정
	        //현재년도 불러오고 최근10년
	        int currentYear=Year.now().getValue();
	        dfc=new DefaultComboBoxModel<>();
	        
	        for(int i=0; i<6; i++) {
	        	dfc.addElement((currentYear-i)+"년");
	        }
	        
	        jcbYear = new JComboBox<String>(dfc);
	        jcbYear.setBounds(150, 240, 100, 30);
	        jcbYear.setFont(font);
	        jcbYear.setSelectedItem(currentYear + "년");
	        add(jcbYear);
	       

	        // ====== 하단  ======
	        String[] cols = {"급여지급일", "지급액", "보너스지급액", "세금합계", "실지급액"};	        
	        model = new DefaultTableModel(cols,0);
	        jtSalary = new JTable(model);
	        JScrollPane jsp = new JScrollPane(jtSalary);
	        jsp.setBounds(20, 280, 600, 160);
	        
	        add(jsp);
	        
	        //테이블형식불러오기
	        TableRendererUtil.tableNumberRenderer(jtSalary, 1, 4,true);
	      
	        //이벤트 등록
	        jcbYear.addActionListener(se);
	        addWindowListener(se);
	        try {
				se.loadMySalInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        

	        setVisible(true);
	        setLocationRelativeTo(null);
//	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    }
	  

		
	  
	  public JTextField getJtfName() {
		return jtfName;
	}






	  public JTextField getJtfJob() {
		  return jtfJob;
	  }






	  public JTextField getJtfHireDate() {
		  return jtfHireDate;
	  }






	  public JTextField getJtfEmpNo() {
		  return jtfEmpNo;
	  }






	  public JTextField getJtfYearSal() {
		  return jtfYearSal;
	  }






	  public JTextField getJtfMonthSal() {
		  return jtfMonthSal;
	  }






	  public JTextField getJtfBonus() {
		  return jtfBonus;
	  }






	  public JComboBox<String> getJcbYear() {
		  return jcbYear;
	  }






	  public JTable getJtSalary() {
		  return jtSalary;
	  }






	  public DefaultComboBoxModel<String> getDfc() {
		  return dfc;
	  }






	  public DefaultTableModel getModel() {
		  return model;
	  }






	  public SalCheckEvt getSe() {
		  return se;
	  }


}
