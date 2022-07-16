package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;


@WebServlet("/notice_reg")
public class filterEx extends HttpServlet{
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");				//코딩 작성 방식	
		resp.setContentType("text/html; charset=UTF-8");//전달 방식
//		req.setCharacterEncoding("utf8");
		
		@Cleanup
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		
		out.println(title);
		out.println(content);
		
	}
}
