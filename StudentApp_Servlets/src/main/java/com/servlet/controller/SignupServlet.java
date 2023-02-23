package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.StudentDao;
import com.servlet.dto.StudentDto;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("sname");
		long mobile=Long.parseLong(req.getParameter("smobile"));
		String address=req.getParameter("saddress");
		String email=req.getParameter("semail");
		String password=req.getParameter("spassword");
		
		
		StudentDto s=new StudentDto();
		s.setName(name);
		s.setMobile(mobile);
		s.setAddress(address);
		s.setEmail(email);
		s.setPassword(password);
		
		StudentDao.saveStudent(s);
		
		String html="<html><body><h1>Registerd successfully</h1></body></html>";
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.forward(req, resp);
		
	}

}
