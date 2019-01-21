package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.douzon.bookmall.vo.MemberVO;

public class MemberDAO {
	
	
	public List<MemberVO> getList(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
//			no
//			name
//			call
//			email
//			pass
			
			String sql = "select no, name, callnum, email from member ";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String call = rs.getString(3);
				String email = rs.getString(4);
				
				
				MemberVO vo = new MemberVO();
				vo.setNo(no);
				vo.setName(name);
				vo.setCall(call);
				vo.setEmail(email);

				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	
	
	
	
	public boolean insert(MemberVO MemberVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean result = false;
		try {
			conn = getConnection();
			
//			no
//			name
//			call
//			email
//			pass
			
			String sql =
				" insert" + 
				"   into member" + 
				" values (null, ?, ? , ?, ?)";	
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberVO.getName());
			pstmt.setString(2, MemberVO.getCall());
			pstmt.setString(3, MemberVO.getEmail());
			pstmt.setString(4, MemberVO.getPass());
			int count = pstmt.executeUpdate();
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
}
