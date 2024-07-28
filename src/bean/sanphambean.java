package bean;

public class sanphambean {
	private String masp;
	private String tensp;
	private long gia;
	private boolean luongnguyenlieu;
	private String anh;
	private String maloai;
	public sanphambean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sanphambean(String masp, String tensp, long gia, boolean luongnguyenlieu, String anh, String maloai) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.luongnguyenlieu = luongnguyenlieu;
		this.anh = anh;
		this.maloai = maloai;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
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
	public boolean isLuongnguyenlieu() {
		return luongnguyenlieu;
	}
	public void setLuongnguyenlieu(boolean luongnguyenlieu) {
		this.luongnguyenlieu = luongnguyenlieu;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	
}
