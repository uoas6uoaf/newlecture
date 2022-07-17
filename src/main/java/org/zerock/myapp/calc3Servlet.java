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

@WebServlet("/calc3")
public class calc3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
		
		res.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
		
		ServletContext sc = req.getServletContext();
		
		String tempInputVal = req.getParameter("inputVal");
		String op = req.getParameter("operator");
		
		int result = 0;
		
		int inputVal = 0;
		if(!tempInputVal .equals("")) {
			inputVal = Integer.parseInt(tempInputVal);
		}
		
		if(!op.equals("=")) {
			sc.setAttribute("beforeVal", inputVal);
			sc.setAttribute("selectOp", op);
			res.sendRedirect("/calc.html");
		}else {
			int x = (Integer) sc.getAttribute("beforeVal");
			int y = inputVal;
			String selectOp = (String) sc.getAttribute("selectOp");
			
			
			
				if(selectOp.equals("+")) {
					result = x + y;
				}else {
					result = x - y;
				}//inner-if
				
			@Cleanup
			PrintWriter out= res.getWriter();
			
			out.println("result : " + result);

		}//out-if

	}//service

}
