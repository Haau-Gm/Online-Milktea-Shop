package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getsanpham() throws Exception{
		ArrayList<sanphambean> ds= new ArrayList<sanphambean>();
		//B1: Ket noi vao csdl
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="select* from sanpham";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while(rs.next()) {
			String masp=rs.getString("masp");
			String tensp=rs.getString("tensp");
			long gia=rs.getLong("gia");
			boolean luongnguyenlieu=rs.getBoolean("luongnguyenlieu");
			String anh=rs.getString("anh");
			String maloai=rs.getString("maloai");
			ds.add(new sanphambean(masp, tensp, gia, luongnguyenlieu, anh, maloai));
		}
		//B6: Dong rs va ket noi
				rs.close();
				kn.cn.close();
		return ds;
	}
	//Admin các chức năng
	public int Them(String masp, String tensp, long gia, boolean luongnguyenlieu, String anh, String maloai) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="insert into sanpham(masp, tensp, gia, luongnguyenlieu, anh, maloai) values (?,?,?,?,?,?)";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, masp);
		cmd.setString(2, tensp);
		cmd.setLong(3, gia);
		cmd.setBoolean(4, luongnguyenlieu);
		cmd.setString(5, anh);
		cmd.setString(6, maloai);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int Xoa(String masp) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="delete from sanpham where masp=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, masp);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int Sua(String masp, String tensp, long gia, boolean luongnguyenlieu, String anh, String maloai) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="update sanpham set tensp=?, gia=?, luongnguyenlieu=?, anh=?, maloai=? where masp=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, tensp);
		cmd.setLong(2, gia);
		cmd.setBoolean(3, luongnguyenlieu);
		cmd.setString(4, anh);
		cmd.setString(5, maloai);
		cmd.setString(6, masp);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
