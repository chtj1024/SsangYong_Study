package day1021;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.pstmt.dao.GetConnection;

public class UseCallableStatement {

	public void useCallable(int num, int num2) throws SQLException, IOException{
		// 1. 드라이버 로딩
		// 2. 커넥션 얻기
		Connection con = null;
		CallableStatement cstmt = null;
		
		GetConnection gc = GetConnection.getInstance();
		try {
			con = gc.getConn();
		// 3. 쿼리문 실행객체 얻기
			cstmt = con.prepareCall("{ call }");
		// 4. 바인드 변수에 값 설정
			// in parameter
			cstmt.setInt(1, num);
			cstmt.setInt(2, num2);
			// out parameter 등록( oracle bind변수 응용)
			cstmt.registerOutParameter(3, Types.NUMERIC);
			cstmt.registerOutParameter(4, Types.VARCHAR);
		// 5. 쿼리문 수행
			cstmt.execute();
		// 6. out parameter에 저장된 값 얻기
			int sum = cstmt.getInt(3);
			String msg = cstmt.getString(4);
			
			System.out.println("결과 값" + sum);
			System.out.println("메세지 " + msg);
			
		} finally {
		// 7. 연결 끊기
		}
	}
	
	public static void main(String[] args) {
		UseCallableStatement ucs = new UseCallableStatement();
		
		try {
			for (int i = 0; i < 100; i++) {
				ucs.useCallable(10, 21);				
				Thread.sleep(500);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
