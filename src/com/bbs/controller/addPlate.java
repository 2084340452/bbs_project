package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bbs.pojo.Plate;
import com.bbs.service.UserService;


@WebServlet("/add_plate")
public class addPlate extends HttpServlet {
	private static final long serialVersionUID = 1L;
UserService userService =new  UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String plateTitle = request.getParameter("plateTitle");
		String plateMessage = request.getParameter("plateMessage");;
		System.out.println(plateTitle);
		System.out.println("ss");
		Plate plate = new Plate(plateTitle, plateMessage, 0);
		userService.addPlate(plate);
		out.write("添加成功");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
