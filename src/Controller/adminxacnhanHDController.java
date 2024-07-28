package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.ctbo;

/**
 * Servlet implementation class adminxacnhanHDController
 */
@WebServlet("/adminxacnhanHDController")
public class adminxacnhanHDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminxacnhanHDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Lay ve mahoadon chung cua machitiethd can xac nhan
			String mahoadon=request.getParameter("mahoadon");
			ctbo ctbo=new ctbo();
			if(mahoadon!=null) {
				ctbo.CapNhat(Long.parseLong(mahoadon));
			}
			request.setAttribute("dshoadon", ctbo.gethoadonchuaxacnhan());
			RequestDispatcher rd= request.getRequestDispatcher("adminxacnhanHD.jsp");
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
