package com.voxwalker.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebLanguageServlet
 */
@WebServlet("/WebLanguageServlet")
public class WebLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		
				String web_language = request.getParameter("web_language");
				System.out.println(" ========get parameter : " + web_language);
				if(web_language != null && ! web_language.isEmpty()){
					
					if(web_language.equals("fr")){
						
					}
					
					if(web_language.equals("en")){
						
					}
					
					
					//CookieTools.addCookie(response, "web_language", web_language, 60*60*24);
					request.getSession().setAttribute("web_language", web_language);
					
				}else{
					System.out.println(" weblang is empty !!!!!!!!");
					// get weblang
					//weblang = CookieTools.getCookieValue(request, weblang);
				}
				
				//request.getSession().setAttribute("weblang", weblang);
				
				response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
