package com.discount.servlet;

import static com.discount.Util.JsonUtil.convertDealsToJson;
import static com.discount.Util.JsonUtil.convertEncoding;
import static com.discount.Util.JsonUtil.parseInteger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.discount.DAO.DealsDAO;
import com.discount.DAO.MerchantDealMapDAO;
import com.discount.DAO.MerchantsDAO;
import com.discount.DAO.PicturesDAO;
import com.discount.model.Deals;

import static com.discount.Util.JsonUtil.*;

public class GetAllDeals extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetAllDeals() {
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
		
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		DealsDAO dealsDAO = new DealsDAO();
		MerchantsDAO merchantsDAO = new MerchantsDAO();
		PicturesDAO picturesDAO = new PicturesDAO();
		MerchantDealMapDAO merchantDealMapDAO = new MerchantDealMapDAO();

		List<Deals> deals = dealsDAO.selectAll();

		List<String> merchantNameList = new ArrayList<String>();
		List<String> dealPicURLList = new ArrayList<String>();
		for (Deals deal : deals) {
			merchantNameList.add(merchantsDAO
					.getMerchantNameById(merchantDealMapDAO
							.getMerchantIdByDealId(deal.getDealId())));
			dealPicURLList.add(picturesDAO.selectById(deal.getPicId())
					.getPicSmallLink());
		}

		out.println(convertEncoding(convertDealsListToJson(deals, merchantNameList,
				dealPicURLList)));
		
		out.flush();
		out.close();
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
