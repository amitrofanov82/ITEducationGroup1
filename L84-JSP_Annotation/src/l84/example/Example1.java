package l84.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example1
 */
@WebServlet({"/Example1"})
public class Example1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<String> activeUsers = new CopyOnWriteArrayList();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		synchronized(this){
			activeUsers.add(request.getRemoteUser());
		}

		System.out.println(activeUsers);
	}


}


















