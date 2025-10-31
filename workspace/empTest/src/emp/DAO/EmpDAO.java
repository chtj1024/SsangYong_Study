package emp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import emp.DTO.MyPageDTO;
import emp.DTO.SalCheckDTO;
import getconnection.GetConnection;

public class EmpDAO {
	private static EmpDAO eDAO;

	private EmpDAO() {

	}

	public static EmpDAO getInstance() {
		if (eDAO == null) {
			eDAO = new EmpDAO();
		}
		return eDAO;
	}

//======================마이페이지==========
//기본정보 가져오기
	public MyPageDTO getUserProfile(int empno) throws SQLException, IOException {
		MyPageDTO mDTO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();// 부서명(dname) 부서테이블(department),직급명(pname) 직급테이블(position)
			String userProfile = "SELECT p.pname, d.dname, e.emp_id, e.name, e.tel, e.email, e.addr	"
					+ "FROM employee e	" 
					+ "inner JOIN department d	" 
					+ "on e.dept_code = d.dept_code	"
					+ "inner JOIN position p	" 
					+ "on e.pos_code = p.pos_code	" 
					+ "where e.emp_id = ?	";

			pstmt = con.prepareStatement(userProfile);
			pstmt.setInt(1, empno);
			// 바인드 변수에 값 설정
			// 5.쿼리문 수행후 결과얻기 ( cursor의 제어권을 얻기 )
			// 조회결과를 움직일 수 있는 cursor의 제어권을 받음.
			rs = pstmt.executeQuery();

			// private String empJob,deptName,empName,ID,currentPass,
//		newPass,confirmPass,email,addr,tel, empno;
//		부서명(dname) 부서테이블(department),직급명(pname) 직급테이블(position)

			if (rs.next()) {
				mDTO = new MyPageDTO();
				mDTO.setDeptName(rs.getString("dname"));
				mDTO.setEmpJob(rs.getString("pname"));
				mDTO.setEmp_id(rs.getInt("emp_id"));
				mDTO.setEmpName(rs.getString("name"));
				mDTO.setTel(rs.getString("tel"));
				mDTO.setEmail(rs.getString("email"));
				mDTO.setAddr(rs.getString("addr"));

			}

		} finally {
			gc.dbClose(con, pstmt, rs);

		}
		return mDTO;

	}

	// 개인정보수정
	public int updateMyInfo(MyPageDTO mDTO) throws SQLException, IOException {
		int temp = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
			StringBuilder updateMyinfo = new StringBuilder();
//			StringBuilder updateMyinfo=new StringBuilder();
			updateMyinfo.append("	update	 employee	").append(" set 	tel=?,	email=?,	addr=?")
					.append("	where emp_id=?		 ");

			pstmt = con.prepareStatement(updateMyinfo.toString());
			// 바인드변수에 값 설정
			pstmt.setString(1, mDTO.getTel());
			pstmt.setString(2, mDTO.getEmail());
			pstmt.setString(3, mDTO.getAddr());
			pstmt.setInt(4, mDTO.getEmp_id());
			// 쿼리문 수행 후 결과 얻기
			temp = pstmt.executeUpdate();

		} finally {
			// 연결끊기
			gc.dbClose(con, pstmt, null);
		}

		return temp;
	}// updateMyInfo

	// 기존비밀번호 가져오기
	public String selectPassword(int empno) throws SQLException, IOException {
		String password = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();

			String sql = "select pwd from employee where emp_id=?	";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				password = rs.getString("pwd");
			}

		} finally {
			gc.dbClose(con, pstmt, rs);
		}

		return password;
	}// selectPassword

	// 비번변경
	public int updatePassword(MyPageDTO mDTO) throws SQLException, IOException {
		int temp = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
			String sqlPassword = "update employee set pwd=? where emp_id=?";
			pstmt = con.prepareStatement(sqlPassword);
			pstmt.setString(1, mDTO.getPass());
			pstmt.setInt(2, mDTO.getEmp_id());

			// 쿼리문수행후 결과얻기
			temp = pstmt.executeUpdate();

		} finally {
			gc.dbClose(con, pstmt, null);

		}

		return temp;
	}// updatePassword

