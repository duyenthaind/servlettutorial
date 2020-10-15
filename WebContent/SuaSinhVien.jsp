<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Sửa thông tin sinh viên</h2>
  <form class="form-horizontal" action="SuaSV" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Mã sinh viên:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="maSV" placeholder="Nhập vào mã SV:" value="<%
        	ServletContext context = getServletContext();
       	 out.print(context.getAttribute("maSV"));
        %>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Họ tên sinh viên:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="hoTen" placeholder="Nhập vào họ tên:" value="<%
        	ServletContext context2 = getServletContext();
       	 out.print(context2.getAttribute("tenSV"));
        %>">
      </div>
    </div>
  <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Mã lớp:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="maLop" placeholder="Nhập vào mã lớp" value="<%
        	ServletContext context3 = getServletContext();
       	 out.print(context3.getAttribute("maLop"));
        %>">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">sdt:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="sdt" placeholder="Nhập vào sdt:" value="<%
        	ServletContext context4 = getServletContext();
       	 out.print(context4.getAttribute("sdt"));
        %>">
      </div>
      </div>
      
      <div class="form-group">
      <label class="control-label col-sm-2" for="email">Mã Khoa	:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="maKhoa" placeholder="Nhập vào mã khoa:" value="<%
        	ServletContext context5 = getServletContext();
       	 out.print(context5.getAttribute("maKhoa"));
        %>">
      </div>
      </div>
      
      
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Sửa</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>