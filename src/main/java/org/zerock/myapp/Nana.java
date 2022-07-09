package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hinana")
public class Nana extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");				//코딩 작성 방식	
		resp.setContentType("text/html; charset=utf-8");//전달 방식
		
		PrintWriter out = resp.getWriter();
		
		String cnt_ = req.getParameter("cnt");

		int cnt = 100;
		
		if(cnt_ !=null && !cnt_.equals("")) {
			cnt = Integer.parseInt(cnt_);
		}
		
		for(int i=0;i<cnt;i++) {
			out.println((i+1)+":안녕 servlet!!<br>");
		}
	}
}
