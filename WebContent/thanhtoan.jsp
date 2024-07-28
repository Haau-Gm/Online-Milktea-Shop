<%@page import="java.util.ArrayList"%>
<%@page import="bean.khthanhtoanbean"%>
<%@page import="bean.khachhangbean"%>
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

  .btn-link:hover {
    text-decoration: underline;
  }
  
  /* Định dạng thông báo khi thanh toán thành công*/
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
      <li><a href="htgioController">Giỏ hàng</a></li>
      <li class="active"><a href="thanhtoanController">Thanh toán</a></li>
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

<!--Main -->
<div style="text-align: center">
    <h3 style="display: inline-block; color: teal">Vui lòng thanh toán qua mã QR hoặc số TK ngân hàng</h3><br>
    <img src="thanhtoan.jpg" style="vertical-align: middle" width="300" height="300">
</div>

<table class="table">
    <tr>
        <td colspan="6" class="cart-title">Hóa đơn:</td>
    </tr>
    <%
        ArrayList<khthanhtoanbean> ds = (ArrayList<khthanhtoanbean>) request.getAttribute("thanhtoan");
        long currentMahoadon = -1;
        long totalAmount = 0;
        for (khthanhtoanbean tt : ds) {
            if (currentMahoadon != Long.parseLong(tt.getMahoadon())) {
                if (currentMahoadon != -1) {
    %>
                    <tr style="font-weight: bold; color: red;">
                        <td colspan="5" style="text-align: right;"><strong>Tổng tiền: <%= totalAmount %> VND</strong></td>
                        <td colspan="1">
                            <a href="khthanhtoanController?mahoadon=<%=currentMahoadon%>">Xác nhận đã thanh toán</a>
                        </td>
                    </tr>
    			<%
                totalAmount = 0;
                }
                %>
                <tr>
                    <th>Mã hóa đơn</th>
                    <th>Tên sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th>Ngày mua</th>
                </tr>
    	<%
            currentMahoadon = Long.parseLong(tt.getMahoadon());
            }
    	%>
            <tr>
                <td><%= tt.getMahoadon() %></td>
                <td><%= tt.getTensp() %></td>
                <td><%= tt.getGia() %> VND</td>
                <td><%= tt.getSoluongmua() %></td>
                <td><%= tt.getThanhtien() %> VND</td>
                <td><%= tt.getNgaymua() %></td>
            </tr>
    	<%
            totalAmount += tt.getThanhtien();
        }
        if (currentMahoadon != -1) {
    	%>
            <tr style="font-weight: bold; color: red;">
                <td colspan="5" style="text-align: right;"><strong>Tổng tiền: <%= totalAmount %> VND</strong></td>
                <td colspan="1">
                   <a href="khthanhtoanController?mahoadon=<%=currentMahoadon%>">Xác nhận đã thanh toán</a>
                </td>
            </tr>
    <%
        }
    %>
</table>
  
<!-- Thông báo đã thanh toán thành công -->
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
  boolean loginFailed = true; // Thay đổi giá trị này dựa trên kết quả đăng nhập
  if (loginFailed) {
%>
    <script>
      showNotification("Thanh toán thành công! Đơn hàng sẽ sớm được giao đến bạn.", true);
    </script>
	<%}%>
<%}%>
</body>
</html>