package com.voxwalker.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Normally a servlet can only call one method doGet/doPost.
 * BaseServlet class can call different method according a method parameter
 * @author jason
 *
 */
public abstract class BaseServlet extends HttpServlet {	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. get the parameter : method, 
		 * 2. call the method
		 */
		String methodName = req.getParameter("method");
		
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("Error in BaseServlet : no method parameter was passed!");
		}
		
		/*
		 * get method name, and invoke the method through reflection
		 *  get current class, check it's method

		 */
		Class c = this.getClass();// get class
		Method method = null;
		try {
			method = c.getMethod(methodName, 
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("method called：" + methodName + "(HttpServletRequest,HttpServletResponse)，not exist！");
		}
		
		/*
		 * call method
		 */
		try {
			String result = (String)method.invoke(this, req, resp);
			/*
			 * if the return string is null or empty, do nothing
			 */
			if(result == null || result.trim().isEmpty()) {
				return;
			}
			/* check string:
			 *  "url" 		- forward to url
			 *  "r:/url" 	- redirection to url
			 *  "f:/url" 	- forward to url
			 */
			if(result.contains(":")) {
			
				int index = result.indexOf(":");// get ":"
				String s = result.substring(0, index);// r - redirect, f - forward
				String path = result.substring(index+1);// url
				if(s.equalsIgnoreCase("r")) {
					resp.sendRedirect(req.getContextPath() + path);
				} else if(s.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				} else {
					throw new RuntimeException("the operator：" + s + "，is not supported (r - redirect, f-forward)！");
				}
			} else {// not ":", consider forward
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("the called method：" + methodName + ",throw an exception! ");
			throw new RuntimeException(e);
		}
	}
}
