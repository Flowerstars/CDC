package com.discount.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.discount.DAO.DealsDAO;
import com.discount.model.Deals;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
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
		/*
		 * name: username, password
		 * return: [{"status":"", "reason":"", "data":""}]
		 * 
		 * request: username, password
		 * response: status (create a session, insert uId into session)
		 */
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("[request.getReader().readLine()]: "); //+ request.getReader().readLine());
		
		// read request body content
		BufferedReader bf = request.getReader();
		String line = bf.readLine();
		StringBuilder sb = new StringBuilder();
		while(line != null) {
			sb.append(line);
			line = bf.readLine();
		}
		String json = sb.toString();
		out.println(json);
		
		// decode the json text from the content of request
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(json);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray array = (JSONArray) obj;
		out.println("======the 1 element of array======");
		out.println(array.get(0));
		out.println();

		JSONObject obj2 = (JSONObject) array.get(0);
		out.println("======field \"b\"==========");
		out.println(obj2.get("id"));
		
		out.println("======field \"id\"==========");
		String ids = (String)obj2.get("id");
		String[] id_array = ids.split(",");
		for(String s : id_array) {
			out.println(s);
		}
		
		DealsDAO dealsDAO = new DealsDAO();
		List<Deals> deals = new ArrayList<Deals>();
		for (String s : id_array) {
			int id = parseInteger(s);
			Deals deal = null;
			if (id == -1) {
				//TODO response err
			}
			else {
				deal = dealsDAO.selectById(id);	
			}
			deals.add(deal);
		}
		out.println("<h4>Deals:</h4>");
		for (int i=0; i<deals.size(); i++){
			out.println("Index "+ (i+1) +": ");
			String str = deals.get(i).toString();
			str=new String(str.getBytes("utf-8"),"8859_1");
			out.println(str);
			out.println("<br />");
		}
		out.println("=============================================");
		out.println("<br />");
		
		out.println(convertEncoding(convertDealsToJson(deals)));
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	private static String convertDealsToJson(List<Deals> deals) {
		JSONArray j_array = new JSONArray();
		
		for (Deals d: deals) {
			JSONObject obj = new JSONObject();
			obj.put("deal_id", d.getDealId());
			obj.put("merchant_name", d.getMerId());
			obj.put("pic_url", d.getPicId());
			obj.put("title", d.getTitle());
			obj.put("deal_info", d.getDealInfo());
			obj.put("dicount", d.getDiscount());
			obj.put("value", "12");
			obj.put("price", "8");
			obj.put("strat_time", "2012-04-23 12:00:00");
			obj.put("end_time", " 2012-04-29 12:00:00");
			j_array.add(obj);
		}
		StringWriter out = new StringWriter();
		try {
			j_array.writeJSONString(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonText = out.toString();

		return jsonText;
	}
	
	public static String convertEncoding(String str) {
		try {
			return new String(str.getBytes("utf-8"),"8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static int parseInteger( String input )  
	{  
	   try  
	   {  
	      int i = Integer.parseInt( input );  
	      return i;  
	   }  
	   catch(Exception e)  
	   {  
	      return -1;  
	   }  
	}
}
