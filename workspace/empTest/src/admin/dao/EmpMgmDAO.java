package admin.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dto.EmpMgmDTO;
import getconnection.GetConnection;

public class EmpMgmDAO {
   private static EmpMgmDAO eDAO;
   
   private EmpMgmDAO() {}
   
   public static EmpMgmDAO getInstance() {
      if(eDAO == null) {
         eDAO = new EmpMgmDAO();
      }
      
      return eDAO;
   }
   
   public List<EmpMgmDTO> selectAllEmp() throws SQLException, IOException{
      List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectEmp = "select e.emp_id, e.name, d.dname, p.pname "
               + "from employee e, department d, position p "
               + "where e.dept_code = d.dept_code and e.pos_code = p.pos_code and e.retire_date is null "
               + "order by e.emp_id";
         
         pstmt = con.prepareStatement(selectEmp);
         rs = pstmt.executeQuery();
         
         int emp_id = 0;
         String name = "";
         String dname = "";
         String pname = "";
         
         EmpMgmDTO eDTO = null;
         
         while(rs.next()) {
            emp_id = rs.getInt("emp_id");
            name = rs.getString("name");
            dname = rs.getString("dname");
            pname = rs.getString("pname");
            
            eDTO = new EmpMgmDTO(emp_id, name, dname, pname);
            
            list.add(eDTO);
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return list;
   }
   
   public List<EmpMgmDTO> selectDeptEmp(int dept_code) throws SQLException, IOException {
      List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectEmp = "select e.emp_id, e.name, d.dname, p.pname "
               + "from employee e, department d, position p "
               + "where e.dept_code = d.dept_code and e.pos_code = p.pos_code and d.dept_code LIKE ? and e.retire_date is null "
               + "order by e.emp_id";
         
         pstmt = con.prepareStatement(selectEmp);
         pstmt.setInt(1, dept_code);
         rs = pstmt.executeQuery();
         
         int emp_id = 0;
         String name = "";
         String dname = "";
         String pname = "";
         
         EmpMgmDTO eDTO = null;
         
         while(rs.next()) {
            emp_id = rs.getInt("emp_id");
            name = rs.getString("name");
            dname = rs.getString("dname");
            pname = rs.getString("pname");
            
            eDTO = new EmpMgmDTO(emp_id, name, dname, pname);
            
            list.add(eDTO);
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return list;
   }
   
   public List<EmpMgmDTO> selectPosEmp(int pos_code) throws SQLException, IOException {
      List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectEmp = "select e.emp_id, e.name, d.dname, p.pname "
               + "from employee e, department d, position p "
               + "where e.dept_code = d.dept_code and e.pos_code = p.pos_code and p.pos_code = ? and e.retire_date is null "
               + "order by e.emp_id";
         
         pstmt = con.prepareStatement(selectEmp);
         pstmt.setInt(1, pos_code);
         rs = pstmt.executeQuery();
         
         int emp_id = 0;
         String name = "";
         String dname = "";
         String pname = "";
         
         EmpMgmDTO eDTO = null;
         
         while(rs.next()) {
            emp_id = rs.getInt("emp_id");
            name = rs.getString("name");
            dname = rs.getString("dname");
            pname = rs.getString("pname");
            
            eDTO = new EmpMgmDTO(emp_id, name, dname, pname);
            
            list.add(eDTO);
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return list;
   }
   
   public List<EmpMgmDTO> selectNameEmp(String searchName) throws SQLException, IOException {
      List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectEmp = "select e.emp_id, e.name, d.dname, p.pname "
               + "from employee e, department d, position p "
               + "where e.dept_code = d.dept_code and e.pos_code = p.pos_code and e.name LIKE ? and e.retire_date is null "
               + "order by e.emp_id";
         
         pstmt = con.prepareStatement(selectEmp);
         pstmt.setString(1, "%" + searchName + "%");
         rs = pstmt.executeQuery();
         
         int emp_id = 0;
         String name = "";
         String dname = "";
         String pname = "";
         
         EmpMgmDTO eDTO = null;
         
         while(rs.next()) {
            emp_id = rs.getInt("emp_id");
            name = rs.getString("name");
            dname = rs.getString("dname");
            pname = rs.getString("pname");
            
            eDTO = new EmpMgmDTO(emp_id, name, dname, pname);
            
            list.add(eDTO);
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return list;
   }
   
   public List<EmpMgmDTO> selectIdEmp(int searchEmp_id) throws SQLException, IOException {
      List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      GetConnection gc = GetConnection.getInstance();
      
      try {
         con = gc.getConn();
         
         String selectEmp = "select e.emp_id, e.name, d.dname, p.pname "
               + "from employee e, department d, position p "
               + "where e.dept_code = d.dept_code and e.pos_code = p.pos_code and e.emp_id LIKE ? and e.retire_date is null "
               + "order by e.emp_id";
         
         pstmt = con.prepareStatement(selectEmp);
         pstmt.setString(1, "%" + searchEmp_id + "%");
         rs = pstmt.executeQuery();
         
         int emp_id = 0;
         String name = "";
         String dname = "";
         String pname = "";
         
         EmpMgmDTO eDTO = null;
         
         while(rs.next()) {
            emp_id = rs.getInt("emp_id");
            name = rs.getString("name");
            dname = rs.getString("dname");
            pname = rs.getString("pname");
            
            eDTO = new EmpMgmDTO(emp_id, name, dname, pname);
            
            list.add(eDTO);
         }
      } finally {
         gc.dbClose(con, pstmt, rs);
      }
      
      return list;
   }
}

