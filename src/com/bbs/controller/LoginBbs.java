package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/LoginBbs")
public class LoginBbs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("sss");
		String userId = request.getParameter("login");
		String userPsw = request.getParameter("password");
		userPsw = DigestUtils.md5Hex(userPsw);
	
		if (StringUtils.isNullOrEmpty(userId) || StringUtils.isNullOrEmpty(userPsw)) {
			request.setAttribute("error", "不允许账户、密码为空");
			request.getRequestDispatcher("/coast_login").forward(request, response);
			return;
		}
	
		User user = userService.findByIdAndPsw(userId, userPsw);
		if (user !=null) {
		if (user.getUserLevel()== 4) {

			
			request.setAttribute("error", "欢迎你管理员");
			request.getRequestDispatcher("/manager.jsp").forward(request, response);
			return;

		} else {
			request.setAttribute("error", "登录成功");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
			}
		
	
	}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
