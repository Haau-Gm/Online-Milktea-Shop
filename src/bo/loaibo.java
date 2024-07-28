package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao= new loaidao();
	ArrayList<loaibean> ds;
	public ArrayList<loaibean> getloai() throws Exception{
		ds=ldao.getloai();
		return ds;
	}
	
	public int Them(String maloai, String tenloai) throws Exception{
		for(loaibean l: ds)
			if(l.getMaloai().equals(maloai))
				return 0;
		return ldao.Them(maloai, tenloai);
	}
	public int Xoa(String maloai) throws Exception{
		return ldao.Xoa(maloai);
	}
	public int Sua(String maloai, String tenloai) throws Exception{
		return ldao.Sua(maloai, tenloai);
	}
}
