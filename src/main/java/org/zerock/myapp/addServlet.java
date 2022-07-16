package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/add")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		

		String x1 = req.getParameter("x");
		String y1 = req.getParameter("y");
		int x = Integer.parseInt(x1);
		int y = Integer.parseInt(y1);
	
		int sum = 0;

		if(x1 != null && y1 != null) {
		
			sum = x + y;
		}
		
		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("계산된 결관는 : " + sum);
		
	}

}
