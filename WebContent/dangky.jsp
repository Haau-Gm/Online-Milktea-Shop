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
     <li><a href="dangnhapController"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
     <li><a href="dangxuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
    </ul>
  </div>
</nav>
<section class="vh-100 gradient-custom" style="margin-top: 20px">
  <div class="container py-5">
    <div class="row align-items-center">
      <div class="col-12 col-md-12 centered-container">
     
        <div class="card bg-dark text-white form-card" style="padding: 20px">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h3 class="fw-bold mb-2 text-uppercase">Đăng ký</h3>
              <%
				String message = request.getParameter("message");
				if (message != null && !message.isEmpty()) {
				%>
              <p class="text-danger"><b><%=message%></b></p>
              <%}%>
             <!-- Main -->
              <form action="dangkyController" method="post">
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txthoten" class="form-control form-control-lg" placeholder="Họ tên" required />
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txtdiachi" class="form-control form-control-lg" placeholder="Địa chỉ" required />
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txtsodt" class="form-control form-control-lg" placeholder="Số điện thoại" required />
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txtemail" class="form-control form-control-lg" placeholder="Email" required />
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="text" name="txttendn" class="form-control form-control-lg" placeholder="Tên đăng nhập" required />
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="password" name="txtpass" class="form-control form-control-lg" placeholder="Mật khẩu" required/>
                </div>
                <div class="form-outline form-white mb-4">
                  <input type="password" name="txtpass2" class="form-control form-control-lg" placeholder="Nhập lại mật khẩu" required/>
                </div>
                
                <input type="checkbox" id="check" name="check" required/>
                <label for="check">Tôi đồng ý với chính sách của Cafe Here</label><span style="color: red;font-size: larger;"> *</span><br>
                <button class="btn btn-outline-light btn-lg px-5" type="submit" name="b1" style="background-color: teal; color: white; font-size: 12px; padding: 10px 26px">Đăng ký</button>
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
</body>
</html>