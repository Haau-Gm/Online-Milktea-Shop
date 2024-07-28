package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.khachhangbo;
import bean.khachhangbean;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    response.setCharacterEncoding("utf-8");  // Trả dữ liệu lên bằng utf-8
		    request.setCharacterEncoding("utf-8");  // Trả dữ liệu về cũng bằng utf-8
		    
		    khachhangbo khbo = new khachhangbo();
		    String hoten = request.getParameter("txthoten");
		    String diachi = request.getParameter("txtdiachi");
		    String sodt = request.getParameter("txtsodt");
		    String email = request.getParameter("txtemail");
		    String tendn = request.getParameter("txttendn"); 
		    String pass = request.getParameter("txtpass");
		    String pass2 = request.getParameter("txtpass2");
		 
		    //request.setAttribute("message","");
		    //Kiem tra chay lan dau de tranh loi
		    if(hoten==null&& diachi==null&& sodt==null& email==null&& tendn==null && pass==null&&pass2==null){
				RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?message=");
				rd.forward(request, response);
			}
		    else {
		    if(!pass.equals(pass2)) {
		    	RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?message=Mật khẩu không trùng khớp!");
				rd.forward(request, response);
		    }
		    else {
		    	khachhangbean kh= khbo.get1kh(tendn);
		    	//Đăng ký thành công
		    	if(kh==null){
		    		khbo.Themkh(hoten, diachi, sodt, email, tendn, pass);
		    		//response.sendRedirect("dangnhapController");
		    		RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp?message=Đăng ký tài khoản thành công!");
					rd.forward(request, response);
		    	}else {
		    	//Đăng ký thất bại, chuyển về đăng ký tiếp
		    		RequestDispatcher rd= request.getRequestDispatcher("dangky.jsp?message=Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác!");
		    		rd.forward(request, response);
		    	} 
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
