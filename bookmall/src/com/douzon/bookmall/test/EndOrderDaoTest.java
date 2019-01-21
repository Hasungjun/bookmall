package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.EndOrderDAO;
import com.douzon.bookmall.vo.EndOrderVO;


public class EndOrderDaoTest {

	public static void main(String[] args) {
		
//		insertTest("하성준");
		getListTest();
		
	}
	public static void insertTest(String name) {
		EndOrderVO vo = new EndOrderVO();
		vo.setName(name);
		new EndOrderDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<EndOrderVO> list = new EndOrderDAO().getList();
		for(EndOrderVO vo : list) {
			System.out.println(vo);
		}
	}
}
