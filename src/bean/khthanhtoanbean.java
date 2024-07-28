package bean;

import java.util.Date;

public class khthanhtoanbean {
	private String mahoadon;
	private String tensp;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	private Date ngaymua;
	public khthanhtoanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khthanhtoanbean(String mahoadon, String tensp, long gia, long soluongmua, long thanhtien, Date ngaymua) {
		super();
		this.mahoadon = mahoadon;
		this.tensp = tensp;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	
}