//===========급여조회============

//사원정보 조회
	public SalCheckDTO selectEmpInfo(int empno) throws SQLException, IOException {
		SalCheckDTO sDTO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
//		String userProfile=//사원명(name),직급(pname),사원번호(emp_id),
//				입사일(hire_date),연봉(sal),월급(pay),pay_type(1) 보너스(pay),pay_type(2)
		String empProfile = "SELECT e.name, p.pname, e.emp_id, e.hire_date, s.sal, "
			+ "  SUM(CASE WHEN pr.pay_type = 1 THEN pr.pay ELSE 0 END) AS totalPay, "
			+ "  SUM(CASE WHEN pr.pay_type = 2 THEN pr.pay ELSE 0 END) AS bonusPay " 
			+ "FROM employee e "
			+ "INNER JOIN salary s ON e.sal_code = s.sal_code "
			+ "INNER JOIN position p ON e.pos_code = p.pos_code "
			+ "INNER JOIN payroll pr ON e.emp_id = pr.emp_id " 
			+ "WHERE e.emp_id = ? "
			+ "GROUP BY e.name, p.pname, e.emp_id, e.hire_date, s.sal";
	
		pstmt=con.prepareStatement(empProfile);
		pstmt.setInt(1, empno);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			sDTO =new SalCheckDTO();
			sDTO.setEmpName(rs.getString("name"));
			sDTO.setEmpJob(rs.getString("pname"));
			sDTO.setEmp_id(rs.getInt("emp_id"));
			sDTO.setHiredate(rs.getDate("hire_date"));
			
			sDTO.setYearlySal(rs.getInt("sal"));
			sDTO.setMonthlySal(rs.getInt("totalPay"));
			sDTO.setBonus(rs.getInt("bonusPay"));
			
		}

		} finally {
			gc.dbClose(con, pstmt, rs);
		}

		return sDTO;
	}

//연도별 급여조회
	public List<SalCheckDTO> selectSalaryByYear(int year, int empno) {
		
		List<SalCheckDTO> list= new ArrayList<>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		GetConnection gc= GetConnection.getInstance();
		
		
		//급여지급일 pay_date 지급액 paytype1 보너스지급액paytype2 세금3.3% 실지급액 pay+paytype2-3.3%
		try {
			con=gc.getConn();
			
			String salInfo =
			"SELECT pay_date, t.totalPay, t.bonusPay, "
			+" Round(t.totalpay * 0.033) as tax, "
			+ " t.totalPay + t.bonusPay -Round(t.totalPay * 0.033) as realPay "
			+"FROM ( "
			+"SELECT pr.pay_date, "
			+" NVL(SUM(CASE WHEN pr.pay_type = 1 THEN pr.pay ELSE 0 END),0) AS totalPay, "
			+" NVL(SUM(CASE WHEN pr.pay_type = 2 THEN pr.pay ELSE 0 END),0) AS bonusPay "
			+" FROM payroll pr "
			+" Where pr.emp_id =? " 
			+" AND extract(Year from pr.pay_date) = ?"
			+" GROUP BY pr.pay_date) t"
			+" ORDER BY t.pay_date DESC";
			
			
			pstmt = con.prepareStatement(salInfo);
			pstmt.setInt(1, empno);
			pstmt.setInt(2, year);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SalCheckDTO sDTO= new SalCheckDTO();
				sDTO.setPayDate(rs.getDate("pay_date"));
				sDTO.setTotalPay(rs.getInt("totalPay"));
				sDTO.setBonusPay(rs.getInt("bonusPay"));
				sDTO.setTax(rs.getInt("tax"));
				sDTO.setRealPay(rs.getInt("realPay"));
				
				list.add(sDTO);
				
			}
		
			}catch (IOException | SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					gc.dbClose(con, pstmt, rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return list;
				
		
	}//selectSalaryByYear


	

}// class