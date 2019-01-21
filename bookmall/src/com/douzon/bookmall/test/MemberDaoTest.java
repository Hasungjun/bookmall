package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.MemberDAO;
import com.douzon.bookmall.vo.MemberVO;



public class MemberDaoTest {

	public static void main(String[] args) {
		
//		insertTest("하성준","010-5052-1332","abc@naver.com","1234");
//		insertTest("하준성","010-1332-5052","bca@naver.com","1234");
    	getListTest();
		
	}
	
	public static void insertTest(String name, String call, String email , String pass) {
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setCall(call);
		vo.setEmail(email);
		vo.setPass(pass);
		new MemberDAO().insert(vo);
	}
	
	public static void getListTest() {
		List<MemberVO> list = new MemberDAO().getList();
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
	}

}
