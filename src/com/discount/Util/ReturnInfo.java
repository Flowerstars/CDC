package com.discount.Util;

public class ReturnInfo {
	public class Status {
		public static final String warning = "WARNING";
		public static final String ok = "OK";
		public static final String err = "ERROR";
	}

	public class Reason {
		public static final String jsonFormatErr = "JSON FORMAT INCORRECT";
		public static final String noIdErr = "ID DOESNT EXIST";
		public static final String notNumbericIDErr = "ID IS NOT NUMBERIC";
		public static final String idNotExistInDBErr = "ID IS NOT IN DATABASE";
	}
}
