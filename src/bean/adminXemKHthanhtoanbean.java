package bean;

import java.util.Date;

public class adminXemKHthanhtoanbean {
	private String makh;
	private String hoten;
	private String sodt;
	private String mahoadon;
	private String diachimua;
	private Date ngaymua;
	private long tongtien;
	public adminXemKHthanhtoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminXemKHthanhtoanbean(String makh, String hoten, String sodt, String mahoadon, String diachimua,
			Date ngaymua, long tongtien) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.sodt = sodt;
		this.mahoadon = mahoadon;
		this.diachimua = diachimua;
		this.ngaymua = ngaymua;
		this.tongtien = tongtien;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getDiachimua() {
		return diachimua;
	}
	public void setDiachimua(String diachimua) {
		this.diachimua = diachimua;
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
