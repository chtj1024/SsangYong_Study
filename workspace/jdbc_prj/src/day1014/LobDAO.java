package day1014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import kr.co.sist.pstmt.dao.GetConnection;

public class LobDAO {
	private static LobDAO lDAO;
	
	private LobDAO() {
		
	}
	
	public static LobDAO getInstance() {
		if (lDAO == null) {
			lDAO = new LobDAO();
		}
		return lDAO;
	}
	
	public void insertFriendsMgr(LobDTO lDTO) throws SQLException, IOException {
		//1. 드라이버 로딩
		//2. 커넥션 얻기
		Connection con = null;
		PreparedStatement pstmt = null;
		
		GetConnection gc = GetConnection.getInstance();
		try {
			con = gc.getConn();
		
		//3. 쿼리문 생성객체 얻기
			String insertFriends =
				"insert into friends_mgr(num, name, email, tel, intro, img, ext)"
				+ "values(seq_friends.nextval,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(insertFriends);
		//4. 바인드 변수에 값 설정
			pstmt.setString(1, lDTO.getName());
			pstmt.setString(2, lDTO.getEmail());
			pstmt.setString(3, lDTO.getTel());
			pstmt.setString(4, lDTO.getIntro());
			pstmt.setBinaryStream(5, lDTO.getImg(), lDTO.getFile().length());
			pstmt.setString(6, lDTO.getExt());
		//5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			
		//6. 연결 끊기
			gc.dbClose(con, pstmt, null);
		}
	}
	
	/**
	 * BLOB데이터를 읽어 들이기위해서 스트림을 사용한다.
	 * @return
	 */
	public LobDTO selectFriends(int num) throws SQLException, IOException{
		LobDTO lDTO = null;
		
		//1.
		//2.
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		InputStream is = null;
		FileOutputStream fos = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
		//3.
			StringBuilder selectFriend = new StringBuilder();
			selectFriend
			.append("	select	name, email, tel, intro, img, ext, input_date	")
			.append("	from	friends_mgr	")
			.append("	where	num = ?	");
			
			pstmt = con.prepareStatement(selectFriend.toString());
		//4.
			pstmt.setInt(1, num);
		//5.
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lDTO = new LobDTO();
				lDTO.setNum(num); //입력된 번호 할당
				//DBMS table에서 조회된 결과를 설정
				lDTO.setName(rs.getString("name"));
				lDTO.setEmail(rs.getString("email"));
				lDTO.setTel(rs.getString("tel"));
//				lDTO.setIntro(rs.getString("intro")); // CLOB : Windows에서는 getString로 가져올 수 있다.
				// CLOB은 4Gbyte까지의 문자열을 저장할 수 있으므로 별도의 스트림을 연결하여
				// 데이터를 읽어들인다.
				StringBuilder intro = new StringBuilder();
				Clob clob = rs.getClob("intro");
				if(clob != null) {
					BufferedReader br = null;
					
					try {
						br = new BufferedReader(clob.getCharacterStream());
						String temp = "";
						while((temp = br.readLine()) != null) { // 읽어들인 값이 존재하면
							intro.append(temp).append("\n");
						}
						if(br != null) {br.close();}
						lDTO.setIntro(intro.toString());
					} finally {
	
					}
				}
				
				lDTO.setExt(rs.getString("ext"));
				lDTO.setInputDate(rs.getDate("input_date"));
				//이미지는 스트림을 별도로 연결하여 읽어 들인다.
				Properties prop = new Properties();
				prop.load(new FileInputStream("C:\\dev\\workspace\\jdbc_prj\\src\\properties\\database.properties"));
				
				File dir = new File(prop.getProperty("savePath"));
				//디렉토리가 없다면 디렉토리를 생성
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				//다운로드 되는 파일명은 PK값 + 확장자의 형식
				File file = new File(dir.getAbsolutePath() + File.separator +
						lDTO.getNum() + "." + lDTO.getExt());
				
				fos = new FileOutputStream(file); // 파일이 존재하면 덮어 쓰고 존재하지 않으면 생성
				
				is = rs.getBinaryStream("img");
				int dataLength = 0;
				byte[] readData = new byte[512];
				while((dataLength = is.read(readData)) != -1) { // 읽어들인 내용이 존재한다면
					//읽어들인 내용의 길이까지를 출력스트림으로 출력
					fos.write(readData, 0 , dataLength);
				}
				fos.flush();
			}
			
		} finally {
		//6.
			if(is != null) { is.close();}
			if(fos != null) { fos.close();}
			
			gc.dbClose(con, pstmt, rs);
		}
		return lDTO;
	}
}
