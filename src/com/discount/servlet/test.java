package com.discount.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.discount.DAO.DealsDAO;
import com.discount.DAO.UsersDAO;
import com.discount.model.Deals;
import com.discount.model.Users;

import org.json.simple.JSONObject;

public class test extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public test() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		// retrieve data from databse
//		printAllUsers(out);
		printAllDeals(out);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	private void printAllDeals(PrintWriter out) throws UnsupportedEncodingException{
		DealsDAO dealsDAO = new DealsDAO();
		List<Deals> allDeals = dealsDAO.selectAll();	
			
		out.println("<h4>Deals:</h4>");
		for (int i=0; i<20; i++){
			out.println("Index "+ (i+1) +": ");
			String str=allDeals.get(i).toString();
		    str=new String(str.getBytes("GB2312"),"8859_1");
			out.println(str);
			// print to console
			System.out.println(str);
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllUsers(PrintWriter out) {

		UsersDAO userDAO = new UsersDAO();
		List<Users> allUsers = userDAO.selectAll();

		out.println("<h4>Users:</h4>");
		for (int i = 0; i < allUsers.size(); i++) {
			out.println("Index " + (i + 1) + ": ");
			out.println(allUsers.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}

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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
