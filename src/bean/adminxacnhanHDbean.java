package bean;

import java.util.Date;

public class adminxacnhanHDbean {
	private long machitiethd;
	private long makh;
	private String hoten;
	private String tensp;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	private String diachimua;
	private Date ngaymua;
	private long mahoadon;
	private boolean damua;
	public adminxacnhanHDbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminxacnhanHDbean(long machitiethd, long makh, String hoten, String tensp, long gia, long soluongmua,
			long thanhtien, String diachimua, Date ngaymua, long mahoadon, boolean damua) {
		super();
		this.machitiethd = machitiethd;
		this.makh = makh;
		this.hoten = hoten;
		this.tensp = tensp;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.diachimua = diachimua;
		this.ngaymua = ngaymua;
		this.mahoadon = mahoadon;
		this.damua = damua;
	}
	public long getMachitiethd() {
		return machitiethd;
	}
	public void setMachitiethd(long machitiethd) {
		this.machitiethd = machitiethd;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
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
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	
	
}
