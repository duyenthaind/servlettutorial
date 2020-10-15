package com.fds.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fds.jdbc.connect.JDBC;

@WebServlet("/XoaSV")

public class XoaSV extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public XoaSV(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse responce) throws IOException,ServletException{
		String maSV = request.getParameter("maSV");
		
		try {
			new JDBC().ExeQuery("delete from sinhvien where maSV= '"+maSV+"'");
			responce.sendRedirect("NewFile.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
