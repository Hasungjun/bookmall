package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.BookVO;
import com.douzon.bookmall.vo.CartVO;



public class CartDAO {
	
	
	public List<CartVO> getList(){
		List<CartVO> list = new ArrayList<CartVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select cart_no, title, count, price ,no ,order_no from cart";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cart_no = rs.getInt(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				int price = rs.getInt(4);
				int no = rs.getInt(5);
				int order_no = rs.getInt(6);
				
//				cart_no
//				title
//				count
//				price
//				no
//				select_no	
		
				
				CartVO vo = new CartVO();
				vo.setCart_no(cart_no);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(price);
				vo.setNo(no);
				vo.setOrder_no(order_no);
				
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
	
	public boolean insert(CartVO cartVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql =
				" insert" + 
				"   into cart" + 
				" values (null, ?, ?, ?, ?, null)";
			
			String sql2 = "select price from book where book_title = ?";
			String sql3 = "select no from member where name = ?";
			
			//("개미",1,"하성준");
//			cart_no
//			title
//			count
//			price
//			no
//			select_no
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			
			pstmt2.setString(1,cartVO.getTitle());
			pstmt3.setString(1, cartVO.getName());
			
			rs = pstmt2.executeQuery();
			rs.next();
			int price = rs.getInt(1);
			rs2 = pstmt3.executeQuery();
			rs2.next();
			int no = rs2.getInt(1);
			
			pstmt.setString(1, cartVO.getTitle());
			pstmt.setInt(2, cartVO.getCount());
			pstmt.setInt(3, price);
			pstmt.setInt(4, no);
		
			
			
			int count = pstmt.executeUpdate();
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
