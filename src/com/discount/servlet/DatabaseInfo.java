package com.discount.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.discount.model.Categories;
import com.discount.model.FavLocations;
import com.discount.model.Merchants;
import com.discount.model.MerchantsFollowed;
import com.discount.model.Pictures;
import com.discount.model.PreferenceTags;
import com.discount.model.Users;
import com.discount.model.Deals;
import com.discount.DAO.CategoriesDAO;
import com.discount.DAO.FavLocationsDAO;
import com.discount.DAO.MerchantsDAO;
import com.discount.DAO.MerchantsFollowedDAO;
import com.discount.DAO.PicturesDAO;
import com.discount.DAO.PreferenceTagsDAO;
import com.discount.DAO.UsersDAO;
import com.discount.DAO.DealsDAO;


@SuppressWarnings("serial")
public class DatabaseInfo extends HttpServlet {

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
		
		//Contact actual = new Contact(3, "Contact2Updated", "(646) 709-6724", "contact1updated@loianetest.com");
/*	
  		UsersDAO UserDAO = new UsersDAO();	
		Users user = UserDAO.selectById(3);
		System.out.println("[songhan]: user: " + user.toString());
		user.setName("Beijing");
		user.setPassword("woaibeijingtiananmen");
		user.setEmail("beijing@zhongnanhai.gov");
		user.setLocation("45.89,67.98");
		user.setNotifications("2,5,8");
		user.setFollowedMerchants("11,22,33");
		UserDAO.update(user);	
*/		
		
		PrintWriter out;
		response.setContentType("text/html");
		
		try {
			out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Dtabase Info Page</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<h2>Database Information:</h2>");
			
			printAllUsers(out);
			printAllDeals(out);
			printAllMerchants(out);
			printAllPictures(out);
			printAllCategories(out);
			printAllFavLocations(out);
			printAllMerchantsFollowed(out);
			printAllPreferenceTags(out);
			
			out.println("  </BODY>");
			out.println("</HTML>");
			
			out.flush();
			out.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void printAllUsers(PrintWriter out){
		
		UsersDAO userDAO = new UsersDAO();
		List<Users> allUsers = userDAO.selectAll();	
			
		out.println("<h4>Users:</h4>");
		for (int i=0; i<allUsers.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allUsers.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllDeals(PrintWriter out){
		DealsDAO dealsDAO = new DealsDAO();
		List<Deals> allDeals = dealsDAO.selectAll();	
			
		out.println("<h4>Deals:</h4>");
		for (int i=0; i<allDeals.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allDeals.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	

	
	private void printAllMerchants(PrintWriter out){
		MerchantsDAO merchantsDAO = new MerchantsDAO();
		List<Merchants> allMerchants = merchantsDAO.selectAll();	
			
		out.println("<h4>Merchants:</h4>");
		for (int i=0; i<allMerchants.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allMerchants.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllPictures(PrintWriter out){
		PicturesDAO picturesDAO = new PicturesDAO();
		List<Pictures> allPictures = picturesDAO.selectAll();	
			
		out.println("<h4>Pictures:</h4>");
		for (int i=0; i<allPictures.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allPictures.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllCategories(PrintWriter out){
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		List<Categories> allCategories = categoriesDAO.selectAll();	
			
		out.println("<h4>Categories:</h4>");
		for (int i=0; i<allCategories.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allCategories.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllFavLocations(PrintWriter out){
		FavLocationsDAO favLocationsDAO = new FavLocationsDAO();
		List<FavLocations> allFavLocations = favLocationsDAO.selectAll();	
			
		out.println("<h4>FavLocations:</h4>");
		for (int i=0; i<allFavLocations.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allFavLocations.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllMerchantsFollowed(PrintWriter out){
		MerchantsFollowedDAO merchantsFollowedDAO = new MerchantsFollowedDAO();
		List<MerchantsFollowed> allMerchantsFollowed = merchantsFollowedDAO.selectAll();	
			
		out.println("<h4>MerchantsFollowed:</h4>");
		for (int i=0; i<allMerchantsFollowed.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allMerchantsFollowed.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
	
	private void printAllPreferenceTags(PrintWriter out){
		PreferenceTagsDAO preferenceTagsDAO = new PreferenceTagsDAO();
		List<PreferenceTags> allPreferenceTags = preferenceTagsDAO.selectAll();	
			
		out.println("<h4>PreferenceTags:</h4>");
		for (int i=0; i<allPreferenceTags.size(); i++){
			out.println("Index "+ (i+1) +": ");
			out.println(allPreferenceTags.get(i).toString());
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
	}
}
