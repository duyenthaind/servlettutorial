package com.fds.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloCrunchify extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public HelloCrunchify(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws IOException,ServletException{
		ServletOutputStream out = response.getOutputStream();
		
		out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                "http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html> \n" +
              "<head> \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                  "charset=ISO-8859-1\"> \n" +
                "<title> Crunchify.com JSP Servlet Example  </title> \n" +
              "</head> \n" +
              "<body>  \n" +
            	"this is my first servlet" + 
              "</body> \n" +
            "</html>" );
	
	}
	@Override
	   protected void doPost(HttpServletRequest request,
	           HttpServletResponse response) throws ServletException, IOException {
	       this.doGet(request, response);
	   }
}
