package lesson81.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoolServlet extends HttpServlet {
	int counter =0;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		counter++;
		super.service(req, resp);
		/*if (req.getMethod().equals("POST")) {
			doPost(req, resp);
		}
		if (req.getMethod().equals("GET")) {
			doGet(req, resp);
		}*/
		
		
		//System.out.println("запрос принят, сервис");
		//resp.getOutputStream().println("<h1>Hello</h1>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("запрос принят, гет отработал");
		resp.getOutputStream().println("<h1>Hello</h1>");
	}
	
	
	

	
}








