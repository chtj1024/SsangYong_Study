package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRendererUtil {
	
	  // #,### 표시 숫자포맷 Renderer      
	  public static DefaultTableCellRenderer createNumberRenderer(boolean highlightLastRow) {
		   return new DefaultTableCellRenderer() {
	       private final DecimalFormat df = new DecimalFormat("#,###"); 

	        //합계행 색 설정
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value,
	        		boolean isSelected, boolean hasFocus, int row, int column) {
	        	
	        	Component c= super.getTableCellRendererComponent(
	        			table,value,hasFocus, isSelected,row,column);
	        	
	        	//#,###
	        	if(value instanceof Number) {
	        		setText(df.format(value));
	        	}
	        	//선텍된셀 기본색
	        	if(!isSelected) {
	        		c.setBackground(Color.white);       		
	        	}
	        	
	        	//마지막 행 색여부
	        	if(highlightLastRow) {
	        	int lastRow=table.getRowCount()-1;
	        	if(row==lastRow) {
	        		c.setBackground(new Color(255, 235, 205));
	        		c.setFont(c.getFont().deriveFont(Font.BOLD));
	        		}
	        	}
	        	return c;
	        	
	        }
		   };
	  }//createNumberRenderer
	    //특정 테이블 i~j 번 컬럼에 적용
	  public static void tableNumberRenderer(JTable table, int startCol, int endCol, boolean highlightLastRow) {
		  DefaultTableCellRenderer numRenderer=createNumberRenderer(highlightLastRow);
		  
		  for(int i=startCol; i <=endCol; i++) {
			  table.getColumnModel().getColumn(i).setCellRenderer(numRenderer);
			  
		  }
		  
	  }
	        

}
