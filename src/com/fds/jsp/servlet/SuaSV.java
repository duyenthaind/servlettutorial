package com.fds.jsp.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fds.jdbc.connect.JDBC;

@WebServlet ("/SuaSV")
public class SuaSV extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String tenSV = "";
		String maLop = "";
		String sdt = "";
		String maKhoa = "";
	
	public SuaSV(){
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse responce) throws ServletException, IOException{
		String maSV = request.getParameter("maSV");
		ResultSet rs ;
		try {
			rs = new JDBC().traVeKetQua("'select * from sinhvien where maSV = "+maSV+"'");
			while(rs.next()){
				tenSV=rs.getString(2);
				maLop=rs.getString(3);
				sdt=rs.getString(4);
				maKhoa=rs.getString(5);
			}
			responce.setContentType("text/html");
			ServletContext context = getServletContext();
			context.setAttribute("maSV", maSV);
			context.setAttribute("tenSV", tenSV);
			context.setAttribute("maLop", maLop);
			context.setAttribute("sdt", sdt);
			context.setAttribute("maKhoa", maKhoa);
			
			responce.sendRedirect("SuaSinhVien.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse responce) throws ServletException,IOException{
		responce.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String maSV = request.getParameter("maSV");
		String tenSV1 = request.getParameter("hoTen");
		String maLop1 = request.getParameter("maLop");
		String sdt1 = request.getParameter("sdt");
		String maKhoa1 = request.getParameter("maKhoa");
		responce.setContentType("text/html");
//		ServletContext context = getServletContext();
//		String maSV = (String) context.getAttribute("maSV");
	
		try{
			new JDBC().ExeQuery("update sinhvien set hoTen='"+tenSV1+"',maLop='"+maLop1+"',sdt='"+sdt1+"',maKhoa='"+maKhoa1+"' where maSV='"+maSV+"'");
			responce.sendRedirect("NewFile.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
