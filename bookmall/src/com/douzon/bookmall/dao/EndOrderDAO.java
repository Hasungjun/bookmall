package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.EndOrderVO;




public class EndOrderDAO {
	
	
	
	
	public List<EndOrderVO> getList(){
		List<EndOrderVO> list = new ArrayList<EndOrderVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select end_no, title, count from end_order";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int end_no = rs.getInt(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				
//				end_no
//				title
//				count
//				no
//				order_no
		
				
				EndOrderVO vo = new EndOrderVO();
				vo.setEnd_no(end_no);
				vo.setTitle(title);
				vo.setCount(count);
				
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

	
	
	public boolean insert(EndOrderVO EndOrderVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		boolean result = false;
		int count2 = 0;
		try {
			conn = getConnection();
			
//			end_no
//			title
//			count
//			no
//			order_no
			
			String sql =
				" insert" + 
				"   into end_order" + 
				" values (null, ?, ?, ?, ?)";	
			
			String sql2 = "select order_no from ordered where name = ?";
			String sql3 = "select no from member where name = ?";
			String sql4 = "select title, count from cart where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt4 = conn.prepareStatement(sql4);
			
			pstmt2.setString(1, EndOrderVO.getName());
			rs=pstmt2.executeQuery();
			rs.next();
			int order_no = rs.getInt(1);
			
			pstmt3.setString(1,EndOrderVO.getName());
			rs2=pstmt3.executeQuery();
			rs2.next();
			int no = rs2.getInt(1);
			
			
			pstmt4.setInt(1,no);
			rs3=pstmt4.executeQuery();
			while(rs3.next()) {
			String title = rs3.getString(1);
			int count = rs3.getInt(2);
			

			pstmt.setString(1, title);
			pstmt.setInt(2, count);
			pstmt.setInt(3, no);
			pstmt.setInt(4, order_no);
			
			count2 = pstmt.executeUpdate();
			}
			result = count2 == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(pstmt2 != null) {
					pstmt.close();
				}
				if(pstmt3 != null) {
					pstmt.close();
				}
				if(pstmt4 != null) {
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
