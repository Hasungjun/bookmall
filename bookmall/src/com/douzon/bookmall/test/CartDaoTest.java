package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDAO;
import com.douzon.bookmall.vo.CartVO;


public class CartDaoTest {

	public static void main(String[] args) {
//		insertTest("개미",1,"하성준");
//		insertTest("해바라기",2,"하성준");
		getListTest();
	}

	
	
	public static void insertTest(String book_title, int count, String name) {
		CartVO vo = new CartVO();
		vo.setTitle(book_title);
		vo.setCount(count);
		vo.setName(name);
		new CartDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<CartVO> list = new CartDAO().getList();
		for(CartVO vo : list) {
			System.out.println(vo);
		}
	}
}
