package com.iqrah.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iqrah_students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="sid")
	private Integer sid;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="sage")
	private Integer sage;
	
	@Column(name="saddr")
	private String saddr;
	
	static {
		System.out.println("Student .class is loading");
	}

	public Student() {
		System.out.println("Zero parameterized constructor is loading");
	}
	
	public Integer getSid() {
		return sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sage=" + sage + ", saddr=" + saddr + "]";
	}
	public void setSid(Integer id) {
		this.sid = id;
	}
	
	

}
