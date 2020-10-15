package com.fds.jsp.servlet;


public class Khoa {
	public String maKhoa;
	public String tenKhoa;
	public String namTL;
	public Khoa(String maKhoa, String tenKhoa, String namTL) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.namTL = namTL;
	}
	public Khoa() {
		
	}
	
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getNamTL() {
		return namTL;
	}
	public void setNamTL(String namTL) {
		this.namTL = namTL;
	}
	
	
}

