package day1014;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;

public class LobDTO {
	private int num;
	private String name, email, tel, intro, ext;
	private FileInputStream img;
	private Date inputDate;
	private File file;
	
	public LobDTO() {
		
	}

	public LobDTO(int num, String name, String email, String tel, String intro, String ext, FileInputStream img,
			Date inputDate, File file) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.intro = intro;
		this.ext = ext;
		this.img = img;
		this.inputDate = inputDate;
		this.file = file;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public FileInputStream getImg() {
		return img;
	}

	public void setImg(FileInputStream img) {
		this.img = img;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "LobDTO [num=" + num + ", name=" + name + ", email=" + email + ", tel=" + tel + ", intro=" + intro
				+ ", ext=" + ext + ", img=" + img + ", inputDate=" + inputDate + ", file=" + file + "]";
	}

	
}
