package com.douzon.bookmall.main;

import java.util.List;
import com.douzon.bookmall.dao.BookDAO;
import com.douzon.bookmall.dao.CartDAO;
import com.douzon.bookmall.dao.CategoryDAO;
import com.douzon.bookmall.dao.EndOrderDAO;
import com.douzon.bookmall.dao.MemberDAO;
import com.douzon.bookmall.dao.OrderDAO;
import com.douzon.bookmall.vo.BookVO;
import com.douzon.bookmall.vo.CartVO;
import com.douzon.bookmall.vo.CategoryVO;
import com.douzon.bookmall.vo.EndOrderVO;
import com.douzon.bookmall.vo.MemberVO;
import com.douzon.bookmall.vo.OrderVO;

public class BookmallMain {

	public static void main(String[] args) {
		insertTest("소설");
		insertTest("수필");
		insertTest("컴퓨터");
		
		insertTest("개미", 35000, 1);
		insertTest("해바라기", 10000, 2);
		insertTest("이것이 자바다", 30000, 3);
		
		insertTest("하성준","010-5052-1332","abc@naver.com","1234");
		insertTest("하준성","010-1332-5052","bca@naver.com","1234");
		
		insertTest("개미",1,"하성준");
		insertTest("해바라기",2,"하성준");
		
		insertTest("하성준","주소");
		
		insertTest2("하성준");
		
		getListTest();

	}
	
	public static void insertTest2(String name) {
		EndOrderVO vo = new EndOrderVO();
		vo.setName(name);
		new EndOrderDAO().insert(vo);
	}
	
	public static void insertTest(String name, String post) {
		OrderVO vo = new OrderVO();
		vo.setName(name);
		vo.setPost(post);
		new OrderDAO().insert(vo);
	}
	
	
	
	public static void insertTest(String book_title, int count, String name) {
		CartVO vo = new CartVO();
		vo.setTitle(book_title);
		vo.setCount(count);
		vo.setName(name);
		new CartDAO().insert(vo);
	}
	
	
	
	
	public static void insertTest(String name, String call, String email , String pass) {
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setCall(call);
		vo.setEmail(email);
		vo.setPass(pass);
		new MemberDAO().insert(vo);
	}
	
	
	
	
	public static void insertTest(String book_title,int price,int category_no) {
		BookVO vo = new BookVO();
		vo.setBook_title(book_title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		new BookDAO().insert(vo);
	}
	
	public static void insertTest(String category) {
		CategoryVO vo = new CategoryVO();
		vo.setCategory(category);
		new CategoryDAO().insert(vo);
	}
	
	public static void getListTest() {
		
		System.out.println("==========회원==========");
		List<MemberVO> list = new MemberDAO().getList();
		for(MemberVO vo : list) {
			System.out.println(vo);
		}
		
		System.out.println("==========카테고리==========");
		List<CategoryVO> list6 = new CategoryDAO().getList();
		for(CategoryVO vo : list6) {
			System.out.println(vo);
		}
		
		System.out.println("==========상품==========");
		List<BookVO> list5 = new BookDAO().getList();
		for(BookVO vo : list5) {
			System.out.println(vo);
		}
		System.out.println("==========카트==========");
		List<CartVO> list2 = new CartDAO().getList();
		for(CartVO vo : list2) {
			System.out.println(vo);
		}	
		System.out.println("==========주문==========");	
		List<OrderVO> list3 = new OrderDAO().getList();
		for(OrderVO vo : list3) {
			System.out.println(vo);
		}
		System.out.println("==========주문도서==========");
		List<EndOrderVO> list4 = new EndOrderDAO().getList();
		for(EndOrderVO vo : list4) {
			System.out.println(vo);
		}
	}
	

}
