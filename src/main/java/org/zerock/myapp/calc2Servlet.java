package org.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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

@WebServlet("/calc2")
public class calc2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
		
		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
		
		ServletContext application = req.getServletContext();
		
		String v_= req.getParameter("v");
		
		String op = req.getParameter("operator");
		
		int result = 0;
		
		int v = 0;
		if (!v_.equals("")){
			v = Integer.parseInt(v_);
		}
		
		if(op.equals("=")) {
			
			int x = (Integer) application.getAttribute("value");
			int y = v;
			
			String operator = (String) application.getAttribute("op");
			
			if(operator.equals("+")) {
				result = x + y;
			}else {
				result = x - y;		
			}//inner-if
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("계산된 결과는 : " + result);
		
		}else {

			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}


		

	}

}
