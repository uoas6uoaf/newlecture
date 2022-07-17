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

@WebServlet("/add2")
public class addServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		

		String[] num_= req.getParameterValues("num");

		int result = 0;
		
		for(int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result+= num;
		}
		

		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("계산된 결관는 : " + result);
		
	}

}
