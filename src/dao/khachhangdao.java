package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachhangbean;
public class khachhangdao {
	public khachhangbean ktdn(String tendn, String pass) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		String sql="select* from khachhang where tendn=? and pass=?";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs= cmd.executeQuery();
		khachhangbean kh=null;
		while(rs.next()) {
			long makh=rs.getLong("makh");
			String hoten=rs.getString("hoten");
			String diachi=rs.getString("diachi");
			String sodt=rs.getString("sodt");
			String email=rs.getString("email");
			kh=new  khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		return kh;
	}
	//Khach hang dang ky tai khoan
	public int Themkh(String hoten, String diachi, String sodt, String email, String tendn, String pass) 
			throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		String sql="insert into khachhang(hoten, diachi, sodt, email, tendn, pass) values (?,?,?,?,?,?)";
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, email);
		cmd.setString(5, tendn);
		cmd.setString(6, pass);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	//tạo hàm trả về 1 khachhangbean để kiểm tra trùng tendn khi khach hang dk
	public khachhangbean get1kh(String tendn) throws Exception{
		//B1: Ket noi vao csdl
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="select* from khachhang where tendn=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		cmd.setString(1, tendn);
		ResultSet rs= cmd.executeQuery();
		khachhangbean kh=null;
		//B5: Duyet rs de luu vao ds
		while(rs.next()) {
			long makh=rs.getLong("makh");
			String hoten=rs.getString("hoten");
			String diachi=rs.getString("diachi");
			String sodt=rs.getString("sodt");
			String email=rs.getString("email");
			String pass=rs.getString("pass");
			kh=new  khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		//B6: Dong rs va ket noi
		rs.close();
		kn.cn.close();
		return kh;
	}
	//Kiểm tra admin đăng nhập
	public int adminktra(String tendn) throws Exception{
		//B1: Ket noi vao csdl
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		int ktra=0;
		//B2: Tao cau lenh sql
		String sql="select * from View_admindangnhap where tendn=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		cmd.setString(1, tendn);
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while(rs.next()) {
			ktra=1;
			break;
		}
		//B6: Dong rs va ket noi
		rs.close();
		kn.cn.close();
		return ktra;
	}
	
}
