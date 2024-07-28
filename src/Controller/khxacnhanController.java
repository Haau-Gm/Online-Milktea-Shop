package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.ctbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class khxacnhanController
 */
@WebServlet("/khxacnhanController")
public class khxacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public khxacnhanController() {
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
				giohangbo gh=(giohangbo)session.getAttribute("gh");
				if(gh!=null) {//Co hang trong gio
					//Tao 1 hoa don
					hoadonbo hdbo= new hoadonbo();
					String diachimua=request.getParameter("txtdiachimua");
					hdbo.Them(kh.getMakh(), diachimua);
					long mahd=hdbo.getMaxHD();
					//Duyet gio de luu vao cthoadon
					ctbo ct=new ctbo();
					for(giohangbean g: gh.ds)
						ct.Them(g.getMasp(), g.getSoluongmua(), mahd);
					//xoa gio hang
					session.removeAttribute("gh");
					//Da them thanh cong, chuyen qua thanhtoanController
					response.sendRedirect("thanhtoanController");
				}
				//Neu gio hang trong 
				if (gh==null) {
					RequestDispatcher rd= request.getRequestDispatcher("htgio.jsp?kt=1");
					rd.forward(request, response);
				}
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
