package day0828;

import javax.swing.JOptionPane;

public class RunWork0827 {
	
	private Work0827 work;
	
	public RunWork0827() {
		work = new Work0827();
	}
	
	public void printDateFormat() {
		String nCode = JOptionPane.showInputDialog("국가코드를 입력\n0-한국,1-독일,2-미국,3-일본");
		System.out.println(work.dateFormat(Integer.parseInt(nCode)));
	}
	
	public void printBackupFile() {
//		System.out.println(work.backUpFile("c:/dev/hosts"));
	}
	
	public static void main(String[] args) {
		RunWork0827 rw0828 = new RunWork0827();
		rw0828.printDateFormat();
		rw0828.printBackupFile();
	}
}
