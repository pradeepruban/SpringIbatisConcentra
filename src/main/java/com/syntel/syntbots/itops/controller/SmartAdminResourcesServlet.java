/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syntel.syntbots.itops.util.Logger;

/**
 * This class handles all the Exceptions of ItOps application that is raised in Spring
 * 
 * @author Syntel
 * @version 1.0
 */

@SuppressWarnings("serial")
public class SmartAdminResourcesServlet extends HttpServlet {

	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		setContentType(path, response);
		InputStream streamIn = null;
		try {
			streamIn = getClass().getResourceAsStream(path);
			PrintWriter writer = response.getWriter();
			int c;
			while ((c = streamIn.read()) != -1) {
				writer.write(c);
			}
		} catch (IOException e) {
			streamIn.close();
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void setContentType(String path, HttpServletResponse response) {
		if (path.toLowerCase().endsWith(".css")) {
			response.setContentType("text/css");
		} else if (path.toLowerCase().endsWith(".js")) {
			response.setContentType("text/javascript");
		} else if (path.toLowerCase().endsWith(".png")) {
			response.setContentType("image/png");
		} else if (path.toLowerCase().endsWith(".ico")) {
			response.setContentType("image/x-icon");
		}
	}
}
