package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//lay ve masp, tensp, gia
			String masp=request.getParameter("masp");
			String tensp=request.getParameter("tensp");
			String giatam=request.getParameter("gia");

			//neu ko phai chay lan dau thi:
			if(masp!=null && tensp!=null && giatam!=null){
				// đổi giá từ chuỗi ra số
				long gia=Long.parseLong(giatam);
				giohangbo gh=null;
				HttpSession session=request.getSession();
				// nếu chưa tạo session("gh") thì tạo ra
				if(session.getAttribute("gh")==null){
					gh=new giohangbo();
					session.setAttribute("gh", gh);
				}
				gh=(giohangbo)session.getAttribute("gh"); // luu session ra bien
				gh.ThemHang(masp, tensp, gia, 1); // goi ham them
				//luu bien vo lai session
				session.setAttribute("gh", gh);
				//dieu huong qua tra de hien thi gio hang
				response.sendRedirect("htgioController");
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
