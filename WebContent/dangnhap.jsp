<%@page import="bean.khachhangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coffee Here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
	.centered-container {
    	display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    } 
 
    /* Định dạng thông báo khi đăng nhập không thành công*/
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

<section class="vh-100 gradient-custom" style="margin-top: 20px">
  <div class="container py-5">
    <div class="row align-items-center">
      <div class="col-12 col-md-12 centered-container">
      <!-- Hình ảnh bên trái -->
        <!-- <img src="logo.jpg" alt="Hình ảnh" class="img-fluid" style="max-width: 130px"> -->
        <div class="card bg-dark text-white form-card" style="padding: 20px">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">
            	<%
				String message = request.getParameter("message");
				if (message != null && !message.isEmpty()) {
				%>
              		<p style="color: teal ;font-size: 20px"><b><%=message%></b></p>
              	<%}%>
              <h3 class="fw-bold mb-2 text-uppercase">Đăng nhập</h3>
              
             <!-- Main -->
              <form action="dangnhapController" method="post">
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txttendn" class="form-control form-control-lg" placeholder="Tên đăng nhập" />
                </div>

                <div class="form-outline form-white mb-4">
                  <input type="password" name="txtpass" class="form-control form-control-lg" placeholder="Mật khẩu" />
                </div>
                  <button class="btn btn-outline-light btn-lg px-5" type="submit" name="b1" style="background-color: teal; color: white; font-size: 12px; padding: 10px 26px">Đăng nhập</button>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Thông tin quán -->
<div class="container text-center">
  <h3>Coffee Here</h3>
  <p><em>Address: 16/8/236 Bà Triệu</em></p>
  <p>Hân hạnh được phục vụ quý khách!</p>
  <br>
  <div class="row">
    <div class="col-sm-4">
     <!--  <p><strong>Name</strong></p><br> -->
      <img src="anhquan1.png" class="img-circle person" alt="Random Name" width="200" height="200">
    </div>
    <div class="col-sm-4">
      <img src="anhquan2.png" class="img-circle person" alt="Random Name" width="200" height="200">
    </div>
    <div class="col-sm-4">
      <img src="anhquan3.png" class="img-circle person" alt="Random Name" width="200" height="200">
    </div>
  </div>
</div>

<!-- Thông báo đăng nhập không thành công -->
<%-- <% if(request.getParameter("kt")!=null){%>
		<!-- <B><span style="color:red">Thông tin đăng nhập sai</span></B> -->
		<script>
        	window.alert("Thông tin đăng nhập sai!");
    	</script><%}%> --%>
    	
    	
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
      showNotification("Đăng nhập thất bại. Vui lòng kiểm tra tên đăng nhập hoặc mật khẩu!", true);
    </script>
	<%}%>
<%}%>
</body>
</html>