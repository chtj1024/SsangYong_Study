package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {
	
	private static GetConnection getCon;
	
	private GetConnection() {
		
	}
	
	public static GetConnection getInstance() {
		if(getCon == null) {
			getCon = new GetConnection();
		}
		return getCon;
	}
	
	public Connection getConn() throws SQLException, IOException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		File file = new File("C:/dev/workspace/project1_sal_pay_bonus/src/properties/database.properties");
		if(!file.exists()) {
			throw new IOException("properties가 지정된 위치에 존재하지 않습니다,");
		}
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(file));
		
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String pass = prop.getProperty("pass");
		
		Connection con = DriverManager.getConnection(url, id, pass);
		
		return con;
	}
	
	public void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		try {
			if(rs != null) { rs.close();}
			if(pstmt != null) { pstmt.close();}
		} finally {
			if(con != null) {con.close();}
		}
	}
}
