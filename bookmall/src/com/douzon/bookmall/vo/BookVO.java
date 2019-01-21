package com.douzon.bookmall.vo;

public class BookVO {

private int	book_no;
private String	book_title;
private int	price;
private int	category_no;
private String	category;
public int getBook_no() {
	return book_no;
}
public void setBook_no(int book_no) {
	this.book_no = book_no;
}
public String getBook_title() {
	return book_title;
}
public void setBook_title(String book_title) {
	this.book_title = book_title;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getCategory_no() {
	return category_no;
}
public void setCategory_no(int category_no) {
	this.category_no = category_no;
}


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "BookVO [book_no=" + book_no + ", book_title=" + book_title + ", price=" + price + ", category=" + category + "]";
}







}
