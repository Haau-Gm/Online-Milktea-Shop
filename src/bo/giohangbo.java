package bo;

import java.text.Collator;
import java.util.Locale;

import java.util.ArrayList;
import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds= new ArrayList<giohangbean>();
	public void ThemHang(String masp, String tensp, long gia, long soluongmua) {
		//kiemtra xem hang da co trong danhsach chua
		//neu co thi tang so luong

		for(giohangbean h:ds)
			if(h.getMasp().equals(masp)){
				h.setSoluongmua(h.getSoluongmua()+soluongmua);
				return;
			}
		giohangbean h=new giohangbean(masp,tensp,gia,soluongmua);
		ds.add(h);//them hang vao gio
	}
	//Xóa hàng ra khỏi ds
	public void Xoa(String masp) {
		Collator collator = Collator.getInstance(Locale.getDefault());
		collator.setStrength(Collator.PRIMARY);
		for(giohangbean h:ds)
			//if(h.getMasach().equals(masach)) {
			if(collator.equals(h.getMasp(), masp)){
				ds.remove(h);
				return;
			}
	}
	//Sửa lại so luong
	public void Sua(String masp, long soluongmoi) {
		int n=ds.size();	//Lấy số sách trong ds
		//Fix lỗi 2 chuỗi mã hóa ra không giống nhau
		Collator collator = Collator.getInstance(Locale.getDefault());
		collator.setStrength(Collator.PRIMARY);
		for(int i=0;i<n;i++){
			giohangbean h=ds.get(i);//Lấy quyển i
			//System.out.print(h.getMasach().equals(masach)); ->không được
			//Fix lỗi 2 chuỗi mã hóa ra không giống nhau
			//System.out.print(collator.equals(h.getMasach(), masach));
			if(collator.equals(h.getMasp(), masp)) {
				h.setSoluongmua(soluongmoi);//Sửa số lượng
				ds.set(i, h);//Lưu lại vào ds
				return;
			}
		}
	}
	public long Tong() {
		long s=0;
		for(giohangbean h: ds)
			s=s+h.getThanhtien();
		return s;
	}
}
