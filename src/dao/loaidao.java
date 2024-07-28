package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		//B1: Ket noi vao csdl
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="select* from loai";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while(rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		//B6: Dong rs va ket noi
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int Them(String maloai, String tenloai) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="insert into loai(maloai, tenloai) values (?,?)";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int Xoa(String maloai) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="delete from loai where maloai=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, maloai);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public int Sua(String maloai, String tenloaimoi) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="update loai set tenloai=? where maloai=?";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, tenloaimoi);
		cmd.setString(2, maloai);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
