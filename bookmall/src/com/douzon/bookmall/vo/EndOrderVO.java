package com.douzon.bookmall.vo;

public class EndOrderVO {
	
private int	end_no;
private String	title;
private int	count;
private int	no;
private int	order_no;
private String name;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getEnd_no() {
	return end_no;
}
public void setEnd_no(int end_no) {
	this.end_no = end_no;
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
@Override
public String toString() {
	return "EndOrderVO [end_no=" + end_no + ", title=" + title + ", count=" + count + "]";
}



}
