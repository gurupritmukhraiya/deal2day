package com.d2d.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.d2d.model.test.MerchantTest;

public class SetupServlet extends HttpServlet {
		
	private static final long serialVersionUID = -1580434187344983503L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentEnv = request.getParameter("currEnv");
		new MerchantTest(currentEnv).createMerchant();
	}
}
