package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bean.khthanhtoanbean;
import bo.khthanhtoanbo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
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
			//Kiem tra xem khach hang da dang nhap chua
			HttpSession session=request.getSession();
			khachhangbean kh=(khachhangbean)session.getAttribute("dn");
			if(kh==null) {//Khach hang chua dang nhap
				RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
			}
			else {
				khthanhtoanbo khttbo= new khthanhtoanbo();
				ArrayList<khthanhtoanbean> ds = khttbo.lichsumua(kh.getMakh());
				request.setAttribute("lichsu", ds);
				RequestDispatcher rd= request.getRequestDispatcher("lichsumua.jsp");
				rd.forward(request, response);
				}
		} catch (Exception e) {
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
