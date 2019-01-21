package com.douzon.bookmall.vo;

public class MemberVO {
	
private int	no ;
private String	name;
private String	call;
private String	email;
private String	pass;
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCall() {
	return call;
}
public void setCall(String call) {
	this.call = call;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "MemberVO [no=" + no + ", name=" + name + ", call=" + call + ", email=" + email+ "]";
}



}
