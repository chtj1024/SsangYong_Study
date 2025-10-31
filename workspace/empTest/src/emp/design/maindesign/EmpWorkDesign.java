package emp.design.maindesign;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import emp.DTO.WorkRecordsResultDTO;

public class EmpWorkDesign extends JPanel {
	
	private JLabel jlblLastRec,jlblClock;
	private JButton jbtnIn,jbtnOut;
	private JTable jtaWorkLog;
	private DefaultTableModel dtmWorkLog;
	private Timer clockTimer;
	private JPanel btnCardPanel;
	private CardLayout btnCardLayout;
	
	
	public EmpWorkDesign() {
		//레이아웃 설정
		setLayout(new BorderLayout(5,5));
		setBorder(BorderFactory.createTitledBorder("근무등록"));
		
		//상단 컴포넌트 생성
		jlblLastRec = new JLabel("현재시간");
		jlblClock = new JLabel("0000-00-00 00:00:00");
		jbtnIn = new JButton("출근");
		jbtnOut = new JButton("퇴근");
		
		btnCardLayout = new CardLayout();
        btnCardPanel = new JPanel(btnCardLayout);
        
        btnCardPanel.add(jbtnIn, "IN"); 
        btnCardPanel.add(jbtnOut, "OUT");
		
		//상단패널 분리
		JPanel northPanel = new JPanel(new BorderLayout());
		//상단 왼쪽 - 현재 시간
		JPanel northWestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northWestPanel.add(jlblLastRec);
        northWestPanel.add(jlblClock);
        //상단 오른쪽 - 버튼
        JPanel northEastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        northEastPanel.add(btnCardPanel);
        northPanel.add(northWestPanel, BorderLayout.WEST);
        northPanel.add(northEastPanel, BorderLayout.EAST);

       //근무기록 테이블
        String[] columnNames = {"출근시간", "퇴근시간", "상태"};
        
        dtmWorkLog = new DefaultTableModel(columnNames,0) {
        	public boolean isCellEditable(int row, int column) {
             	return false;}
         };
  
        //테이블 생성
        jtaWorkLog = new JTable(dtmWorkLog);
        jtaWorkLog.getTableHeader().setReorderingAllowed(false);
        JScrollPane jsp = new JScrollPane(jtaWorkLog);
        jsp.setPreferredSize(new Dimension(580,150));
        add(northPanel, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        startRealTimeClock();
	}//EmpWorkDesign

	/**
	 * 실시간 시계
	 */
	private void startRealTimeClock() {
	   final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      clockTimer = new Timer(1000, new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	              Date now = new Date();
	              jlblClock.setText(sdf.format(now));
	          }
	      });
	      clockTimer.start();
	  }//startRealTimeClock
	
	public void updateWorkLogTable(List<WorkRecordsResultDTO> list) {
		dtmWorkLog.setRowCount(0);
		
		if(list==null||list.isEmpty()) {
			return;
		}//end if
		
        for (WorkRecordsResultDTO dto : list) {
        	String checkInDisplay = "출근 : " + dto.getClockInTime();
        	String checkOutDisplay = dto.getClockOutTime().equals(" - ") ? "" : "퇴근 : " + dto.getClockOutTime();
        	String asName = dto.getAsName();
        	Object[] rowData = {
                checkInDisplay, checkOutDisplay,asName };
            dtmWorkLog.addRow(rowData);
        }//end for
	}//updateWorkLogTable

	public JLabel getJlblClock() {
		return jlblClock;
	}

	public JButton getJbtnIn() {
		return jbtnIn;
	}

	public JButton getJbtnOut() {
		return jbtnOut;
	}

	public JTable getJtaWorkLog() {
		return jtaWorkLog;
	}

	public DefaultTableModel getDtmWorkLog() {
		return dtmWorkLog;
	} 

	public JPanel getBtnCardPanel() {
		return btnCardPanel;
	}

	public CardLayout getBtnCardLayout() {
		return btnCardLayout;
	}
}//class
