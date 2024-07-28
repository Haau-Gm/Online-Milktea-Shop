package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ctbo;
import bean.adminXemKHthanhtoanbean;

/**
 * Servlet implementation class adminKHthanhtoanController
 */
@WebServlet("/adminKHthanhtoanController")
public class adminKHthanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminKHthanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ctbo adminKHtt= new ctbo();
			ArrayList<adminXemKHthanhtoanbean> ds = adminKHtt.getkhdathanhtoan();
			request.setAttribute("dsdatt", ds);
			RequestDispatcher rd= request.getRequestDispatcher("adminKHthanhtoan.jsp");
			rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
