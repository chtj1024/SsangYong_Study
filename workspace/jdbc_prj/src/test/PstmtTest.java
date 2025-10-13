package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.pstmt.service.PstmtMemberService;
import kr.co.sist.statement.dto.MemberDTO;

class PstmtTest {

	@Disabled
	@DisplayName("DAO 회원정보 추가")
	@Test
	void testDAO() {
		PstmtMemberDAO pmDAO = new PstmtMemberDAO();
		MemberDTO mDTO = new MemberDTO(0, 5, "민병조", "남자", "010-1234-1234", null);
		assertEquals(pmDAO.insertMember(mDTO), 1);
	}
	
	@DisplayName("Service 회원정보 추가")
	@Test
	void testService() {
		PstmtMemberService pms = new PstmtMemberService();
		MemberDTO mDTO = new MemberDTO(0, 5, "민병조", "남자", "010-1234-1234", null);
		assertTrue(pms.addMember(mDTO));
	}

}
