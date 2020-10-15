<%@page import ="java.sql.ResultSet" %>
<%@page import ="com.fds.jdbc.connect.JDBC" %>
<%@page import ="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Demo Connect DTB</title>
	<style type="text/css">
		.row {  
			margin-top:40px;    
			padding: 0 10px;
		}
		.clickable {    
			cursor: pointer;
		}
		.panel-heading div {    
			margin-top: -18px;  
			font-size: 15px;
		}
		.panel-heading div span {   
			margin-left:5px;
		}
		.panel-body {   
			display: none;
		}
	</style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	

</head>
<body>
	<div class="container"> 
		<h2 align="center">Tạo table để kết nối cơ sở dữ liệu</h2> 
		<div class="row"> 
			<div class="col-md-12"> 
						<a href="ThemSinhVien.jsp"><button class="btn btn-success">Thêm tài khoản</button></a>
						<a href="XoaSinhVien.jsp"><button class="btn btn-warning">Xóa</button></a>
				<div class="panel panel-primary"> 
					<div class="panel-heading"> 
						<h3 class="panel-title">Danh sách thành viên</h3> 
						
					</div> 
					<div class="panel-body"> <input class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Từ khóa" type="text"> 
					</div> 
					
					<%
		
						JDBC cn = new JDBC();
						ResultSet rs = cn.traVeKetQua("select * from sinhvien");
	
					%>
					<table class="table table-hover" id="dev-table"> 
						<thead> 
							<tr>
            					<td>Mã Sinh Viên</td>
            					<td>Họ tên</td>
            					<td>Mã lớp</td>
           					 	<td>số điện thoại</td>
            					<td>Mã khoa</td>
       						</tr>
						</thead> 
						<tbody>
						<%
						while(rs.next()){
						%>
						
							<tr>
            					<td><%=rs.getString("maSV") %></td>
            					<td><%=rs.getString("hoTen") %></td>
            					<td><%=rs.getString("maLop") %></td>
           						<td><%=rs.getString("sdt") %></td>
            					<td><%=rs.getString("maKhoa") %></td>
								<td><a href="SuaSinhVien.jsp?maSV=<%=rs.getString(1)%>"><button class="btn btn-primary">Sửa</button></a></td>
        					</tr>
        				<%} %>			
					</tbody></table> 
				</div> 
			</div> 
		</div>
		
	
		
	</div>
	
	</body>
	</html>