package Controller;

//Xử lý file
import java.io.File;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.sanphambean;
import bo.sanphambo;

/**
 * Servlet implementation class adminsanphamController
 */
@WebServlet("/adminsanphamController")
public class adminsanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsanphamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//response.setCharacterEncoding("utf-8");  // Trả dữ liệu lên bằng utf-8
		    //request.setCharacterEncoding("utf-8");  // Trả dữ liệu về cũng bằng utf-8
			sanphambo sbo=new sanphambo();
			ArrayList<sanphambean> ds=sbo.getsanpham();
			String anh="", tabadd="", tabupdate="";
			String masp="",tensp="",giatam="",luongnltam="",maloai="";
			String anh2="";
			boolean luongnguyenlieu=true;
			long gia=0;
			String tabxoa=request.getParameter("tab");
			//boolean updateImage = false;
			
			FileItemFactory factory = new DiskFileItemFactory();
		    ServletFileUpload upload = new ServletFileUpload(factory);
			    try {
			        List<FileItem> items = upload.parseRequest(request);
			        for (FileItem item : items) {
			            if (!item.isFormField()) {
			            	if (item.getSize() > 0) { // Kiểm tra nếu có tệp được tải lên
			                // Tạo tên ngẫu nhiên cho tệp ảnh
			                String imageName = UUID.randomUUID().toString() + ".jpg";
			                String imagePath = "C:\\Users\\Quang\\eclipse-workspace\\QuanCaFe\\WebContent\\image_cafe\\" + imageName;
			                
			                anh = "image_cafe/" + imageName; // Đặt đường dẫn ảnh
			                try {
			                	item.write(new File(imagePath));
					            System.out.println("UPLOAD THÀNH CÔNG...!");
					            System.out.println("Đường dẫn lưu file là: "+anh);
					           // updateImage = true; // Đã tải lên tệp mới
			                } catch (Exception e) {
			                	e.printStackTrace();
			                }
			            }
			            }
			            else//Neu la control
						{
							String ten=item.getFieldName();
							if(ten.equals("txtmasp"))
								masp=item.getString();
							if(ten.equals("txttensp"))
								tensp = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
							if(ten.equals("txtgia")) {
								giatam=item.getString();
								gia = Long.parseLong(giatam);
								}
							if(ten.equals("txtluongnguyenlieu")) {
								luongnltam=item.getString();
								if(luongnltam.equals("1"))
									luongnguyenlieu = true;
								else if(luongnltam.equals("0"))
									luongnguyenlieu = false;
							}	
							if(ten.equals("txtanh"))
								anh2=item.getString();
							if(ten.equals("txtmaloai"))
								maloai=item.getString();
							if(ten.equals("butadd"))
								tabadd=item.getString();
							if(ten.equals("butupdate"))
								tabupdate=item.getString();
						}
			        }
			    } catch (FileUploadException e) {
					e.printStackTrace();
				}
			//Lấy địa chỉ hiện tại của ảnh nếu update không thêm ảnh mới
			if(anh=="")
				anh=anh2;
			System.out.print("---"+masp +tensp+ gia +luongnguyenlieu +anh +maloai);
			//System.out.printf("-"+tabadd+"-"+tabupdate+"-"+tabxoa);
			if(tabadd != null && tabadd.equals("Add")) {
				sbo.Them(masp, tensp, gia, luongnguyenlieu, anh, maloai);
			}
			if(tabupdate != null && tabupdate.equals("Update")) {
				//System.out.print("---"+masp +tensp+ gia +luongnguyenlieu +anh +maloai);
                sbo.Sua(masp, tensp, gia, luongnguyenlieu, anh, maloai);
			}
			if(tabxoa==null){
				tabxoa="";
			}else
			if(tabxoa!=null &&tabxoa.equals("xoa")) {
				String maspxoa=request.getParameter("masp");
				sbo.Xoa(maspxoa);
			}
			request.setAttribute("dssp", sbo.getsanpham());
			RequestDispatcher rd= request.getRequestDispatcher("adminsanpham.jsp");
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
