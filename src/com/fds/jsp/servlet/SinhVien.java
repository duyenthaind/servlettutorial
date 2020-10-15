package com.fds.jsp.servlet;

import java.io.Serializable;

public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String maSV;
	public String hoTen;
	public String maLop;
	public String sdt;
	public String maKhoa;

	public SinhVien() {
	}

	public SinhVien(String maSV, String hoTen, String maLop, String sdt, String maKhoa) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.maLop = maLop;
		this.sdt = sdt;
		this.maKhoa = maKhoa;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public void showInfor() {
		System.out.println("maSV  : " + maSV);
		System.out.println("tenSV : " + hoTen);
		System.out.println("maLop : " + maLop);
		System.out.println("Sdt   :" + sdt);
		System.out.println("maKhoa:" + maKhoa);
	}
	
	@Override
	public String toString(){
		return maSV + "-" + "-" + hoTen + "-" + maLop + "-" + sdt + "-" + "maKhoa";
		
	}
}

