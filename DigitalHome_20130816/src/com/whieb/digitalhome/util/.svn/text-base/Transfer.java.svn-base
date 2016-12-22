package com.whieb.digitalhome.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Transfer {

	public static void responseOut(HttpServletResponse response,
			String jsonString) throws Exception {
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		out = response.getWriter();
		out.write(jsonString);
		// out.flush();
		out.close();
	}

}
