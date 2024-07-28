package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao= new khachhangdao();
	ArrayList<khachhangbean> ds;
	public khachhangbean ktdn(String tendn, String pass) throws Exception{
		return khdao.ktdn(tendn, pass);
	}
	public int Themkh(String hoten, String diachi, String sodt, String email, String tendn, String pass) 
			throws Exception{
		return khdao.Themkh(hoten, diachi, sodt, email, tendn, pass);
	}
	//Lấy về 1 khachang de kiem tra trung tendn
	public khachhangbean get1kh(String tendn) throws Exception{
		return khdao.get1kh(tendn);
	}
	
	//Kiểm tra admin đăng nhập
	public int adminktra(String tendn) throws Exception{
			return khdao.adminktra(tendn);
		}
}
