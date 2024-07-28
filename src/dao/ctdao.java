package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.adminXemKHthanhtoanbean;
import bean.adminxacnhanHDbean;
import bean.doanhthubean;

public class ctdao {
	//Ham them cung hoadonbo de tap don hang moi 
	public int Them(String masp, long soluongmua, long mahoadon) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="insert into chitiethoadon(masp, soluongmua, mahoadon, damua) values (?,?,?,?)";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setString(1, masp);
		cmd.setLong(2, soluongmua);
		cmd.setLong(3, mahoadon);
		cmd.setBoolean(4, false);
		//Thuc hien cau lenh sql
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	// Danh sach hoa don chua xac nhan cho admin
		public ArrayList<adminxacnhanHDbean> gethoadonchuaxacnhan() throws Exception{
			ArrayList<adminxacnhanHDbean> ds= new ArrayList<adminxacnhanHDbean>();
			//B1: Ket noi vao csdl
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="select* from View_adminxacnhan";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs= cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while(rs.next()) {
				long machitiethd=rs.getLong("machitiethd");
				long makh=rs.getLong("makh");
				String hoten=rs.getString("hoten");
				String tensp=rs.getString("tensp");
				long gia=rs.getLong("gia");
				long soluongmua=rs.getLong("soluongmua");
				long thanhtien=rs.getLong("thanhtien");
				String diachimua=rs.getString("diachimua");
				Date ngaymua=rs.getDate("ngaymua");
				long mahoadon=rs.getLong("mahoadon");
				boolean damua=rs.getBoolean("damua"); 
				ds.add(new adminxacnhanHDbean(machitiethd, makh, hoten, tensp, gia, soluongmua,
						thanhtien, diachimua, ngaymua, mahoadon, damua));
			}
			//B6: Dong rs va ket noi
					rs.close();
					kn.cn.close();
			return ds;
		}
		//Xác nhận đơn hàng đã mua, đủ điều kiện để tiến hành giao
		public int CapNhat(long mahoadon) throws Exception{
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			//String sql="update chitiethoadon set damua=1 where machitiethd=?";
			String sql="UPDATE chitiethoadon SET damua=1 from chitiethoadon join hoadon on chitiethoadon.mahoadon = hoadon.mahoadon where hoadon.mahoadon=?";
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
		// Admin xem khach hang da thanh toan
		public ArrayList<adminXemKHthanhtoanbean> getkhdathanhtoan() throws Exception{
			ArrayList<adminXemKHthanhtoanbean> ds= new ArrayList<adminXemKHthanhtoanbean>();
			//B1: Ket noi vao csdl
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="select * from View_khdathanhtoan";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs= cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while(rs.next()) {
				String makh=rs.getString("makh");
				String hoten=rs.getString("hoten");
				String sodt=rs.getString("sodt");
				String mahoadon=rs.getString("mahoadon");
				String diachimua=rs.getString("diachimua");
				Date ngaymua=rs.getDate("ngaymua");
				long tongtien=rs.getLong("tongtien");
				ds.add(new adminXemKHthanhtoanbean(makh, hoten, sodt, mahoadon, diachimua, ngaymua, tongtien));
			}
			//B6: Dong rs va ket noi
			rs.close();
			kn.cn.close();
			return ds;
		}
		
		public ArrayList<doanhthubean> getdoanhthungay() throws Exception{
			ArrayList<doanhthubean> ds= new ArrayList<doanhthubean>();
			//B1: Ket noi vao csdl
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			//B2: Tao cau lenh sql
			String sql="select ngaymua, sum(tongtien) as doanhthu from View_khdathanhtoan group by ngaymua";
			//B3: Tao cau lenh
			PreparedStatement cmd= kn.cn.prepareStatement(sql);
			//B4: Thuc hien cau lenh
			ResultSet rs= cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while(rs.next()) {
				Date ngaymua=rs.getDate("ngaymua");
				long doanhthu=rs.getLong("doanhthu");
				ds.add(new doanhthubean(ngaymua, doanhthu));
			}
			//B6: Dong rs va ket noi
			rs.close();
			kn.cn.close();
			return ds;
		}
}
