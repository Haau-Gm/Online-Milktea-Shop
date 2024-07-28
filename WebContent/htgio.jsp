<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@page import="bo.sanphambo"%>
<%@page import="bo.giohangbo"%>

<%@page import="bean.loaibean"%>
<%@page import="bean.sanphambean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coffee here</title>
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

  /* Định dạng tiêu đề hiển thị giỏ hàng */
  .cart-title {
    color: teal;
    font-size: 24px;
    margin-bottom: 10px;
  }

  /* Định dạng nút Sửa */
  .btn-link {
    background: none;
    border: none;
    color: teal;
    cursor: pointer;
  }

  .btn-link:hover {
    text-decoration: underline;
  }

  /* Định dạng tổng tiền */
  .total-row {
    font-weight: bold;
    text-align: right;
    color: red;
  }
 /*  Bao bọc tổng tiền để căn phải */
  .total-wrapper {
    display: flex;
    justify-content: flex-end;
  }

  /* Định dạng dòng xóa giỏ hàng */
  .last-row {
  	font-weight: bold;
    text-align: center;
    padding-top: 10px;
  }
  /* Định dạng nút xác nhận */
  .center-button {
    width: 150px;
    padding: 5px;
    display: block;
    margin: 0 auto;
  }
  
  /* Định dạng thông báo khi không hàng trong giỏ không thể xác nhận mua*/
    .notification {
    position: fixed;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    padding: 10px 20px;
    border-radius: 5px;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
    z-index: 9999;
    font-weight: bold;
    width: 300px;
    text-align: center;
  }

  .success {
    background-color: #4CAF50;
    color: white;
  }

  .error {
    background-color: #FF5733;
    color: white;
  }
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="trangchuController">Trang chủ</a></li>
      <li class="active"><a href="htgioController">Giỏ hàng</a></li>
      <li><a href="thanhtoanController">Thanh toán</a></li>
      <li><a href="lichsuController">Lịch sử mua hàng</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="trangchuController" method="post">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="txttim">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    
    <ul class="nav navbar-nav navbar-right">
     <li><a href="dangkyController"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
     <!-- <li><a href="dangnhapController"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li> -->
     
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
    <td colspan="7" class="cart-title">Hiển thị giỏ hàng:</td>
  </tr>
  <tr>
    <th>Mã sản phẩm</th>
    <th>Tên sản phẩm</th>
    <th>Số lượng</th>
    <th>Đơn giá</th>
    <th>Thành tiền</th>
    <th>Đổi số lượng</th>
    <th>Xóa</th>
  </tr>
  <%
  giohangbo gh=null;
  if(session.getAttribute("gh")!=null){
    gh=(giohangbo)session.getAttribute("gh");
    for(giohangbean h: gh.ds){%>
      <tr>
        <td><%=h.getMasp()%></td>
        <td><%=h.getTensp()%></td>
        <td><%=h.getSoluongmua()%></td>
        <td><%=h.getGia()%> VND</td>
        <td><%=h.getThanhtien()%> VND</td>
        <td>
          <form action="suaslController?masp=<%=h.getMasp()%>" method="post">
            <input type="number" name="txtsl" min="1" width="10">
            <input type="submit" name="but1" value="Sửa" class="btn-link">
          </form>
        </td>
        <td>
          <a href="xoaspController?masp=<%=h.getMasp() %>" class="btn-link">Xóa</a>
        </td>
      </tr>
    <%}%>
    <tr>
    	<td colspan="6"></td>
    	<td colspan="1" class="total-wrapper">
        <span class="total-row">Tổng tiền: <%=gh.Tong()%> VND</span>
    	</td>
  	</tr>
    <tr class="last-row">
      <td colspan="7"><a href="xoahetgioController" class="btn-link">Xóa giỏ hàng</a></td>
    </tr>
  <%}%>
</table>

<div class="form-wrapper">
  <form action="khxacnhanController" method="post">
  	<div style="display: flex; align-items: center; margin-left: 70px">
        <strong style="margin-right: 10px;">Địa chỉ đặt mua:</strong>
        <input type="text" name="txtdiachimua" required>
    </div>
    <input type="submit" name="b1" value="Xác nhận đặt mua" class="center-button btn-primary">
  </form>
</div>

<!-- Hiển thị thông báo giỏ hàng trống  -->
<script>
  function showNotification(message, isError) {
    var notification = document.createElement("div");
    notification.className = isError ? "notification error" : "notification success";
    notification.textContent = message;

    document.body.appendChild(notification);
    
    setTimeout(function() {
      document.body.removeChild(notification);
    }, 4000); // Thời gian hiển thị hộp thông báo (4 giây)
  }
  <%if(request.getParameter("kt")!=null){%>
</script>
<% 
  boolean loginFailed = true;
  if (loginFailed) {
%>
    <script>
      showNotification("Không có đơn hàng nào trong giỏ. Đặt hàng không thành công!", true);
    </script>
	<%}%>
<%}%>
</body>
</html>