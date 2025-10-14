package test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day1013.Singleton;
import kr.co.sist.pstmt.dao.GetConnection;
import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.pstmt.service.PstmtMemberService;
import kr.co.sist.statement.dto.MemberDTO;

class PstmtTest {

	@Disabled
	@DisplayName("DAO 회원정보 추가테스트")
	@Test
	void testDAO() {
		PstmtMemberDAO pmDAO = PstmtMemberDAO.getInstance();
		MemberDTO mDTO = new MemberDTO(0, 5, "민병조", "남자", "010-1234-1234", null);
		try {
			assertEquals(pmDAO.insertMember(mDTO), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Disabled
	@DisplayName("DAO 회원정보 변경테스트")
	@Test
	void testUpdateMember() {
		PstmtMemberDAO pmDAO = PstmtMemberDAO.getInstance();
		MemberDTO mDTO = new MemberDTO(22, 25, null, null, "010-1234-1234", null);
		try {
			assertEquals(pmDAO.updateMember(mDTO), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@DisplayName("DAO 회원정보 삭제 테스트")
	@Test
	void testDeleteMember() {
		PstmtMemberDAO pmDAO = PstmtMemberDAO.getInstance();
		try {
			assertEquals(pmDAO.deleteMember(22), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Disabled
	@DisplayName("Service 회원정보 추가")
	@Test
	void testService() {
		PstmtMemberService pms = new PstmtMemberService();
		MemberDTO mDTO = new MemberDTO(0, 5, "민병조", "남자", "010-1234-1234", null);
		assertTrue(pms.addMember(mDTO));
	}

	@Disabled
	@DisplayName("Service 회원정보 추가")
	@Test
	void testSingleton() {
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		// 객체의 주소가 같나 ? (사용연산자 == assert method로는 assertSame(객체, 객체))
		assertSame(s, s2);
		
//		assertNotSame(s, s2);
	}
	
	@Disabled
	@DisplayName("DB Connection")
	@Test
	void getConnection() {
		GetConnection gc = GetConnection.getInstance();
		Connection con;
		try {
			con = gc.getConn();
			assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
