package day0929;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	
	public TestConnection() {
		// 1. 드라이버 로딩
		try {
//			OracleDriver od = new OracleDriver(); 
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. Connection 얻기
		String url ="jdbc:oracle:thin:@192.168.0.12:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		try {
			Connection con = DriverManager.getConnection(url, id, pass);
			System.out.println("얻어낸 Connection : " + con);
			
			PreparedStatement pstmt = con.prepareStatement("select empno from emp");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("empno"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new TestConnection();
	}
}
