package l83.examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Examlpe1
 */

@WebServlet(name="TestServlet", urlPatterns={"/example23", "/alt"})
public class Example1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//RequestDispatcher disp = 
			//	request.getRequestDispatcher("Example2.jsp");
		//System.out.println(disp);
		
		//Seession:
		HttpSession sess = request.getSession();
		Integer visCounter = (Integer) sess.getAttribute("visitCount");
		if (visCounter == null) {
			visCounter = 0;
		}
		visCounter++;
		sess.setAttribute("visitCount", visCounter);
		
		System.out.println("С айпи " + request.getRemoteAddr()
			+ " чувак зашел " + visCounter + "-й раз.");
		
		request.getRequestDispatcher("Example2.jsp").forward(request, response);
		System.out.println("after forward");
		response.getWriter().append("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
