package com.douzon.bookmall.vo;

public class CartVO {
	
private int	cart_no ;  //카트번호
private String	title; //책제목
private int	count;    //수량
private int	price;    //가격
private int	no;		  //고객번호
private String	name;
private int	order_no; //주문번호

public int getCart_no() {
	return cart_no;
}
public void setCart_no(int cart_no) {
	this.cart_no = cart_no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}



public int getOrder_no() {
	return order_no;
}
public void setOrder_no(int order_no) {
	this.order_no = order_no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "CartVO [cart_no=" + cart_no + ", title=" + title + ", count=" + count + ", price=" + price + ", no=" + no
			+ ", order_no=" + order_no + "]";
}




}
