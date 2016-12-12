package com.voxwalker.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * tool class used to simplify cookie operation
 * @author jason
 *
 */
public class CookieTools {
	public static String getCookieValue(HttpServletRequest request, String name ){
		// check if name is empty
		if(name==null || name.isEmpty()){
			return null;
		}
		
		
		// get all cookies
		Cookie[] cookies= request.getCookies();		
		if (cookies == null){
			return null;
		}
		
		// check name
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(name)){
				return cookie.getValue();
			}
		}
		
		return null;
	}
	
	public static void addCookie(HttpServletResponse response , String name, String value, int maxAge){
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);		
	}
	
	
	public static void removeCookie(HttpServletResponse response , String name){
		addCookie(response, name, null, 0);
	}

}
