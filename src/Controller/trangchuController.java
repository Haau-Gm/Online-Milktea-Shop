package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sanphambean;
import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class trangchuController
 */
@WebServlet("/trangchuController")
public class trangchuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangchuController() {
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
		
			sanphambo sbo= new sanphambo();
			ArrayList<sanphambean> ds=sbo.getsanpham();	
			//Lấy dữ liệu lên từ trang trangchu.jsp
			String ml=request.getParameter("ml");
			String key=request.getParameter("txttim");
			//bo làm việc
			if(ml!=null){//Chọn tên loại
				ds=sbo.TimMa(ml);
			}
			else
				if(key!=null){// Tìm kiếm
					ds=sbo.Tim(key);
				}
			loaibo lbo= new loaibo();
			ArrayList<loaibean> dsloai=lbo.getloai();
			//Chuyen ve trangchu.jsp: ds va dsloai
			request.setAttribute("dssp", ds);
			request.setAttribute("dsloai", dsloai);
			
			RequestDispatcher rd= request.getRequestDispatcher("trangchu.jsp");
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
