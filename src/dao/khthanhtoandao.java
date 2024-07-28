package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.khthanhtoanbean;

public class khthanhtoandao {
	// Khach hang xem danh sach hoa don chua thanh toan
		public ArrayList<khthanhtoanbean> gethoadonchuathanhtoan(long makh) throws Exception{
			ArrayList<khthanhtoanbean> ds= new ArrayList<khthanhtoanbean>();
			//B1: Ket noi vao csdl
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="select * from View_khhoadon where makh=?";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			cmd.setLong(1, makh);
			ResultSet rs= cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while(rs.next()) {
				String mahoadon=rs.getString("mahoadon");
				String tensp=rs.getString("tensp");
				long gia=rs.getLong("gia");
				long soluongmua=rs.getLong("soluongmua");
				long thanhtien=rs.getLong("thanhtien"); 
				Date ngaymua=rs.getDate("ngaymua");
				ds.add(new khthanhtoanbean(mahoadon, tensp, gia, soluongmua, thanhtien, ngaymua));
			}
			//B6: Dong rs va ket noi
					rs.close();
					kn.cn.close();
			return ds;
		}
		//Khach hang xac nhan da thanh toan 
		public int xacnhanthanhtoan(long mahoadon) throws Exception{
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="update hoadon set thanhtoan=1 where mahoadon=?";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//Truyen 2 tham so vao cau lenh sql
			cmd.setLong(1, mahoadon);
			//Thuc hien cau lenh sql
			int kq=cmd.executeUpdate();
			//B6: Dong rs va ket noi
			cmd.close();
			kn.cn.close();
			return kq;
		}
		//Lich su mua
		public ArrayList<khthanhtoanbean> lichsumua(long makh) throws Exception{
			ArrayList<khthanhtoanbean> ds= new ArrayList<khthanhtoanbean>();
			//B1: Ket noi vao csdl
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="select * from View_lichsumua where makh=?";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			cmd.setLong(1, makh);
			ResultSet rs= cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while(rs.next()) {
				String mahoadon=rs.getString("mahoadon");
				String tensp=rs.getString("tensp");
				long gia=rs.getLong("gia");
				long soluongmua=rs.getLong("soluongmua");
				long thanhtien=rs.getLong("thanhtien"); 
				Date ngaymua=rs.getDate("ngaymua");
				ds.add(new khthanhtoanbean(mahoadon, tensp, gia, soluongmua, thanhtien, ngaymua));
			}
			//B6: Dong rs va ket noi
					rs.close();
					kn.cn.close();
			return ds;
		}
		
}
