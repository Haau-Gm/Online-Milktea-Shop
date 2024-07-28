<%@page import="java.util.ArrayList"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.sanphambean"%>
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

	.form-control {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
	}

	.radio-group {
    display: flex;
    align-items: center;
    justify-content: center; /* Căn giữa theo chiều ngang */
    margin-bottom: 15px;
	}

	.radio-label {
    margin-right: 15px;
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
            <li><a href="adminloaiController">Quản lý loại</a></li>
            <li class="active"><a href="adminsanphamController">Quản lý sản phẩm</a></li>
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
<%
response.setCharacterEncoding("utf-8");  // Trả dữ liệu lên bằng utf-8
request.setCharacterEncoding("utf-8");  // Trả dữ liệu về cũng bằng utf-8
%>

<form class="form" action="adminsanphamController" method="post" enctype="multipart/form-data">
    <h3 style="color: teal; font-weight: bold">Quản lý sản phẩm</h3>
    <div>
        <label for="txtmasp">Mã sản phẩm:</label>
        <input name="txtmasp" type="text" id="txtmasp" required>
    </div>
    <div>
        <label for="txttensp">Tên sản phẩm:</label>
        <input name="txttensp" type="text" id="txttensp" required>
    </div>
    <div class="form-group">
        <label for="txtgia">Đơn giá:</label>
        <input name="txtgia" type="number" id="txtgia" min="1" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="txtluongnguyenlieu">Lượng nguyên liệu:</label>
        <div class="radio-group">
            <label class="radio-label"><input type="radio" name="txtluongnguyenlieu" value="1" id="luongnguyenlieu-1" required> Đủ</label>
            <label class="radio-label"><input type="radio" name="txtluongnguyenlieu" value="0" id="luongnguyenlieu-0"> Không đủ</label>
        </div>
    </div>
    <div>
        <label for="txtmaloai">Mã loại:</label>
        <input name="txtmaloai" type="text" id="txtmaloai" required>
    </div>
    
    <!-- Hiển thị ảnh đã chọn -->
	<div id="selectedImageContainer" style="display: none;">
    	<img id="selectedImage" width="100" height="100">
	</div>
	<div>
        <label for="txtfile">Ảnh:</label>
        <input name="txtfile" type="file" id="txtfile" onchange="displaySelectedImage()">
    </div><br>
    <div>
        <label for="txtanh">Địa chỉ ảnh:</label>
        <input name="txtanh" type="text" id="txtanh" readonly>
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
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Nguyên liệu</th>
        <th>Ảnh</th>
        <th>Mã loại</th>
        <th>Chọn</th>
        <th>Xóa loại này</th>
    </tr>
    <%
        ArrayList<sanphambean> ds=(ArrayList<sanphambean>)request.getAttribute("dssp");
        for(sanphambean sp:ds){
    %>  
        <tr>
            <td><%=sp.getMasp()%></td>
            <td><%=sp.getTensp()%></td>
            <td><%=sp.getGia()%></td>
            <td><%= sp.isLuongnguyenlieu()?"Đủ":"Không đủ"%></td>
            <td><img src="<%=sp.getAnh()%>" width="100" height="100"></td>
            <td><%=sp.getMaloai()%></td>
            <td><a href="javascript:void(0);" onclick="displaySelectedInfo('<%=sp.getMasp()%>', '<%=sp.getTensp()%>',
             '<%=sp.getGia()%>', '<%=sp.isLuongnguyenlieu()?"1":"0"%>', '<%=sp.getMaloai()%>', '<%=sp.getAnh()%>')">Select</a></td>
            <td><a href="adminsanphamController?masp=<%=sp.getMasp() %>&tab=xoa">Xóa</a></td>
        </tr>
        <%
        }
    %>
</table>



<script>
function displaySelectedInfo(masp, tensp, gia, luongnguyenlieu, maloai, anh) {
    document.getElementById("txtmasp").value = masp;
    document.getElementById("txttensp").value = tensp;
    document.getElementById("txtgia").value = gia;
 	//Chọn radio button dựa trên giá trị luongnguyenlieu
    if(luongnguyenlieu === '1') {
        document.getElementById("luongnguyenlieu-1").checked = true;
    }else{
        document.getElementById("luongnguyenlieu-0").checked = true;
    }
    document.getElementById("txtmaloai").value = maloai;
    document.getElementById("txtanh").value = anh;
    
    document.getElementById("selectedImage").src = anh; // Hiển thị ảnh đã chọn
    
  	document.getElementById("txtfile").value = ""; // Đặt lại giá trị trường file

    // Hiển thị ảnh đã chọn
    var selectedImage = document.getElementById("selectedImage");
    selectedImage.src = anh;

    // Hiển thị ảnh và container khi có ảnh được chọn
    var selectedImageContainer = document.getElementById("selectedImageContainer");
    if (anh !== "") {
        selectedImageContainer.style.display = "block";
    } else {
        selectedImageContainer.style.display = "none";
    }
}
//Hiển thị hình ảnh file
function displaySelectedImage() {
    var input = document.getElementById("txtfile");
    var selectedImage = document.getElementById("selectedImage");
    
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function(e) {
            selectedImage.src = e.target.result;
            
            // Hiển thị ảnh và container khi có ảnh được chọn
            var selectedImageContainer = document.getElementById("selectedImageContainer");
            selectedImageContainer.style.display = "block";
        }

        reader.readAsDataURL(input.files[0]);
    }
}
</script>

<!-- Thông tin quán -->
<div class="container text-center">
    <h2>Coffee Here</h2>
    <p><em>Address: 16/8/236 Bà Triệu</em></p>
    <p>==========Admin==========</p>
</div>
</body>
</html>