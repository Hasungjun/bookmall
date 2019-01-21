package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderVO;


public class OrderDAO {

	
	public List<OrderVO> getList(){
		List<OrderVO> list = new ArrayList<OrderVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select order_no, name, callnum, email ,last_price ,post from ordered";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int order_no = rs.getInt(1);
				String name = rs.getString(2);
				String callnum = rs.getString(3);
				String email = rs.getString(4);
				int last_price = rs.getInt(5);
				String post = rs.getString(6);
				
//				order_no
				
//				name
//				callnum
//				email
//				last_price
//				post
		
				
				OrderVO vo = new OrderVO();
				vo.setOrder_no(order_no);
				vo.setName(name);
				vo.setCallnum(callnum);
				vo.setEmail(email);
				vo.setLast_price(last_price);
				vo.setPost(post);
				
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
	
	
	
	public boolean insert(OrderVO OrderVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql =
				" insert" + 
				"   into ordered" + 
				" values (null, ?, ?, ?, null, ?)";
			String sql2 = "select no, callnum, email from member where name = ?";
			String sql3 = "UPDATE cart SET order_no=?  WHERE no=?";
			String sql4 = "select sum((price*count)) from cart where order_no = ?";
			String sql5 = "select order_no from ordered where name = ? ";
			String sql6 = "UPDATE ordered SET last_price=?  WHERE order_no=?";
			
//			order_no
			
//			name
//			callnum
//			email
//			last_price
//			post
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt4 = conn.prepareStatement(sql4);
			pstmt5 = conn.prepareStatement(sql5);
			pstmt6 = conn.prepareStatement(sql6);
			
			pstmt2.setString(1,OrderVO.getName());			
					
			rs = pstmt2.executeQuery();
			rs.next();
			int no = rs.getInt(1);
			String callnum = rs.getString(2);
			String email = rs.getString(3);		
			
			pstmt.setString(1, OrderVO.getName());
			pstmt.setString(2, callnum);
			pstmt.setString(3, email);
			pstmt.setString(4, OrderVO.getPost());
			
			int count = pstmt.executeUpdate();
			
			pstmt5.setString(1,OrderVO.getName());
			rs2 = pstmt5.executeQuery();
			rs2.next();
			int order_no = rs2.getInt(1);
			
			
			pstmt3.setInt(1, order_no);
			pstmt3.setInt(2, no);
			pstmt3.executeUpdate();
			
			
			pstmt4.setInt(1, order_no);
			rs3 = pstmt4.executeQuery();
			rs3.next();
			int last_price = rs3.getInt(1);
			
			pstmt6.setInt(1,last_price);
			pstmt6.setInt(2,order_no);
			pstmt6.executeUpdate();
			

			
			
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(pstmt2 != null) {
					pstmt2.close();
				}
				if(pstmt3 != null) {
					pstmt3.close();
				}
				if(pstmt4 != null) {
					pstmt4.close();
				}
				if(pstmt5 != null) {
					pstmt5.close();
				}
				if(pstmt6 != null) {
					pstmt6.close();
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
