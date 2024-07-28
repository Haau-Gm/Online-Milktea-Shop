<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@page import="bo.sanphambo"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.sanphambean"%>
<%@page import="bean.khachhangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coffee Here</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.container {
    padding: 10px 40px;
    padding-left: 20px; /* Tạo khoảng cách lề bên trái */
  }
  
  /* căn sản phẩm */
   .center {
            display: flex;
            justify-content: center;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 10px;
        }
        .pagination a {
            padding: 5px 10px;
        }
  
  /* table {
    margin: auto;
  } */
  table tr,td {
            text-align: center; /* Căn giữa nội dung trong mỗi ô */
            padding: 10px; /* Tạo khoảng cách giữa các ô */
        }
        
 <!--Căn loại -->
        .centered-links {
            display: flex;
            align-items: center;
        }
        .centered-link {
            padding: 10px 5px;
            font-size: 18px;
            margin: 5px;
            color: #ffffff;
            border-radius: 5px;
            text-decoration: none;
        }
        
.person {
    border: 10px solid transparent;
    margin-bottom: 25px;
    width: 80%;
    height: 80%;
    opacity: 0.7;
  }
  .person:hover {
    border-color: #f1f1f1;
  }
.carousel-inner img {
    width: 70%; /* Set width to 100% */
    margin: auto;
  }
  .carousel-caption h3 {
    color: #fff !important;
  }
  @media (max-width: 600px) {
   .carousel-caption {
    display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  } 
  /* Thông báo không có sản phẩm */
  .no-result-message {
    padding: 5px;
    background-color: #FF5733;
    color: white;
    text-align: center;
    border-radius: 5px;
    margin-bottom: 10px;
    font-size: 18px;
}
   
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="trangchuController">Trang chủ</a></li>
      <li><a href="htgioController">Giỏ hàng</a></li>
      <li><a href="thanhtoanController">Thanh toán</a></li>
      <li><a href="lichsuController">Lịch sử mua hàng</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="trangchuController" method="post">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="txttim">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit" onclick="showNoResultMessage()">
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

<!-- hình ảnh quảng cáo Carousel -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="anhqc4.jpg" alt="MilkTea" width="1200" height="700">
        <div class="carousel-caption">
          <h3>MilkTea</h3>
          <p>Thơm ngon đủ hương vị!</p>
        </div>      
      </div>

      <div class="item">
        <img src="anhqc2.jpg" alt="Khuyến mãi" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Khuyến mãi</h3>
          <p>Ưu đãi hàng ngày tại khung giờ vàng!</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="anhqc1.jpeg" alt="Coffee" width="1200" height="700">
        <div class="carousel-caption">
          <h3>Coffee</h3>
          <p>Mùi hương mới lạ kiểu dáng bắt mắt!</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- Main -->

<!-- Danh sách loại -->
<div class="container">
	<div class="centered-links">
	<!-- <h2 style="color: teal">Sản phẩm</h2> -->
	<a href="trangchuController" style="color: purple; font-size: 28px">Sản phẩm</a>
        	<ul class="menu">
           		<!-- <li class="centered-link" ><a href="">Coffee</a></li>
				<li class="centered-link" ><a href="">MilkTea</a></li>
				<li class="centered-link" ><a href="">Tea</a></li> -->
			<%//Lay dsloai tu sachController gui ve
			ArrayList<loaibean> dsloai=(ArrayList<loaibean>)request.getAttribute("dsloai");
				for(loaibean loai: dsloai){ //Hien thi all loai
			%>	
					<li class="centered-link" ><a href="trangchuController?ml=<%=loai.getMaloai()%>"><%=loai.getTenloai() %></a></li>
				<%}%>
            </ul>
            
  <!-- Danh sách sản phẩm -->
  <table class="table" >
  <%
	response.setCharacterEncoding("utf-8");	//trả dữ liệu lên bằng utf-8
	request.setCharacterEncoding("utf-8");	//trả dữ liệu về cũng bằng utf-8		
	//Lay dssp tu trangchuController gui ve
	//Phân trang
    int itemsPerPage = 4; // Số dòng dữ liệu trên mỗi trang
    int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
    int startItem = (currentPage - 1) * itemsPerPage;
    
    ArrayList<sanphambean> ds = (ArrayList<sanphambean>) request.getAttribute("dssp");
    int n = ds.size();
	%>
	
	<%	if (n == 0) { %>
    <tr>
        <td colspan="2">
            <div class="no-result-message">
                Không có sản phẩm này.
            </div>
        </td>
    </tr>
    <% } else {
        for (int i = startItem; i < Math.min(startItem + itemsPerPage, n); i += 2) {
            sanphambean s1 = ds.get(i);
            sanphambean s2 = (i + 1 < n) ? ds.get(i + 1) : null;
    %>
    <tr>
        <td>
            <img src="<%= s1.getAnh() %>"><br>
            <a href="gioController?masp=<%= s1.getMasp() %> &tensp=<%= s1.getTensp() %> &gia=<%= s1.getGia() %>">
                <img src="NutMua.jpg"></a><br>
            Tên sản phẩm: <%= s1.getTensp() %><br>
            Giá bán: <b><%= s1.getGia() %> VND</b><hr>
        </td>

        <td>
            <% if (s2 != null) { %>
            <img src="<%= s2.getAnh() %>"><br>
            <a href="gioController?masp=<%= s2.getMasp() %> &tensp=<%= s2.getTensp() %> &gia=<%= s2.getGia() %>">
                <img src="NutMua.jpg"></a><br>
            Tên sản phẩm: <%= s2.getTensp() %><br>
            Giá bán: <b><%= s2.getGia() %> VND</b><hr>
            <% } %>
        </td>
    </tr>
    <% }
    } %>

    </table>
</div>
</div>

<div class="center pagination">
    <%
        int totalPages = (int) Math.ceil((double) n / itemsPerPage);
        int minPage = Math.max(1, currentPage - 2);
        int maxPage = Math.min(totalPages, currentPage + 2);
    %>
    <% if (currentPage > 1) { %>
        <a href="?page=<%= currentPage - 1 %>"style="font-size: 16px ">Trang trước</a>
    <% } %>
    
    <% for (int i = minPage; i <= maxPage; i++) { %>
        <a href="?page=<%= i %>" style="font-size: 16px "><%= i %></a>
    <% } %>
    
    <% if (currentPage < totalPages) { %>
        <a href="?page=<%= currentPage + 1 %>" style="font-size: 16px ">Trang sau</a>
    <% } %>
</div>


<!-- Thông tin quán -->
<div class="container text-center">
  <h2>Coffee Here</h2>
  <p><em>Address: 16/8/236 Bà Triệu</em></p>
  <p>Hân hạnh được phục vụ quý khách!</p>
  <br>
  <div class="row">
    <div class="col-sm-4">
     <!--  <p><strong>Name</strong></p><br> -->
      <img src="anhquan1.png" class="img-circle person" alt="Random Name" width="255" height="255">
    </div>
    <div class="col-sm-4">
      <img src="anhquan2.png" class="img-circle person" alt="Random Name" width="255" height="255">
    </div>
    <div class="col-sm-4">
      <img src="anhquan3.png" class="img-circle person" alt="Random Name" width="255" height="255">
    </div>
  </div>
  <p>Miễn phí giao hàng trong bán kính 5km, nếu xa hơn sẽ có tính phí kèm theo. Coffee Here xin cảm ơn!</p>
</div>
</body>
</html>