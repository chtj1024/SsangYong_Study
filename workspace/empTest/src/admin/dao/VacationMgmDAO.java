package admin.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dto.DeptSelectDTO;
import admin.dto.VacationMgmDTO;
import getconnection.GetConnection;

public class VacationMgmDAO {
	private static VacationMgmDAO vDAO;

	private VacationMgmDAO() {
	}

	public static VacationMgmDAO getInstance() {
		if (vDAO == null) {
			vDAO = new VacationMgmDAO();
		}
		return vDAO;
	}

	public List<DeptSelectDTO> selectAllDepartments() throws SQLException, IOException {
		List<DeptSelectDTO> list = new ArrayList<>();
		GetConnection gc = GetConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = gc.getConn();
			String selectAllDepts = "select DEPT_CODE, DNAME from department where DELETE_YN = 0";
			pstmt = con.prepareStatement(selectAllDepts);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DeptSelectDTO dDTO = new DeptSelectDTO(rs.getInt("DEPT_CODE"), rs.getString("DNAME"));
				list.add(dDTO);
			}
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		return list;
	}

	public List<VacationMgmDTO> selectAllVacation() throws SQLException, IOException {
		List<VacationMgmDTO> list = new ArrayList<>();
		GetConnection gc = GetConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = gc.getConn();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT vu.USE_ID, e.EMP_ID, e.NAME, d.DNAME, p.PNAME, vt.VTNAME, vu.REASON, ")
			   .append(" TO_CHAR(vu.START_DATE, 'YYYY.MM.DD') START_DATE, ")
			   .append(" TO_CHAR(vu.END_DATE, 'YYYY.MM.DD') END_DATE, ")
			   .append(" CASE vu.APPROVE WHEN 'Y' THEN '승인' WHEN 'N' THEN '반려' WHEN 'P' THEN '보류' ELSE '요청' END AS APPROVE_TEXT ") // 별칭 변경
			   .append(" FROM EMPLOYEE e ")
			   .append(" JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_CODE ")
			   .append(" JOIN POSITION p ON e.POS_CODE = p.POS_CODE ")
			   .append(" JOIN VACATION_USE vu ON e.EMP_ID = vu.EMP_ID ")
			   .append(" JOIN VACATION_TYPE vt ON vu.VT_CODE = vt.VT_CODE ")
			   .append(" ORDER BY CASE vu.APPROVE WHEN 'P' THEN 1 WHEN 'N' THEN 2 WHEN 'Y' THEN 3 ELSE 4 END, vu.USE_ID DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VacationMgmDTO vmDTO = new VacationMgmDTO(
					rs.getInt("EMP_ID"),
					rs.getInt("USE_ID"),
					rs.getString("NAME"),
					rs.getString("DNAME"),
					rs.getString("PNAME"),
					rs.getString("VTNAME"),
					rs.getString("REASON"),
					rs.getString("START_DATE"),
					rs.getString("END_DATE"),
					rs.getString("APPROVE_TEXT") 
				);
				list.add(vmDTO);
			}

		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		return list;
	}

	public List<VacationMgmDTO> selectSearchVacation(String dName, String eName, String startDate, String endDate)
			throws SQLException, IOException {
		List<VacationMgmDTO> list = new ArrayList<>();
		GetConnection gc = GetConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = gc.getConn();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT vu.USE_ID, e.EMP_ID, e.NAME, d.DNAME, p.PNAME, vt.VTNAME, vu.REASON, ")
			   .append(" TO_CHAR(vu.START_DATE, 'YYYY.MM.DD') START_DATE, ")
			   .append(" TO_CHAR(vu.END_DATE, 'YYYY.MM.DD') END_DATE, ")
			   .append(" CASE vu.APPROVE WHEN 'Y' THEN '승인' WHEN 'N' THEN '반려' WHEN 'P' THEN '보류' ELSE '요청' END AS APPROVE_TEXT ") // 별칭 변경
			   .append(" FROM EMPLOYEE e ")
			   .append(" JOIN DEPARTMENT d ON e.DEPT_CODE = d.DEPT_CODE ")
			   .append(" JOIN POSITION p ON e.POS_CODE = p.POS_CODE ")
			   .append(" JOIN VACATION_USE vu ON e.EMP_ID = vu.EMP_ID ")
			   .append(" JOIN VACATION_TYPE vt ON vu.VT_CODE = vt.VT_CODE ")
			   .append(" WHERE 1=1 ");

			if(!"전체".equals(dName)) {
				sql.append(" AND d.DNAME = ? ");
			}
			if(eName != null && !eName.isEmpty()) {
				sql.append(" AND e.NAME LIKE ? ");
			}
			sql.append(" AND vu.START_DATE >= TO_DATE(?, 'YYYY-MM-DD') ");
			sql.append(" AND vu.END_DATE <= TO_DATE(?, 'YYYY-MM-DD') ");
			sql.append(" ORDER BY CASE vu.APPROVE WHEN 'P' THEN 1 WHEN 'N' THEN 2 WHEN 'Y' THEN 3 ELSE 4 END, vu.USE_ID DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int bindIndex = 1;
			if(!"전체".equals(dName)) {
				pstmt.setString(bindIndex++, dName);
			}
			if(eName != null && !eName.isEmpty()) {
				pstmt.setString(bindIndex++, "%" + eName + "%");
			}
			pstmt.setString(bindIndex++, startDate);
			pstmt.setString(bindIndex++, endDate);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VacationMgmDTO vmDTO = new VacationMgmDTO(
					rs.getInt("EMP_ID"),
					rs.getInt("USE_ID"),
					rs.getString("NAME"),
					rs.getString("DNAME"),
					rs.getString("PNAME"),
					rs.getString("VTNAME"),
					rs.getString("REASON"),
					rs.getString("START_DATE"),
					rs.getString("END_DATE"),
					rs.getString("APPROVE_TEXT") 
				);
				list.add(vmDTO);
			}

		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		return list;
	}
}