package util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * JTable의 "승인상태" 컬럼 렌더링을 위한 클래스.
 * 값에 따라 배경색과 텍스트를 변경합니다.
 * @author Gemini
 */
public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
	
	private final Color COLOR_GREEN = new Color(204, 255, 204);
	private final Color COLOR_RED = new Color(255, 204, 204);
	private final Color COLOR_YELLOW = new Color(255, 255, 204); 

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
	                                             boolean isSelected, boolean hasFocus, int row, int column) {
		
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		String status = (value == null) ? "" : value.toString();

		if ("보류".equals(status)) {
			setText("요청");
		} else {
			setText(status);
		}

		if (!isSelected) {
			c.setForeground(Color.BLACK); 
			
			if ("승인".equals(status)) {
				c.setBackground(COLOR_GREEN);
			} else if ("반려".equals(status)) {
				c.setBackground(COLOR_RED);
			} else if ("보류".equals(status)) {
				c.setBackground(COLOR_YELLOW);
			} else {
				c.setBackground(table.getBackground());
			}
		}
		
		setHorizontalAlignment(SwingConstants.CENTER);
		
		return c;
	}
}