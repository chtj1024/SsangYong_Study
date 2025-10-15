package day1014;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import kr.co.sist.util.img.ImageResize;

public class Work1013Evt extends WindowAdapter implements ActionListener{
	private Work1013Design wd;
	
	private String selectedImg; // null
	
	public Work1013Evt(Work1013Design wd) {
		this.wd = wd;
		selectedImg = "";
	}

	/**
	 * 이미지 미리보기
	 */
	public void previewImg() {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(wd);
		
		File file = jfc.getSelectedFile();
		if(file != null) {
			//선택한 파일의 크기를 170(w) x 170(h)로 변경하고, 이미지 아이콘에 설정한다.
			String fileName = file.getName();
			String ext = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			
			//이미지는 png, jpg, gif, bmp만 사용한다.
			//위의 확장자일 때 true 그렇지 않으면 false를 출력
			
			String allowedExt = "png,jpg,gif,bmp";
			boolean flag = false;
			String[] tempExtArr = allowedExt.split(",");
			
			for(String tempExt : tempExtArr) {
				if(flag = tempExt.equals(ext)) {
					break;
				}
			}
			
			if (!flag) {
				JOptionPane.showMessageDialog(wd, "이미지파일(png,jpg,gif,bmp)만 허용합니다.");
			}
			
			//이미지의 크기를 변경 : 170(w) x 170(h)
			ImageResize.resizeImage(file.getAbsolutePath(), 170, 170);
			selectedImg = file.getParent() + File.separator + "rs_" + file.getName();
			
			wd.getJlbImage().setIcon(new ImageIcon(selectedImg));
		}
	}
	
	public void addFriends() throws IOException {
		// 이름, 이메일, 전화번호, 인트로, 이미지를 받아와서 추가 작업 수행
		String name = wd.getJtfName().getText().trim();
		String email = wd.getJtfEmail().getText().trim();
		String tel = wd.getJtfPhone().getText().trim();
		String intro = wd.getJtaInform().getText().trim();
		
		//이미지가 선택되지 않았을 때
		if ("".equals(selectedImg)) {
			JOptionPane.showMessageDialog(wd, "이미지를 선택해주세요.");
			return;
		}
		
		File file = new File(selectedImg);
		FileInputStream fisImg = new FileInputStream(file);
		
		// 유효성 검증선행. 희망회로
		// 이름 empty 아니면
		
		String ext = file.getName().substring(file.getName().lastIndexOf("."));
		LobDTO lDTO = new LobDTO(0, name, email, tel, intro, ext,  fisImg, null, file);
		
		LobService ls = new LobService();
		
		String msg = "친구를 추가할 수 없습니다. 잠시 후 다시 시도해주세요";
		
		if(ls.addFriends(lDTO)) {
			msg = "친구를 정상적으로 추가하였습니다.";
			//변경된 크기의 이미지를 삭제. 참조하는 프로세스가 있으면 지워지지 않는다.
			if(fisImg != null) {fisImg.close();}
			lDTO.getFile().delete();
		}
		
		selectedImg = "";
		JOptionPane.showMessageDialog(wd, msg);
		
		//입력칸 초기화
		wd.getJtfName().setText("");
		wd.getJtfEmail().setText("");
		wd.getJtfPhone().setText("");
		wd.getJtaInform().setText("");
		ImageIcon ii = new ImageIcon("C:\\dev\\workspace\\jdbc_prj\\src\\day1014\\images\\rs_default_img.png");
		wd.getJlbImage().setIcon(ii);
	}
	
	public void searchFriends() {
		LobService ls = new LobService();
		String tempNum = wd.getJtfNum().getText();
		
		if(tempNum.isEmpty()) {
			JOptionPane.showMessageDialog(wd, "검색하려는 친구의 번호를 입력해주세요.");
			return;
		}
		try {
			int num = Integer.parseInt(tempNum);
			LobDTO lDTO = ls.searchFriend(num);
			if(lDTO == null ) {				
				JOptionPane.showMessageDialog(wd, num + "으로 검색된 친구는 존재하지 않습니다.");
				return;
			}
			
			wd.getJtfName().setText(lDTO.getName());
			wd.getJtfEmail().setText(lDTO.getEmail());
			wd.getJtfPhone().setText(lDTO.getTel());
			wd.getJtaInform().setText(lDTO.getIntro());
			
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream("C:\\dev\\workspace\\jdbc_prj\\src\\properties\\database.properties"));
				ImageIcon ii = new ImageIcon(prop.getProperty("savePath")+
						lDTO.getNum()+"." + lDTO.getExt());
				wd.getJlbImage().setIcon(ii);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(wd, "검친구의 번호는 정수 형태 입니다.");
			nfe.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == wd.getJbtnAdd()) {
			try {
				addFriends();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource() == wd.getJbtnClose()) {
		}
		if(ae.getSource() == wd.getJbtnImage()) {
			previewImg();
		}
		if(ae.getSource() == wd.getJbtnSearch()) {			
			searchFriends();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		wd.dispose();
	}
	
	
}
