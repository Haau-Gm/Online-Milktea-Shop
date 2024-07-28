<%@page import="java.util.ArrayList"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.loaibean"%>
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
    width: 80%;
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
    .form {
      background-color: white;
      border-radius: 10px;
      padding: 20px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
      width: 300px;
      text-align: center;
      margin: 0 auto;
      margin-bottom: 40px; /* Tạo khoảng cách với table */
    }
    .form input[type="text"],
    .form input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .form input[type="submit"] {
      background-color: teal;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
  
    <ul class="nav navbar-nav">
    	<li><a href="adminxacnhanHDController">Quản lý hóa đơn</a></li>
    	<li><a href="adminKHthanhtoanController">Khách hàng đã thanh toán</a></li>
    	<li><a href="admindoanhthuController">Doanh thu</a></li>
     	<li class="active"><a href="adminloaiController">Quản lý loại</a></li>
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
<%-- 	<!-- Nhấn select hiện thông tin loại lên form -->
<%
		String txtmaloai=request.getParameter("ml2")+"";
		txtmaloai = (txtmaloai.equals("null"))?"":txtmaloai;
		String txttenloai=request.getParameter("tl2")+"";
		txttenloai = (txttenloai.equals("null"))?"":txttenloai;
%> --%>
<form class="form" action="adminloaiController" method="post">
    <h3 style="color: teal; font-weight: bold">Quản lý Loại</h3>
    <div>
      <label for="txtmaloai">Mã loại:</label>
      <input name="txtmaloai" type="text" id="txtmaloai" required>
    </div>
    <div>
      <label for="txttenloai">Tên loại:</label>
      <input name="txttenloai" type="text" id="txttenloai" required>
    </div>
    <div>
      <input name="butadd" type="submit" value="Add">
      <input name="butupdate" type="submit" value="Update">
    </div>
  </form>
  
<table class="table">
  <tr>
    <td colspan="8" class="cart-title">Danh sách loại thức uống:</td>
  </tr>
  <tr>
    <th>Mã loại</th>
    <th>Tên loại</th>
    <th>Chọn</th>
    <th>Xóa loại này</th>
  </tr>
  <%
		ArrayList<loaibean> ds=(ArrayList<loaibean>)request.getAttribute("dsloai");
		for(loaibean loai:ds){
	%>	
		<tr>
			<td><%=loai.getMaloai()%></td>
			<td><%=loai.getTenloai()%></td>
			<%-- <td><a href="adminloaiController?ml=<%=loai.getMaloai()%>&tl=<%=loai.getTenloai()%>&tab=chon">Select</a></td> --%>
			<td><a href="javascript:void(0);" onclick="displaySelectedInfo('<%=loai.getMaloai()%>', '<%=loai.getTenloai()%>')">Select</a></td>
			<td><a href="adminloaiController?ml=<%=loai.getMaloai() %>&tab=xoa">Xóa</a></td>
		</tr>
		<%}%>
	</table>

<!-- Thông tin quán -->
<div class="container text-center">
  <h2>Coffee Here</h2>
  <p><em>Address: 16/8/236 Bà Triệu</em></p>
  <p>==========Admin==========</p>
</div>

<script>
function displaySelectedInfo(maloai, tenloai) {
    document.getElementById("txtmaloai").value = maloai;
    document.getElementById("txttenloai").value = tenloai;
}
</script>
</body>
</html>