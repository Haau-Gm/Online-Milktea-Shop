<%@page import="java.util.ArrayList"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.adminxacnhanHDbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin_Coffee Here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Định dạng bảng */
  .table {
    width: 90%;
    border-collapse: collapse;
    margin-top: 30px;
    margin: 0 auto; /* Canh giữa bảng */
    
  }
  .table th, .table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
  }

  /* Định dạng tiêu đề hiển thị */
  .cart-title {
    color: teal;
    font-size: 24px;
    margin-bottom: 10px;
  }
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
  
    <ul class="nav navbar-nav">
    	<li class="active"><a href="adminxacnhanHDController">Quản lý hóa đơn</a></li>
    	<li><a href="adminKHthanhtoanController">Khách hàng đã thanh toán</a></li>
    	<li><a href="admindoanhthuController">Doanh thu</a></li>
     	<li><a href="adminloaiController">Quản lý loại</a></li>
        <li><a href="adminsanphamController">Quản lý sản phẩm</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
     <li><a href="dangkyController"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
		
		<% khachhangbean kh=(khachhangbean)session.getAttribute("dn");
		if(kh!=null){%>
			<li><a href="">Xin chào: <%=kh.getHoten()%><span class="glyphicon glyphicon-log-in"></span></a>
		<%}else{%>
			<li><a href="dangnhapController">Đăng nhập<span class="glyphicon glyphicon-log-in"></span></a></li>
		<%} %>
	
      <li><a href="dangxuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
    </ul>
  	</div>
	</nav>

<table class="table">
    <tr>
        <td colspan="8">
			<div style="width: 300px; margin-left: auto; margin-right: auto;color:red">
                <h3>Danh sách chưa xác nhận:</h3>
            </div>        
        </td>
    </tr>
    <%
        ArrayList<adminxacnhanHDbean> ds = (ArrayList<adminxacnhanHDbean>) request.getAttribute("dshoadon");
        long currentMahoadon = -1;
        long totalAmount = 0;
        for (adminxacnhanHDbean xn : ds) {
            Long mahoadon = Long.valueOf(xn.getMahoadon());
            if (currentMahoadon != mahoadon) {
                if (currentMahoadon != -1) {
    %>
                    <tr style="font-weight: bold; color: red;">
                        <td colspan="6" style="text-align: right;"><strong>Tổng tiền: <%= totalAmount %> VND</strong></td>
                        <td colspan="2">
                        	<a href="adminxacnhanHDController?mahoadon=<%=currentMahoadon%>">Xác nhận đơn hàng</a>
                        </td>
                    </tr>
    <%
                    totalAmount = 0;
                }
    %>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Họ tên</th>
                    <th>Tên sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Số lượng mua</th>
                    <th>Thành tiền</th>
                    <th>Địa chỉ giao</th>
                    <th>Ngày mua</th>
                </tr>
    <%
                currentMahoadon = mahoadon;
            }
            totalAmount += xn.getThanhtien();
    %>
            <tr>
                <td><%= mahoadon %></td>
                <td><%= xn.getHoten() %></td>
                <td><%= xn.getTensp() %></td>
                <td><%= xn.getGia() %> VND</td>
                <td><%= xn.getSoluongmua() %></td>
                <td><%= xn.getThanhtien() %> VND</td>
                <td><%= xn.getDiachimua() %></td>
                <td><%= xn.getNgaymua() %></td>
            </tr>
    <%
        }
        if (currentMahoadon != -1) {
    %>
            <tr style="font-weight: bold; color: red;">
                <td colspan="6" style="text-align: right;"><strong>Tổng tiền: <%= totalAmount %> VND</strong></td>
                <td colspan="2">
                    <a href="adminxacnhanHDController?mahoadon=<%=currentMahoadon%>">Xác nhận đơn hàng</a>
                </td>
            </tr>
    <%
        }
    %>
</table>

<!-- Thông tin quán -->
<div class="container text-center">
  <h2>Coffee Here</h2>
  <p><em>Address: 16/8/236 Bà Triệu</em></p>
  <p>==========Admin==========</p>
</div>

</body>
</html>