package kr.co.sist.pstmt.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.statement.dto.MemberDTO;

public class PstmtMemberService {
	private PstmtMemberDAO mDAO;
	
	public PstmtMemberService() {
		mDAO = new PstmtMemberDAO();
	}
	
	public boolean addMember(MemberDTO mDTO) {
		boolean flag = false; // 실패 상태
		
		mDAO.insertMember(mDTO); // DB에 추가 작업이 문제가 없다면
		flag = true; // 성공 상태
		
		return flag;
	}
	
	public List<String> searchAllMember() {
		List<String> list = new ArrayList<String>();
		StringBuilder searchMember = new StringBuilder();
		try {
			List<MemberDTO> tempList = mDAO.selectAllMember();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a", Locale.UK);
			
			for(MemberDTO mDTO : tempList) {
				searchMember.delete(0, searchMember.length());
				searchMember
				.append(mDTO.getNum()).append(",")
				.append(mDTO.getName()).append(",")
				.append(mDTO.getAge()).append(",")
				.append(mDTO.getGender()).append(",")
				.append(mDTO.getTel()).append(",")
				.append(sdf.format(mDTO.getInput_date()));
				
				list.add(searchMember.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public MemberDTO searchOneMember(int num) {
		MemberDTO mDTO = null;		
		try {
			mDTO = mDAO.selectOneMember(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mDTO;
	}
	
	/**
	 * 회원번호를 입력받아서 해당 회원을 삭제하는 일 
	 * 회원정보를 변경 - 0 : 회원번호 없음, 1-회원번호 n있음, 2-DB문제 발생
	 * @param mDTO
	 * @return
	 */
	public int modifyMember(MemberDTO mDTO) {
		int flag = 0;
		
		try {
			flag = mDAO.updateMember(mDTO);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반환 될 수 있고
			//그 경우에는 1로 재설정한다.
		} catch (SQLException e) {
			flag = 2;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public int removeMember(int memberNum) {
		int flag = 0;
		
		try {
			flag = mDAO.deleteMember(memberNum);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반환 될 수 있고
			//그 경우에는 1로 재설정한다.
		} catch (SQLException e) {
			flag = 2;
			e.printStackTrace();
		}
		
		return flag;
	}
}
