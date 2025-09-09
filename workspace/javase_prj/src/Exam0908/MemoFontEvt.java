package Exam0908;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MemoFontEvt extends WindowAdapter implements ActionListener, ListSelectionListener, ItemListener{
	private JavaMemo jm;
	private MemoFont mf;
	
	public MemoFontEvt(JavaMemo jm, MemoFont mf) {
		this.jm = jm;
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mf.getJbtnConfirm()) { // 확인버튼 눌렀을 때.
			setFont();
		} else if (e.getSource() == mf.getJbtnCancel()) { // 취소버튼 눌렀을 때.
			mf.dispose();
		}
	}
	
	public void setFont() {
		if(mf.getJtfFont().getText().equals("") || mf.getJtfStyle().getText().equals("")
				|| mf.getJtfSize().getText().equals("")) {
			System.out.println("글꼴 형식을 모두 골라주세요.");
			return;
		}
		
		String fontName = mf.getJtfFont().getText();
		String styleName = mf.getJtfStyle().getText();
		int styleInt = 0; // 글꼴 스타일의 반환형은 int임
		String sizeName = mf.getJtfSize().getText();
		int sizeInt = Integer.parseInt(sizeName);			
		
		switch(styleName) {
			case "보통" : styleInt = Font.PLAIN; break;
			case "굵게" : styleInt = Font.BOLD; break;
		}
		
		jm.getJtaMemo().setFont(new Font(fontName, styleInt, sizeInt));
		mf.dispose();
	}
	
	public void setPreview(String fontName, int styleInt, int sizeInt) {
		// List 이벤트 처리 메서드인 valueChanged에서 처리
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		mf.dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selected = "";
		
		if(!e.getValueIsAdjusting()) { // 마우스를 땠을 때
			if (e.getSource() == mf.getJlFont()) { // 폰트List에 있는 아이템을 눌렀을 때
				selected = mf.getJlFont().getSelectedValue();
				mf.getJtfFont().setText(selected);
				
				//미리보기 즉시 변경
				Font font = mf.getJlblFont().getFont();
				mf.getJlblPreview().setFont(new Font(selected, font.getStyle(), font.getSize()));
				
			} else if (e.getSource() == mf.getJlStyle()) {
				selected = mf.getJlStyle().getSelectedValue();
				mf.getJtfStyle().setText(selected);
				
				//미리보기 즉시 변경
				Font font = mf.getJlblStyle().getFont();
				int styleInt = 0;
				switch(selected) {
					case "보통" : styleInt = Font.PLAIN; break;
					case "굵게" : styleInt = Font.BOLD; break;
				}
				
				mf.getJlblPreview().setFont(new Font(font.getName(), styleInt, font.getSize()));
				
				
			} else if (e.getSource() == mf.getJlSize()) {
				selected = mf.getJlSize().getSelectedValue();
				mf.getJtfSize().setText(selected);
				
				//미리보기 즉시 변경
				Font font = mf.getJlblSize().getFont();
				int sizeInt = Integer.parseInt(selected);
				mf.getJlblPreview().setFont(new Font(font.getName(), font.getStyle(), sizeInt));
			}
			
		}
		
		
	}
	
}
