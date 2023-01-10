<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/view/admin/header/action-header.jsp"></jsp:include>

<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
		<li class="breadcrumb-item active">Product</li>
	</ol>
	<hr />
	<div class="card mb-4">
		<div class="card-header"></div>
	</div>

	<div class="container add">
		<form action="admin-edit-product" method="post">
			<input type="hidden" name="command" value="EDIT" /> <input
				type="hidden" name="id" value="${item.id}">
			<table>
				<tbody>
					<tr>
						<td><label>Product Name:</label></td>
						<td><input type="text" name="productName"
							placeholder="Product Name" value="${item.name}" /></td>
					</tr>
					<tr>
						<td><label>Link image:</label></td>
						<td><input type="text" name="image" placeholder="Link image"
							value="${item.image}" /></td>
					</tr>
					<tr>
						<td><label>Price:</label></td>
						<c:set var="p" value="${item.price}" />
						<fmt:setLocale value="vi_VN" />
						<td><input type="number" name="price" placeholder="Price"
							value="${item.price}" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Edit" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div style="clear: both"></div>
		<p>
			<a href="admin-product">Back to List</a>
		</p>
	</div>
</div>

<jsp:include page="/view/admin/footer/admin-footer.jsp"></jsp:include>