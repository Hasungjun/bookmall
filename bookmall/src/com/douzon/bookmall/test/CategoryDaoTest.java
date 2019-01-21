package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.vo.CategoryVO;
import com.douzon.bookmall.dao.CategoryDAO;


public class CategoryDaoTest {

	public static void main(String[] args) {
//			insertTest("소설");
//			insertTest("수필");
//			insertTest("컴퓨터");
			getListTest();
	
	}
	
	public static void insertTest(String category) {
		CategoryVO vo = new CategoryVO();
		vo.setCategory(category);
		new CategoryDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<CategoryVO> list = new CategoryDAO().getList();
		for(CategoryVO vo : list) {
			System.out.println(vo);
		}
	}

}
