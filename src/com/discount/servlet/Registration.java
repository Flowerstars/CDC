package com.discount.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.discount.DAO.UsersDAO;
import com.discount.model.Users;

public class Registration extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * name: username, email, password
		 * return: [{"status":"", "reason":"[OK]", "data":""}]
		 * status: 1:0 // success:failed  customized status codes 
		 * reasons: username exist; ...
		 * 
		 */
	  String userName = request.getParameter("userName");
	  String passWord = request.getParameter("passWord");
	  String email = request.getParameter("email");
	  Users u = new Users(userName,passWord,email);
	  UsersDAO userDAO = new UsersDAO();
	  userDAO.insert(u);   //TODO, get UID
	  
	    
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
