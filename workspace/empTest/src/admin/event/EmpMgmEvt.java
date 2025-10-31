package admin.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import admin.design.AddEmpDesign;
import admin.design.EmpDetailsInfoDesign;
import admin.design.EmpMgmDesign;
import admin.dto.EmpMgmDTO;
import admin.service.EmpMgmService;

public class EmpMgmEvt extends WindowAdapter implements ActionListener, KeyListener{
	private EmpMgmDesign emd;
	private JButton jbtn;
	
	public EmpMgmEvt(EmpMgmDesign emd) {
		this.emd = emd;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		emd.dispose();
	}
	
	public void infoEmp() {
		DefaultTableModel dtmEmp = emd.getDtmEmp();
		
		EmpMgmService ems = new EmpMgmService();
		
		List<EmpMgmDTO> listEmp = ems.infoAllEmp();
		
		Object[] rowData = null;
		
		dtmEmp.setRowCount(0);
		
		for(EmpMgmDTO emd : listEmp) {
			rowData = new Object[5];
			
			rowData[0] = emd.getEmp_id();
			rowData[1] = emd.getName();
			rowData[2] = emd.getDname();
			rowData[3] = emd.getPname();
			
			jbtn = new JButton("상세보기");
			
			rowData[4] = jbtn;
			
			dtmEmp.addRow(rowData);
		}
		
		JTable jt = emd.getJtEmp();
		
		jt.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		jt.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));
    
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		JComboBox<String> jcb = emd.getJcbSearchKeyword();
		DefaultComboBoxModel<String> dcbm = emd.getDcbm();
		List<EmpMgmDTO> listEmp = null;
		EmpMgmService ems = new EmpMgmService();
		
		String keyword = dcbm.getElementAt(jcb.getSelectedIndex());
		String searchWord = emd.getJtfEmpSearch().getText().trim();
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(searchWord.equals("")) {
				infoEmp();
				return;
			}
			
			if(keyword.equals("사번")) {
				try {
					Integer.parseInt(searchWord);
					listEmp = ems.searchEmp(keyword, searchWord);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(emd, "사번을 입력할 때엔, 정수로 입력해야합니다.");
				}
			} else {
				listEmp = ems.searchEmp(keyword, searchWord);
			}
				
			DefaultTableModel dtmEmp = emd.getDtmEmp();
				
			Object[] rowData = null;
				
			dtmEmp.setRowCount(0);
				
			for(EmpMgmDTO eDTO : listEmp) {
				rowData = new Object[5];
					
				rowData[0] = eDTO.getEmp_id();
				rowData[1] = eDTO.getName();
				rowData[2] = eDTO.getDname();
				rowData[3] = eDTO.getPname();
					
				jbtn = new JButton("상세보기");
					
				rowData[4] = jbtn;
					
				dtmEmp.addRow(rowData);
				
				JTable jt = emd.getJtEmp();
				
				jt.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
				jt.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));
			}
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> jcb = emd.getJcbSearchKeyword();
		DefaultComboBoxModel<String> dcbm = emd.getDcbm();
		List<EmpMgmDTO> listEmp = null;
		EmpMgmService ems = new EmpMgmService();
		
		String keyword = dcbm.getElementAt(jcb.getSelectedIndex());
		String searchWord = emd.getJtfEmpSearch().getText().trim();
		
		if(e.getSource() == emd.getJbtnEmpSearch()) {
			if(searchWord.equals("")) {
				infoEmp();
				return;
			}
			
			if(keyword.equals("사번")) {
				try {
					Integer.parseInt(searchWord);
					listEmp = ems.searchEmp(keyword, searchWord);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(emd, "사번을 입력할 때엔, 정수로 입력해야합니다.");
				}
			} else {
				listEmp = ems.searchEmp(keyword, searchWord);
			}
				
			DefaultTableModel dtmEmp = emd.getDtmEmp();
				
			Object[] rowData = null;
				
			dtmEmp.setRowCount(0);
				
			for(EmpMgmDTO eDTO : listEmp) {
				rowData = new Object[5];
					
				rowData[0] = eDTO.getEmp_id();
				rowData[1] = eDTO.getName();
				rowData[2] = eDTO.getDname();
				rowData[3] = eDTO.getPname();
					
				jbtn = new JButton("상세보기");
					
				rowData[4] = jbtn;
					
				dtmEmp.addRow(rowData);
				
				JTable jt = emd.getJtEmp();
				
				jt.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
				jt.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));
			}
		} else if(e.getSource() == emd.getJbtnAddEmp()) {
			new AddEmpDesign(emd);
			
			emd.setInfo(this);
			emd.repaint();
		}
	}
	

	

	class ButtonRenderer extends JButton implements TableCellRenderer {
	    public ButtonRenderer() {
	        setOpaque(true);
	    }

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if(value instanceof JButton) {
				return (JButton) value;
			}
			return null;
		}
	}

	class ButtonEditor extends DefaultCellEditor {
	    private JButton button;
	    private boolean clicked;
	    private int row;

	    public ButtonEditor(JCheckBox checkBox) {
	        super(checkBox);
	        button = new JButton();
	        button.setOpaque(true);
	        button.addActionListener(e -> {
	            clicked = true;
	            fireEditingStopped();
	        });
	    }

	    @Override
	    public Component getTableCellEditorComponent(
	            JTable table, Object value, boolean isSelected, int row, int col) {
	        if (value instanceof JButton btn) {
	        	this.row = row;
	            button.setText("상세보기");
	        } else {
	            button.setText(null);
	        }
	        return button;
	    }

	    @Override
	    public Object getCellEditorValue() {
	        if (clicked) {
	        	 Object empNoObject = emd.getJtEmp().getValueAt(row, 0); 
		            int empNo = Integer.parseInt(empNoObject.toString()); 
		            new EmpDetailsInfoDesign(empNo);
		            emd.dispose();	
	        }
	        clicked = false;
	        return button;
	    }
	}
}
