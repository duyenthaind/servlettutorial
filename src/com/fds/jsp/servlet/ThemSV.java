package com.fds.jsp.servlet;

import com.fds.jdbc.connect.*;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThemSV")
public class ThemSV extends HttpServlet {
	public static final long serialVersionUID = 1L;
	private static final JDBC CONNECTION = new JDBC();

	public ThemSV() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String maSV = request.getParameter("maSV");
		String tenSV = request.getParameter("hoTen");
		String maLop = request.getParameter("maLop");
		String sdt = request.getParameter("sdt");
		String maKhoa = request.getParameter("maKhoa");

		try {
			// new
			// JDBC().ExeQuery("insert into sinhvien values('"+maSV+"','"+tenSV+"','"+maLop+"','"+sdt+"','"+maKhoa+"');");
			if (addStudent(maSV, tenSV, maLop, sdt, maKhoa)) {
				response.sendRedirect("NewFile.jsp");
			} else {
				response.sendError(1, "Error");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static boolean addStudent(String id, String name, String className,
			String phone, String khoa) {
		boolean success = false;
		try {
			String query = "insert into sinhvien values";
			CONNECTION.ExeQuery(query + "('" + id + "','" + name + "','"
					+ className + "','" + phone + "','" + khoa + "');");
			success = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return success;
	}
}
