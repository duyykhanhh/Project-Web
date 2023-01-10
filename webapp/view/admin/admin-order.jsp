<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>"UTF-8"%>
<jsp:include page="header/admin-header.jsp"></jsp:include>
<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
		<li class="breadcrumb-item active">Order</li>
	</ol>
	<hr />
	<div class="card mb-4">
		<div class="card-header"></div>
	</div>
	<a href="admin-add-order">Add</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Order Date</th>
			<th>Address</th>
			<th>Phone number</th>
			<th>Total Price</th>
			<th>Status</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${list}">
			<!-- set up a link for each student -->
			<c:url var="tempLink" value="admin-edit-info">
				<c:param name="command" value="LOAD" />
				<c:param name="id" value="${item.infoId}" />
			</c:url>
			<!-- set up a link for each student -->
			<c:url var="deleteLink" value="admin-delete-info">
				<c:param name="command" value="DELETE" />
				<c:param name="id" value="${item.infoId}" />
			</c:url>
			<tr>
				<td>${item.orderId}</td>
				<td>${item.oderDate}</td>
				<td>${item.address}</td>
				<td>${item.phoneNumber}</td>
				<td>${item.totalPrice}</td>
				<td>${item.status == 1 ? "Đã thanh toán":"Chưa thanh toán"}</td>
				<td><a href="admin-edit-order">Update</a> | <a
					href="admin-delete-order"
					onclick="if (!(confirm('Are you sure you want to delete this order?')))
					    return false">Delete</a>
				</td>
			</tr>
		</c:forEach>


	</table>
</div>
<jsp:include page="footer/admin-footer.jsp"></jsp:include>