package com.discount.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.discount.model.Users;
import com.discount.DAO.UsersDAO;

public class TestServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		
		out.flush();
		out.close();
		*/
		UsersDAO UserDAO = new UsersDAO();
		//Contact actual = new Contact(3, "Contact2Updated", "(646) 709-6724", "contact1updated@loianetest.com");
		
		Users user = UserDAO.selectById(3);
		System.out.println("[songhan]: user: " + user.toString());
		user.setName("Beijing");
		user.setPassword("woaibeijingtiananmen");
		user.setEmail("beijing@zhongnanhai.gov");
		user.setLocation("45.89,67.98");
		user.setNotifications("2,5,8");
		user.setFollowedMerchants("11,22,33");
		UserDAO.update(user);	
	}

}
