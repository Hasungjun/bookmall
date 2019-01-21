package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDAO;
import com.douzon.bookmall.vo.OrderVO;


public class OrderDaoTest {

	public static void main(String[] args) {
		//insertTest("하성준","주소");
		getListTest();
		
		
	}

	
	
	public static void insertTest(String name, String post) {
		OrderVO vo = new OrderVO();
		vo.setName(name);
		vo.setPost(post);
		new OrderDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<OrderVO> list = new OrderDAO().getList();
		for(OrderVO vo : list) {
			System.out.println(vo);
		}
	}
}
