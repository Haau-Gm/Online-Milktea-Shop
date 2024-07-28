package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao= new hoadondao();
	public int Them(long makh, String diachimua) throws Exception{
		return hddao.Them(makh, diachimua);
	}
	public long getMaxHD() throws Exception{
		return hddao.getMaxHD();
	}
}
