package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.khthanhtoanbo;

/**
 * Servlet implementation class khthanhtoanController
 */
@WebServlet("/khthanhtoanController")
public class khthanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public khthanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");	//trả dữ liệu lên bằng utf-8
			request.setCharacterEncoding("utf-8");	//trả dữ liệu về cũng bằng utf-8
			//Lay ve mahoadon da xac nhan thanh toan roi
			String mahoadon=request.getParameter("mahoadon");
			khthanhtoanbo ttbo=new khthanhtoanbo();
			if(mahoadon!=null) {
				ttbo.xacnhanthanhtoan(Long.parseLong(mahoadon));
			}
			/*
			  RequestDispatcher rd= request.getRequestDispatcher("thanhtoan.jsp?kt=1");
			  rd.forward(request, response);
			 */
			response.sendRedirect("thanhtoanController?kt=1");
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
