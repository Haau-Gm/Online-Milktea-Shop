package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ketnoidao {
	public Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh hqtcsdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//System.out.print("Da xac dinh duoc hqtcsdl");
		String url="jdbc:sqlserver://LAPTOP-AM95DAOD:1433;databaseName=QuanCaFe;user=sa; password=123";
		cn=DriverManager.getConnection(url);
		//System.out.print("Da ket noi");
	}
}
