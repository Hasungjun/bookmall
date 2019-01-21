package com.douzon.bookmall.vo;

public class OrderVO {
	
private int no;
private int	order_no;
private String	name;
private String	callnum;
private String	email;
private int	last_price;
private String	post;



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
public String getCallnum() {
	return callnum;
}
public void setCallnum(String callnum) {
	this.callnum = callnum;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getLast_price() {
	return last_price;
}
public void setLast_price(int last_price) {
	this.last_price = last_price;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
@Override
public String toString() {
	return "OrderVO [order_no=" + order_no + ", name=" + name + ", callnum=" + callnum + ", email=" + email
			+ ", last_price=" + last_price + ", post=" + post + "]";
}





}
