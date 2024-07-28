package dao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class hoadondao {
	public int Them(long makh, String diachimua) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="insert into hoadon(makh, ngaymua, diachimua, thanhtoan) values (?,?,?,?)";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//Truyen 2 tham so vao cau lenh sql
		cmd.setLong(1, makh);
		//Lay ngay gio hien tai
		Date n1= new Date();
		SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
		//Doi ngay ulti sang chuoi theo dinh dang
		String tam=dd.format(n1);//"2023/07/27"
		Date n2=dd.parse(tam);//Doi ngay ra ngay ulti
		//Doi ngay Ulti sang ngay sql va dua vao tham so
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		cmd.setString(3, diachimua);
		cmd.setBoolean(4, false);
		int kq=cmd.executeUpdate();
		//B6: Dong rs va ket noi
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long getMaxHD() throws Exception{
		//B1: Ket noi vao csdl
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		//B2: Tao cau lenh sql
		String sql="select max(mahoadon) as MaxHoaDon from hoadon";
		//B3: Tao cau lenh
		PreparedStatement cmd= kn.cn.prepareStatement(sql);
		//B4: Thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		long max=0;
		if(rs.next()) {
			max=rs.getLong(1);//Lay ve gia tri cot dau tien trong rs
		}
		rs.close(); kn.cn.close();
		return max;
	}
}
