package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tendn=request.getParameter("txttendn");
			String pass=request.getParameter("txtpass");
			khachhangbo khbo =new khachhangbo();
			if(tendn==null && pass==null){
				RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
			}
		/*	else{
				khachhangbean kh= khbo.ktdn(tendn,pass);
				if(kh!=null){
					HttpSession session=request.getSession();
					session.setAttribute("dn", kh);
					//Dieu huong ve trangchuController->trangchu.jsp
					response.sendRedirect("trangchuController");
				}else {
					//Sai thì ở lại trang đăng nhập 
					RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp?kt=1");
					rd.forward(request, response);
				}
			}*/
			
			else{
				khachhangbean kh= khbo.ktdn(tendn,pass);
				//System.out.print("--------"+khbo.adminktra(tendn));
				if(kh!=null){
					HttpSession session=request.getSession();
					session.setAttribute("dn", kh);
					if(khbo.adminktra(tendn)==0) {
					//Dieu huong ve trangchuController->trangchu.jsp
					response.sendRedirect("trangchuController");
					}
					else if(khbo.adminktra(tendn)==1){
						//Dieu huong ve trang admin
						response.sendRedirect("adminxacnhanHDController");
					}
				}else {
					//Sai thì ở lại trang đăng nhập 
					RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp?kt=1");
					rd.forward(request, response);
				}
			}
		}catch(Exception e){
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
