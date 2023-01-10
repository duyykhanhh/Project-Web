<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header/admin-header.jsp"></jsp:include>

<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
		<li class="breadcrumb-item active">Products</li>
	</ol>
	<hr />
	<div class="card mb-4">
		<div class="card-header"></div>
	</div>
	<a href="admin-add-product">Add</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Action</th>
		</tr>

		<c:forEach var="item" items="${list}">
			<!-- set up a link for each student -->
			<c:url var="tempLink" value="admin-edit-product">
				<c:param name="command" value="LOAD" />
				<c:param name="id" value="${item.id}" />
			</c:url>
			<!-- set up a link for each student -->
			<c:url var="deleteLink" value="admin-delete-product">
				<c:param name="command" value="DELETE" />
				<c:param name="id" value="${item.id}" />
			</c:url>
			<tr>
				<td>${item.id}</td>

				<td>${item.name}</td>
				<td><img src="${item.image}" alt="IMG PRODUCT"
					style="width: 100px; height: 70px" /></td>
				<c:set var="p" value="${item.price}" />
				<fmt:setLocale value="vi_VN" />
				<td><fmt:formatNumber value="${p}" type="currency"
						maxFractionDigits="0" /></td>

				<td><a href="${tempLink}">Update</a> | <a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this product?')))
					    return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="footer/admin-footer.jsp"></jsp:include>