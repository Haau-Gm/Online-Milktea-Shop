package bo;

import java.util.ArrayList;

import bean.khthanhtoanbean;
import dao.khthanhtoandao;

public class khthanhtoanbo {
	//Khach hang thanh toan
	khthanhtoandao khthanhtoan=new khthanhtoandao();
	public ArrayList<khthanhtoanbean> gethoadonchuathanhtoan(long makh) throws Exception{
		return khthanhtoan.gethoadonchuathanhtoan(makh);
	}
	public int xacnhanthanhtoan(long mahoadon) throws Exception{
		return khthanhtoan.xacnhanthanhtoan(mahoadon);
	}
	//Lich su mua
	public ArrayList<khthanhtoanbean> lichsumua(long makh) throws Exception{
		return khthanhtoan.lichsumua(makh);
	}
	
}
