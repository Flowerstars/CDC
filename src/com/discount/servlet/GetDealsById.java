package com.discount.servlet;

import static com.discount.Util.JsonUtil.convertDealsToJson;
import static com.discount.Util.JsonUtil.convertEncoding;
import static com.discount.Util.JsonUtil.parseInteger;
import static com.discount.Util.JsonUtil.readRequestContent;
import static com.discount.Util.JsonUtil.retriveIdsFromJson;
import static com.discount.Util.JsonUtil.returnMsg;

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
import com.discount.Util.ReturnInfo;
import com.discount.model.Deals;
import com.discount.model.Merchants;

@SuppressWarnings("serial")
public class GetDealsById extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetDealsById() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		String requestContent = readRequestContent(request);
		String ids = retriveIdsFromJson(requestContent);
		
		if (null == ids) {
			out.println(returnMsg(ReturnInfo.Status.err,
					ReturnInfo.Reason.jsonFormatErr, ""));
			out.flush();
			out.close();
			return;
		}
		else if (ids.equals("")) {
			out.println(returnMsg(ReturnInfo.Status.err,
					ReturnInfo.Reason.noIdErr, ""));
			out.flush();
			out.close();
			return;
		}
		
		String[] id_array = ids.split(","); 
		DealsDAO dealsDAO = new DealsDAO();
		MerchantsDAO merchantsDAO = new MerchantsDAO();
		PicturesDAO picturesDAO = new PicturesDAO();
		MerchantDealMapDAO merchantDealMapDAO = new MerchantDealMapDAO();
		
		List<Deals> deals = new ArrayList<Deals>();
		List<Merchants> merchantsList = new ArrayList<Merchants>();
		List<String> dealPicURLList = new ArrayList<String>();
		for (String s : id_array) {
			int id = parseInteger(s);
			if (id == -1) {
				out.println(returnMsg(ReturnInfo.Status.err,
						ReturnInfo.Reason.notNumbericIDErr, ""));
				out.flush();
				out.close();
				return;
			} else {
				Deals deal = dealsDAO.selectById(id);
				if (null == deal) {
					out.println(returnMsg(ReturnInfo.Status.err,
							ReturnInfo.Reason.idNotExistInDBErr, String.valueOf(id)));
					out.flush();
					out.close();
					return;
				}
				merchantsList.add(merchantsDAO.selectById(merchantDealMapDAO.getMerchantIdByDealId(deal.getDealId())));
				dealPicURLList.add(picturesDAO.selectById(deal.getPicId()).getPicLink());
				deals.add(deal);
			}
		}

		out.println(convertEncoding(convertDealsToJson(deals, merchantsList,
				dealPicURLList)));

		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
