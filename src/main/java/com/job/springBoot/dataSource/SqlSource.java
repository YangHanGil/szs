package com.job.springBoot.dataSource;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class SqlSource {

	@Autowired
	DataSource dataSource;
	
	public boolean insertTable(String name, String regNo) {
		
		boolean res = false;
		
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "";
		int updateNum = -1;

		
		try {

			sql = "INSERT INTO PERMISSION"
				+ "("
				+ "		name, "
				+ "		regNo, "
				+ ")"
				+ "VALUES"
				+ "("
				+ 		name
				+ 	","+regNo
				+ ")";
			    
			conn = conn = dataSource.getConnection();
			// 접속 url/계정명 파악
			System.out.println("URL : " + conn.getMetaData().getURL());
			System.out.println("USER : " + conn.getMetaData().getUserName());
			
			ptmt = conn.prepareStatement(sql);
			ptmt.executeUpdate();
			   
			updateNum= 1;
			
			res = true;
			   
		} catch(Exception ex) {
			ex.printStackTrace();
			res = false;
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (ptmt != null) try { ptmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return res;
	}
	
	

}
