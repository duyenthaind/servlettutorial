<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Them sinh vien</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>

<div class="container">
  <form class="form-horizontal" action="XoaSV" method="get">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Mã Sinh Viên cần xóa:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="maSV" placeholder=" " >
      </div>
    </div>
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Xóa</button>
        
      </div>
    </div>
    
    
  </form>
</div>

</body>
</html>