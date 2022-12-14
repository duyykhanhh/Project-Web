<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/user-profile.css">

</head>
<body>

	<div class="container emp-profile">
		<form method="post" action="${pageContext.request.contextPath}/user-profile">
			<div class="row">
				<div class="col-md-4">
					<div class="profile-img">
						<img
							src="https://icons.veryicon.com/png/o/miscellaneous/two-color-icon-library/user-286.png"
							alt="ABC Chicken" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="profile-head">
						<h5>${user.name}</h5>
						<h6>VIP</h6>
						<p class="proile-rating">
							RANKINGS : <span>8/10</span>
						</p>
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">About</a></li>
							<li class="nav-item"><a class="nav-link" id="profile-tab"
								data-toggle="tab" href="#profile" role="tab"
								aria-controls="profile" aria-selected="false">Timeline</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2">
				<a href="${pageContext.request.contextPath}/trang-chu" class="profile-edit-btn">Quay lại</a>
				<br/>
				<a href="${pageContext.request.contextPath}/logout" class="profile-edit-btn">Đăng xuất</a>
				</div>
				<div class="col-md-2">
					<input type="submit" id="change-profile" class="profile-edit-btn"
						name="btnAddMore" value="Thay đổi" />

				</div>

			</div>
			<div class="row">

				<div id="work-and-skill" class="col-md-4"></div>
				<div class="col-md-8">
					<div class="tab-content profile-tab" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<input type="hidden" name="command" value="DIRECT">
							<div class="row">
								<div class="col-md-6">
									<label>User Id</label>
								</div>
								<div class="col-md-6">
									<p>${user.id }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Tên</label>
								</div>
								<div class="col-md-6">
									<p>${user.name }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Email</label>
								</div>
								<div class="col-md-6">
									<p>${user.email }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Số điện thoại</label>
								</div>
								<div class="col-md-6">
									<p>${user.phone }</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<label>Trạng thái</label>
								</div>
								<div class="col-md-6">
									<p>VIP</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>