package bo;

import java.util.ArrayList;

import bean.loaibean;
import bean.sanphambean;
import dao.sanphamdao;

public class sanphambo {
	sanphamdao sdao= new sanphamdao();
	ArrayList<sanphambean> ds;
	//lấy dsl về để kiểm tra trùng mã loại
	ArrayList<loaibean> dsl;
	loaibo lbo=new loaibo();
    public sanphambo() {
        try {
            dsl = lbo.getloai();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	//Viết hàm getsanpham: lấy về all san pham
	public ArrayList<sanphambean> getsanpham() throws Exception{
		ds=sdao.getsanpham();
		return ds;
	}
	//Hàm TimMa(String maloai):
	//trả về all sản phẩm của loại có mã : maloai
	public ArrayList<sanphambean> TimMa(String maloai) throws Exception{
		ArrayList<sanphambean> tam = new ArrayList<sanphambean>();
		for(sanphambean s : ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam; 
	}
	//Hàm Tim(String key):
	//trả về all sản phẩm có tên sản phẩm giống như key
	public ArrayList<sanphambean> Tim(String key) throws Exception{
		ArrayList<sanphambean> tam = new ArrayList<sanphambean>();
		for(sanphambean s : ds)
			if(s.getTensp().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
		return tam;
	}
	//Admin cac chuc nang
	public int Them(String masp, String tensp, long gia, boolean luongnguyenlieu, String anh, String maloai) throws Exception {
	    boolean ktra = false;//Kiểm tra hợp lý
	    for(loaibean l : dsl) {
	        if(l.getMaloai().equals(maloai)) {
	            for(sanphambean sp : ds) {
	                if(!sp.getMasp().equals(masp)) {
	                    ktra = true;
	                }
	                else
	                	ktra=false;
	            }
	        }
	    }
	    if(ktra){
	        return sdao.Them(masp, tensp, gia, luongnguyenlieu, anh, maloai);
	    }
	    return 0;
	}
	public int Xoa(String masp) throws Exception{
		return sdao.Xoa(masp);
	}
	public int Sua(String masp, String tensp, long gia, boolean luongnguyenlieu, String anh, String maloai) throws Exception {
	    for (loaibean l : dsl)
	        if (l.getMaloai().equals(maloai))
	        	return sdao.Sua(masp, tensp, gia, luongnguyenlieu, anh, maloai);
	    return 0;
	}
	
}
