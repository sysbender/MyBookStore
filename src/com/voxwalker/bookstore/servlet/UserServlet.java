package com.voxwalker.bookstore.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxwalker.bookstore.domain.Cart;
import com.voxwalker.bookstore.domain.User;

import com.voxwalker.bookstore.service.UserService;
import com.voxwalker.utils.BaseServlet;
import com.voxwalker.utils.CommonTools;
import com.voxwalker.utils.CookieTools;




/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	// @Override
	// public void service(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// super.service(request, response);
	//
	// }

	public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieTools.removeCookie(response, "remember");
		CookieTools.removeCookie(response, "remember_username");
		CookieTools.removeCookie(response, "remember_password");
		request.getSession().invalidate();
		return "r:/index.jsp";
	}

	public String rememberLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get cookies
		String isRemember = CookieTools.getCookieValue(request, "remember");
		String remember_username = CookieTools.getCookieValue(request, "remember_username");
		String remember_password = CookieTools.getCookieValue(request, "remember_password");
		if( isRemember!=null && remember_username!=null && remember_password !=  null ){
			User form = new User();
			form.setUsername(remember_username);
			form.setPassword(remember_password);	
			try{
				User user = userService.login(form);
				request.getSession().setAttribute("session_user", user);
				// add cart to session
				request.getSession().setAttribute("cart", new Cart());
				return "r:/index.jsp";
			}catch(Exception ue){
				request.setAttribute("msg", ue.getMessage());
				request.setAttribute("form", form);
				return "f:/jsps/user/login.jsp";
			}
				
			
		}else{
			return "r:/jsps/user/login.jsp";
		}
		
		
	}

	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get input
		User form = CommonTools.toBean(request.getParameterMap(), User.class);
		System.out.println("user : form =" + form);
		// validate input

		// check
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("session_user", user);
			// add cart to session
			request.getSession().setAttribute("cart", new Cart());

			// check remember
			String isRemember = request.getParameter("remember");
			if (isRemember != null && isRemember.equals("true")) {
				CookieTools.addCookie(response, "remember", "true", 60 * 60 * 24 * 7);
				// just for demo, not secure
				CookieTools.addCookie(response, "remember_username", user.getUsername(), 60 * 60 * 24 * 7);
				CookieTools.addCookie(response, "remember_password", user.getPassword(), 60 * 60 * 24 * 7);
			}

			return "r:/index.jsp";
		} catch (Exception ue) {
			request.setAttribute("msg", ue.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";

		}

	}

	/**
	 * process user registration request
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. form input to bean
		User form = CommonTools.toBean(request.getParameterMap(), User.class);

		// 2. uid, code
		form.setUser_id(CommonTools.uuid());
		form.setCode(CommonTools.uuid() + CommonTools.uuid());

		// 3. validate input (fail : save error, form, forward to regist.jsp)

		Map<String, String> errors = validateInput(form);
		if (errors != null && errors.size() > 0) {
			System.out.println("=========== input validate : error");
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";

			/**
			 * "/index.jsp" f: - forward r: - redirect "" or null
			 */
		}

		System.out.println("=========== input validate : ok");

		// 4. call service.regist (fail : save error, form, forward to
		// regist.jsp)
		try {
			userService.regist(form);
			System.out.println("=========== userservice.regist: ok");

		} catch (Exception e) {
			System.out.println("=========== userservice.regist : exception ");
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
		}

		// 5. send email
		// config file email_template.properties

		// sendEmail(form);

		// 6. success to msg.jsp
		request.setAttribute("msg", "registered succcessfully: please login!");
		System.out.println("=========== userservice.regist : to msg.jsp");
		return "f:/jsps/msg.jsp";

	}

	public Map<String, String> validateInput(User user) {
		// create a error message map<input_field, error_message>
		Map<String, String> errors = new HashMap<String, String>();
		//

		String username = user.getUsername();
		// empty
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "username must not be empty!");
		} // length
		else if (username.length() < 3 || username.length() > 10) {
			errors.put("username", "username length must not be between 3 and 10!");
		}

		String password = user.getPassword();
		// empty
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "password must not be empty!");
		} // length
		else if (password.length() < 3 || password.length() > 10) {
			errors.put("password", "password length must not be between 3 and 10!");
		}

		String email = user.getEmail();
		// empty
		if (email == null || email.trim().isEmpty()) {
			errors.put("email", "email must not be empty!");
		} // length
		else if (!email.matches("\\w+@\\w+\\.\\w+")) {
			errors.put("email", "email format is not valide!");
		}

		return errors;

	}

	public String active(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("activation successed!");
		return null;
	}

	

}
