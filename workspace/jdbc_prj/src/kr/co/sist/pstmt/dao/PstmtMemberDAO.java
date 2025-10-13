package kr.co.sist.pstmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.statement.dto.MemberDTO;

/**
 * DAO(Data Access Object) : DBMS에 대한 작업만 정의. method명은 SQL문을 넣어서 정의
 */
public class PstmtMemberDAO {

	/**
	 * 회원정보를 member table에 추가하는 일
	 * @param mDTO 추가할 회원정보
	 * @return 추가 된 행의 수 1-성공, 0-실패
	 */
	public int insertMember(MemberDTO mDTO) {
		int rowCnt = 0;
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 로딩 된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
	
		PreparedStatement pstmt = null;
		// 사용이 종료되면 자원을 알아서 끊어준다.
		try(Connection con = DriverManager.getConnection(url, id, pass)) {
			// 3. 쿼리문 생성 객체 얻기
			String insertMember =
					"insert into member(num,name,age,gender,tel) values(seq_member.nextval, ?, ?, ?, ?)";
								
			// 4.바인드 변수에 값 설정
			pstmt = con.prepareStatement(insertMember);
			pstmt.setString(1, mDTO.getName());
			pstmt.setInt(2, mDTO.getAge());
			pstmt.setString(3, mDTO.getGender());
			pstmt.setString(4, mDTO.getTel());
			
			//5. 쿼리문 수행 후 결과 얻기
			rowCnt = pstmt.executeUpdate();
			if(pstmt != null) {pstmt.close();}
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return rowCnt;
	}

	/**
	 * 회원 정보를 변경하는 일
	 * 
	 * @param mDTO
	 * @return 0-회원번호 없음, 1-회원번호로 삭제
	 * @throws SQLException DBMS에서 문제 발생
	 */
	public int updateMember(MemberDTO mDTO) throws SQLException {
		int flag = 0;

		//// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 로딩 된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;

		con = DriverManager.getConnection(url, id, pass);
		// 3. 쿼리문 생성 객체 얻기
		stmt = con.createStatement();

		// 회원번호를 사용하여 나이, 전화번호를 변경
		StringBuilder updateMember = new StringBuilder();
		updateMember.append("	update	member	").append("	set		age	=").append(mDTO.getAge()).append(",")
				.append("tel='").append(mDTO.getTel()).append("'").append("	where	num=").append(mDTO.getNum());

		// 4. 쿼리문 수행 후 결과 얻기
		flag = stmt.executeUpdate(updateMember.toString()); // 변경한 행의 수 리턴

		try {
			// 5. 연결 끊기
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 회원정보를 삭제하는 일.
	 * 
	 * @param memberNum 삭제할 회원번호
	 * @return 0-회원번호 없음, 1-회원번호로 삭제
	 * @throws SQLException DBMS에서 문제 발생
	 */
	public int deleteMember(int memberNum) throws SQLException {
		int flag = 0;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 로딩 된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;

		con = DriverManager.getConnection(url, id, pass);
		// 3. 쿼리문 생성 객체 얻기
		stmt = con.createStatement();

		// 회원번호를 사용하여 레코드를 삭제
		StringBuilder deleteMember = new StringBuilder();
		deleteMember
		.append("	delete	from member	")
		.append("	where	num = ").append(memberNum);

		// 4. 쿼리문 수행 후 결과 얻기
		flag = stmt.executeUpdate(deleteMember.toString()); // 변경한 행의 수 리턴
		System.out.println(flag + "건 삭제되었습니다.");

		try {
			// 5. 연결 끊기
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 모든 사원 정보를 검색
	 * 
	 * @return 모든 사원 정보
	 * @throws SQLException
	 */
	public List<MemberDTO> selectAllMember() throws SQLException {
		List<MemberDTO> list = new ArrayList<MemberDTO>();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 로딩 된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		MemberDTO mDTO = null;
		try {
			con = DriverManager.getConnection(url, id, pass);
			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기 (cursor의 제어권을 얻기)
			String selectMember = "select num, name, age, gender, tel, input_date from member order by num";
			// 조회결과를 움직일 수 있는 cursor의 제어권을 받음.
			rs = stmt.executeQuery(selectMember);

			int num = 0; // 회원번호
			String name = ""; // 회원명
			int age = 0; // 회원 나이
			String gender = ""; // 성별
			String tel = ""; // 전화번호
			Date inputDate = null;

			while (rs.next()) { // 조회결과에 다음 레코드가 존재하는지
				num = rs.getInt("num");
				name = rs.getString("name");
				age = rs.getInt("age");
				gender = rs.getString("gender");
				tel = rs.getString("tel");
				inputDate = rs.getDate("input_date");
//				System.out.println(num + " / " + name + " / " + age + " / "
//						+ gender + " / " + tel + " / " + inputDate);

				// 조회 결과 값을 하나로 묶어서 관리하기 위해 DTO(VO) 설정
				mDTO = new MemberDTO(num, age, name, gender, tel, inputDate);
				// 같은 이름의 객체가 사라지지 않게 List에 추가
				list.add(mDTO);
			}

		} finally {
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
		}

		return list;
	}

	public MemberDTO selectOneMember(int memberNum) throws SQLException {
		MemberDTO mDTO = null;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pwd = "tiger";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = DriverManager.getConnection(url, user, pwd);
		// 3. 쿼리문 생성객체 얻기
		stmt = con.createStatement();
		StringBuilder selectOneMember = new StringBuilder();
		selectOneMember.append("	SELECT NAME, AGE, GENDER, TEL, INPUT_DATE	").append("	FROM MEMBER	")
				.append("	WHERE NUM =	").append(memberNum);

		rs = stmt.executeQuery(selectOneMember.toString());

		if (rs.next()) { // 쿼리로 인한 조회 결과가 존재
			mDTO = new MemberDTO();
			mDTO.setNum(memberNum);
			mDTO.setName(rs.getString("name"));
			mDTO.setAge(rs.getInt("age"));
			mDTO.setGender(rs.getString("gender"));
			mDTO.setTel(rs.getString("tel"));
			mDTO.setInput_date(rs.getDate("input_date"));
		}

		// 4. 쿼리문 수행 후 결과 얻기
		// 5. 연결 끊기

		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		if (rs != null)
			rs.close();

		return mDTO;
	}

	public String searchOneMember(int num) {
		String searchMember = "";

		return searchMember;
	}
}
