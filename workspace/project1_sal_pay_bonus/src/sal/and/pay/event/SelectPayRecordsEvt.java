package sal.and.pay.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import sal.and.pay.design.SelectPayRecordsDesign;
import sal.and.pay.service.SalAndPayService;

public class SelectPayRecordsEvt extends WindowAdapter implements ActionListener, FocusListener{

	private SelectPayRecordsDesign sprd;
	private SalAndPayService saps;
	private SalAndPayEvt sape;
	
	public SelectPayRecordsEvt(SelectPayRecordsDesign sprd, SalAndPayEvt sape) {
		this.sprd = sprd;
		saps = new SalAndPayService();
		this.sape = sape;
	}
	
	public void conditionSelectPayRecords() {
		String input = sprd.getJtaCommand().getText().trim();
		List<String> columns = new ArrayList<String>(Arrays.asList("지급번호", "사번", "이름", "지급날짜", "월급(세전)", "보너스"));
		
		StringBuilder where = new StringBuilder();
		
		if (input == null || input.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "커맨드를 입력해주세요.");
			return;
		} else {
			String[] conditions = input.split(",");
			if(conditions.length >= 4) {
				JOptionPane.showMessageDialog(null, "조건은 3가지 이하로 작성해주세요.");
				return;
			}
			
			for (int i = 0; i < conditions.length; i++) {
				String cond = conditions[i].trim();
				if (!cond.contains("_")) {
					JOptionPane.showMessageDialog(null, "명령에 _을 기입해주세요.");
					return;
				}
				
				String[] parts = cond.split("_", 2);
				
				if (!columns.contains(parts[0].trim())) {
					JOptionPane.showMessageDialog(null, "컬럼명을 제대로 입력해주세요.");
					return;
				}
				
				if (parts.length < 2) {
					JOptionPane.showMessageDialog(null, "조건의 값을 명시해주세요");
					return;
				}
				
				String col = parts[0].trim();
				String val = parts[1].trim();
				
				switch(col) {
					case "지급날짜":
						if(val.contains("~")) {
							String[] range = val.split("~", 2);
							
							for(String date : range) {
								if(!isValidDate(date)) {
									JOptionPane.showMessageDialog(null, "날짜 형식이 아니거나 잘못된 날짜입니다.");
									return;
								}
							}
							where.append(" and p1.pay_date between to_date('")
								 .append(range[0].trim()).append("','yyyy-MM-dd')")
								 .append(" and to_date('").append(range[1].trim()).append("','yyyy-MM-dd')");
						} else {
							if(!isValidDate(val)) {
								JOptionPane.showMessageDialog(null, "날짜 형식이 아니거나 잘못된 날짜입니다.");
								return;
							}
							where.append(" and p1.pay_date = ")
								 .append(" to_date('").append(val).append("', 'yyyy-MM-dd')");
						}
						break;
					case "사번":
						if (val.contains("~")) {
							String[] range = val.split("~", 2);
							
							// 문자열, 실수, 공백이 섞여있을 때 예외처리
							for(String emp_id : range) {
								if(!emp_id.matches("-?\\d+")) {
									JOptionPane.showMessageDialog(null, "사번 조건은 숫자만 입력해주세요.");
									return;
								}
							}
							
							where.append(" and emp_id between ")
								 .append(range[0].trim()).append(" and ").append(range[1].trim());
						} else {
							if(!val.matches("-?\\d+")) {
								JOptionPane.showMessageDialog(null, "사번 조건은 숫자만 입력해주세요.");
								return;
							}
							where.append(" and emp_id = ").append(val.trim());
						}
						break;
					case "이름":
						if (!val.matches("^[a-zA-Z가-힣]+$")) {
							JOptionPane.showMessageDialog(null, "이름은 한글, 영문만 입력해주세요");
							return;
						}
						where.append(" and name like '%").append(val).append("%'");
						break;
					case "월급(세전)":
						if (val.contains("~")) {
							String[] range = val.split("~", 2);
							
							// 문자열, 실수, 공백이 섞여있을 때 예외처리
							for(String pay : range) {
								if(!pay.matches("-?\\d+")) {
									JOptionPane.showMessageDialog(null, "월급 조건은 숫자만 입력해주세요.");
									return;
								}
							}
							
							where.append(" and pay between ")
								 .append(range[0].trim()).append(" and ").append(range[1].trim());
						} else {
							if(!val.matches("-?\\d+")) {
								JOptionPane.showMessageDialog(null, "월급 조건은 숫자만 입력해주세요.");
								return;
							}
							where.append(" and pay = ").append(val.trim());
						}
						break;
					case "보너스":
						if (val.contains("~")) {
							String[] range = val.split("~", 2);
							
							// 문자열, 실수, 공백이 섞여있을 때 예외처리
							for(String bonus : range) {
								if(!bonus.matches("-?\\d+")) {
									JOptionPane.showMessageDialog(null, "보너스 조건은 숫자만 입력해주세요.");
									return;
								}
							}
							
							where.append(" and bonus between ")
								 .append(range[0].trim()).append(" and ").append(range[1].trim());
						} else {
							if(!val.matches("-?\\d+")) {
								JOptionPane.showMessageDialog(null, "보너스 조건은 숫자만 입력해주세요.");
								return;
							}
							where.append(" and bonus = ").append(val.trim());
						}
						break;
				}
			}
		}
		
		// 부모 디자인쪽 이벤트에 넘겨서 검색 조건에 맞춰 테이블 최신화 하도록 넘김
		sape.loadConditionPayRecords(where.toString());
		
		JOptionPane.showMessageDialog(null, "조건으로 지급기록검색을 완료하였습니다.");
		sprd.dispose();
	}
	
	public void ResetConditionPayRecords() {
		
	}
	
	/**
	 * 날짜 타입 아닐 때 예외처리
	 * @param dateStr
	 * @return
	 */
	public boolean isValidDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); // 유연한 해석 비활성화(엄격한 검사)
		
		try {
			Date date = sdf.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sprd.getJbtnSearch()) {
			conditionSelectPayRecords();
		}		
		if(e.getSource() == sprd.getJbtnCancel()) {
			windowClosing(null);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sprd.dispose();
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (sprd.getJtaCommand().getText().equals("여기에 커맨드를 입력하세요.")) {
			sprd.getJtaCommand().setText("");
			sprd.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (sprd.getJtaCommand().getText().trim().isEmpty()) {
			sprd.getJtaCommand().setText("여기에 커맨드를 입력하세요.");
			sprd.getJtaCommand().setForeground(Color.GRAY);
        }
	}
	
	
}
