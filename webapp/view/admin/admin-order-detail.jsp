<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header/admin-header.jsp"></jsp:include>
<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
		<li class="breadcrumb-item active">Order detail</li>
	</ol>
	<hr />
	<div class="card mb-4">
		<div class="card-header"></div>
	</div>
	<a href="admin-add-orderdetail">Add</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Product ID</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Order ID</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${list}">
			<!-- set up a link for each student -->
			<c:url var="tempLink" value="admin-edit-orderdetail">
				<c:param name="command" value="LOAD" />
				<c:param name="id" value="${item.oderDetailId}" />
			</c:url>
			<!-- set up a link for each student -->
			<c:url var="deleteLink" value="admin-delete-orderdetail">
				<c:param name="command" value="DELETE" />
				<c:param name="id" value="${item.oderDetailId}" />
			</c:url>
			<tr>
				<td>${item.oderDetailId}</td>
				<td>${item.productId.productId}</td>
				<td>${item.price}</td>
				<td>${item.quantity}</td>
				<td>${item.orderId.orderId}</td>
				<td><a href="admin-edit-orderdetail">Update</a> | <a
					href="admin-delete-orderdetail"
					onclick="if (!(confirm('Are you sure you want to delete this order detail?')))
					    return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="footer/admin-footer.jsp"></jsp:include>