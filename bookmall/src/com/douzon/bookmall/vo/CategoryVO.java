package com.douzon.bookmall.vo;

public class CategoryVO {

	private int category_no;
	private String category;
	
	
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
		return "categoryVO [category_no=" + category_no + ", category=" + category + "]";
	}
	
}
