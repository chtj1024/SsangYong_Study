package admin.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dto.AddEmpDTO;
import getconnection.GetConnection;

public class AddEmpDAO {
   private static AddEmpDAO aDAO;
   
   private AddEmpDAO() {}
   
   public static AddEmpDAO getInstance() {
      if(aDAO == null) {
         aDAO = new AddEmpDAO();
      }
      
      return aDAO;
   }
   
   public int selectDept(String dname) throws SQLException, IOException {
      int result = 0;
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String select = "select dept_code from department where dname LIKE ?";
         
         pstmt = con.prepareStatement(select);
         
         pstmt.setString(1, "%" + dname + "%");
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            result = rs.getInt("dept_code");
         }
         
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   
   public int selectPos(String pname) throws SQLException, IOException {
      int result = 0;
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String select = "select pos_code from position where pname LIKE ?";
         
         pstmt = con.prepareStatement(select);
         
         pstmt.setString(1, "%" + pname + "%");
         
         rs = pstmt.executeQuery();
         
         if(rs.next()) {
            result = rs.getInt("pos_code");
         }
         
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   
   public int selectSal(int sal) throws SQLException, IOException {
      int result = 0;
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String select = "select sal_code from salary where sal = ?";
         
         pstmt = con.prepareStatement(select);
         
         pstmt.setInt(1, sal);
         
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt("sal_code");
         }
         
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   
   public List<String> selectAllDept() throws SQLException, IOException{
      List<String> result = new ArrayList<String>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectDept = "select dname from department where delete_yn = 0";
         
         pstmt = con.prepareStatement(selectDept);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            result.add(rs.getString("dname"));
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   
   public List<String> selectAllPosition() throws SQLException, IOException{
      List<String> result = new ArrayList<String>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectPos = "select pname from position";
         
         pstmt = con.prepareStatement(selectPos);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            result.add(rs.getString("pname"));
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   public List<String> selectAllSal() throws SQLException, IOException{
      List<String> result = new ArrayList<String>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectSal = "select sal from salary";
         
         pstmt = con.prepareStatement(selectSal);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            result.add(rs.getString("sal"));
         }
         
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
   
   public int insertEmp(AddEmpDTO aed) throws SQLException, IOException {
      int result = 0;
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String insertEmp = "insert into employee(emp_id, name, dept_code, pos_code, sal_code, hire_date, addr, tel, email, pwd, auth_type, vac_days, retire_date)"
            + "values(emp_seq.nextval,?,?,?,?,sysdate,?,?,?,?,?,?,?)";
         
         pstmt = con.prepareStatement(insertEmp);
         
         //물음표 총 12개
         pstmt.setString(1, aed.getName());
         pstmt.setInt(2, aed.getDept_code());
         pstmt.setInt(3, aed.getPos_code());
         pstmt.setInt(4, aed.getSal_code());
         pstmt.setString(5, aed.getAddr());
         pstmt.setString(6, aed.getTel());
         pstmt.setString(7, aed.getEmail());
         pstmt.setString(8, "1111");
         pstmt.setInt(9, 0);
         pstmt.setInt(10, 0);
         pstmt.setDate(11, null);
         
         result = pstmt.executeUpdate();
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return result;
   }
}
