package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.StudentDao;
import com.servlet.dto.StudentDto;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String email = req.getParameter("semail");
				String password = req.getParameter("spassword");

				StudentDao sd = new StudentDao();
				StudentDto s = sd.getStudentDto(email, password);

				if (s!=null) {

					RequestDispatcher dispatcher = req.getRequestDispatcher("homepage.html");
					dispatcher.forward(req, resp);
				} else {
					PrintWriter out = resp.getWriter();
					out.println("<html><body><h1>Invalid Details</h1></body></html>");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
					dispatcher.include(req, resp);
				}
			}
		
	}
	


