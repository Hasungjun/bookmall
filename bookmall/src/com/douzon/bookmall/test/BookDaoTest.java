package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.BookDAO;
import com.douzon.bookmall.vo.BookVO;


public class BookDaoTest {

	public static void main(String[] args) {
		
//		insertTest("개미", 35000, 1);
//		insertTest("해바라기", 10000, 2);
//		insertTest("이것이 자바다", 30000, 3);
//		
		getListTest();
		
	}

	
	public static void insertTest(String book_title,int price,int category_no) {
		BookVO vo = new BookVO();
		vo.setBook_title(book_title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		new BookDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<BookVO> list = new BookDAO().getList();
		for(BookVO vo : list) {
			System.out.println(vo);
		}
	}
	
	
}
