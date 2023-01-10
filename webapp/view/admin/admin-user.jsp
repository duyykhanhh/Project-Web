<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header/admin-header.jsp"></jsp:include>
<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
		<li class="breadcrumb-item active">User</li>
	</ol>
	<hr />
	<div class="card mb-4">
		<div class="card-header"></div>
	</div>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Password</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<!-- set up a link for each student -->
			<c:url var="tempLink" value="admin-edit-user">
				<c:param name="command" value="LOAD" />
				<c:param name="id" value="${item.id}" />
			</c:url>
			<!-- set up a link for each student -->
			<c:url var="deleteLink" value="admin-delete-user">
				<c:param name="command" value="DELETE" />
				<c:param name="id" value="${item.id}" />
			</c:url>
			<tr>
				<td>${item.id}</td>
				<td>${item.password}</td>
				<td>${item.name}</td>
				<td>${item.email}</td>
				<td>${item.phone}</td>
				<td><a href="${tempLink}">Update</a> | <a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this user?')))
					    return false">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</div>
<jsp:include page="footer/admin-footer.jsp"></jsp:include>