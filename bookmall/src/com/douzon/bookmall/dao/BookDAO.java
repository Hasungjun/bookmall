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


public class BookDAO {
	
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select a.book_no, a.book_title, a.price, b.category from book a ,category b where a.category_no = b.category_no";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int book_no = rs.getInt(1);
				String book_title = rs.getString(2);
				int price = rs.getInt(3);
				String category = rs.getString(4);
				
				
				BookVO vo = new BookVO();
				vo.setBook_no(book_no);
				vo.setBook_title(book_title);
				vo.setPrice(price);
				vo.setCategory(category);

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
	

	public boolean insert(BookVO BookVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		boolean result = false;
		try {
			conn = getConnection();
			
			
			String sql =
				" insert" + 
				"   into book" + 
				" values (null, ?, ? ,?)";	
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, BookVO.getBook_title());
			pstmt.setInt(2, BookVO.getPrice());
			pstmt.setInt(3, BookVO.getCategory_no());
			
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
