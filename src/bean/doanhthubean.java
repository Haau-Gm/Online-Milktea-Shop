package bean;

import java.util.Date;

public class doanhthubean {
	private Date ngaymua;
	private long tongtien;
	public doanhthubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public doanhthubean(Date ngaymua, long tongtien) {
		super();
		this.ngaymua = ngaymua;
		this.tongtien = tongtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getTongtien() {
		return tongtien;
	}
	public void setTongtien(long tongtien) {
		this.tongtien = tongtien;
	}
	
}
