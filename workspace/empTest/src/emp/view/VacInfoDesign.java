package emp.view;

import javax.swing.JFrame;

import javax.swing.JPanel;

import emp.DTO.UserInfoDTO;
import emp.event.VacInfoEvt;

public class VacInfoDesign extends JFrame {
	private VacInfoNorthPanel vinp;
	private VacInfoCenterPanel vicp;
	private VacInfoSouthPanel visp;
	

	public VacInfoDesign(UserInfoDTO user) {
		super("휴가 정보");
		
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
		vinp = new VacInfoNorthPanel();
		vicp = new VacInfoCenterPanel();
		visp = new VacInfoSouthPanel();
		
		VacInfoEvt vie = new VacInfoEvt(this,user.getEmpId());
		vinp.setVacDay(vie);
		vicp.setEvent(vie);
		visp.setVacInfo(vie);
		
		
		jpNorth.add(vinp);
		jpCenter.add(vicp);
		jpSouth.add(visp);
		
		add("North", jpNorth);
		add("Center", jpCenter);
		add("South", jpSouth);
		
		setVisible(true);
		setBounds(100, 100, 586, 441);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public VacInfoNorthPanel getVinp() { return vinp; }
	public VacInfoCenterPanel getVicp() { return vicp; }
	public VacInfoSouthPanel getVisp() { return visp; }

}
