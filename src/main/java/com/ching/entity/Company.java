package com.ching.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Company {
@NotEmpty(message="不允许为空")
private String id;

@Size(max=10,min=3,message="请输入3---10个字符")
private String name;

private String city;
private String phone;
private String fax;
private String address;
private String remark;
public Company() {
	super();
	// TODO Auto-generated constructor stub
}
public Company(String id, String name, String city, String phone, String fax, String address, String remark) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.phone = phone;
	this.fax = fax;
	this.address = address;
	this.remark = remark;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
}
