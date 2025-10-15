package day1014;

import java.io.IOException;
import java.sql.SQLException;

public class LobService {

	public boolean addFriends(LobDTO lDTO) {
		boolean flag = false;
		
		LobDAO lDAO = LobDAO.getInstance();
		try {
			lDAO.insertFriendsMgr(lDTO);
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public LobDTO searchFriend(int num) {
		LobDTO lDTO = null;
		LobDAO lDAO = LobDAO.getInstance();
		try {
			lDTO = lDAO.selectFriends(num);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lDTO;
	}
}
