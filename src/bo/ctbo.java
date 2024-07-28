package bo;

import java.util.ArrayList;

import bean.adminXemKHthanhtoanbean;
import bean.adminxacnhanHDbean;
import bean.doanhthubean;
import dao.ctdao;


public class ctbo {
	ctdao ct= new ctdao();
	//Ham them cung hoadonbo de tap don hang moi 
	public int Them(String masp, long soluongmua, long mahoadon) throws Exception{
		return ct.Them(masp, soluongmua, mahoadon);
	}
	//Ds don hang chua xac nhan
	public ArrayList<adminxacnhanHDbean> gethoadonchuaxacnhan() throws Exception{
		return ct.gethoadonchuaxacnhan();
	}
	//Xac nhan don hang de tien hanh giao
	public int CapNhat(long mahoadon) throws Exception{
		return ct.CapNhat(mahoadon);
	}
	//Admin xem kh da thanh toan
	public ArrayList<adminXemKHthanhtoanbean> getkhdathanhtoan() throws Exception{
		return ct.getkhdathanhtoan();
	}
	//Doanh thu theo ngay
	public ArrayList<doanhthubean> getdoanhthungay() throws Exception{
		return ct.getdoanhthungay();
	}
}
