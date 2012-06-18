package com.discount.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.discount.model.Deals;
import com.discount.model.Merchants;

public class JsonUtil {
	public static String readRequestContent(HttpServletRequest request)
			throws IOException {
		BufferedReader bf = request.getReader();
		String line = bf.readLine();
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			sb.append(line);
			line = bf.readLine();
		}
		return sb.toString();
	}

	public static String retriveIdsFromJson(String requestContent) {
		// decode the json text from the content of request
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(requestContent);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("asd");
			return null;
		}
		JSONArray array = (JSONArray) obj;
		JSONObject obj2 = (JSONObject) array.get(0);
		String ids = (String) obj2.get("id");
		return ids;
	}

	@SuppressWarnings("unchecked")
	public static String convertDealsToJson(List<Deals> deals,
			List<Merchants> merchantsList, List<String> dealPicURLList) {
		if (deals.size() != merchantsList.size()
				|| deals.size() != dealPicURLList.size()) {
			return null;
		}

		JSONArray j_array = new JSONArray();

		for (int i = 0; i < deals.size(); i++) {
			Deals d = deals.get(i);
			String merchantName = merchantsList.get(i).getMerName();
			String pictureUrl = dealPicURLList.get(i);
			if (d != null) {
				JSONObject obj = new JSONObject();
				obj.put("deal_id", d.getDealId());
				obj.put("merchant_name", merchantName);
				obj.put("pic_url", pictureUrl);
				obj.put("title", d.getTitle());
				obj.put("deal_info", d.getDealInfo());
				obj.put("dicount", d.getDiscount());
				obj.put("value", d.getValue());
				obj.put("price", d.getPrice());
				obj.put("strat_time", d.getStartTime());
				obj.put("end_time", d.getEndTime());
				obj.put("mer_info", merchantsList.get(i).getMerInfo());
				obj.put("location_long", merchantsList.get(i).getLocationLong());
				obj.put("location_lat", merchantsList.get(i).getLocationLat());
				obj.put("mer_address", merchantsList.get(i).getAddress());
				obj.put("mer_tel", merchantsList.get(i).getTel());
				j_array.add(obj);
			}
		}
		StringWriter out = new StringWriter();
		try {
			j_array.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String jsonText = out.toString();

		return jsonText;
	}

	public static String convertDealsListToJson(List<Deals> deals,
			List<String> merchantNameList, List<String> dealPicURLList) {
		if (deals.size() != merchantNameList.size()
				|| deals.size() != dealPicURLList.size()) {
			return null;
		}

		JSONArray j_array = new JSONArray();

		for (int i = 0; i < deals.size(); i++) {
			Deals d = deals.get(i);
			String merchantName = merchantNameList.get(i);
			String pictureUrl = dealPicURLList.get(i);
			if (d != null) {
				JSONObject obj = new JSONObject();
				obj.put("deal_id", d.getDealId());
				obj.put("merchant_name", merchantName);
				obj.put("pic_url", pictureUrl);
				obj.put("title", d.getTitle());
				obj.put("dicount", d.getDiscount());
				obj.put("price", d.getPrice());
				j_array.add(obj);
			}
		}
		StringWriter out = new StringWriter();
		try {
			j_array.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String jsonText = out.toString();

		return jsonText;
	}

	public static String convertEncoding(String str) {
		try {
			return new String(str.getBytes("utf-8"), "8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static int parseInteger(String input) {
		try {
			int i = Integer.parseInt(input);
			return i;
		} catch (Exception e) {
			return -1;
		}
	}

	public static String returnMsg(String status, String reason, String data) {
		JSONArray j_array = new JSONArray();
		JSONObject obj = new JSONObject();
		// [{"status":"", "reason":"", "data":""}]
		obj.put("status", status);
		obj.put("reason", reason);
		obj.put("data", data);
		j_array.add(obj);
		StringWriter out = new StringWriter();
		try {
			j_array.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}
}
