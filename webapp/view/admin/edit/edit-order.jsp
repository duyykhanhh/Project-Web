<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/view/admin/header/action-header.jsp"></jsp:include>
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
	<div class="container add">
		<form action="admin-edit-order" method="post">
			<input type="hidden" name="command" value="Edit" /> <input
				type="hidden" name="id" value="${item.orderId}">
			<table>
				<tbody>

					<tr>
						<td><label>Order date:</label></td>
						<td><input type="date" name="orderDate"
							placeholder="Order Date" value="${item.orderDate}" /></td>
					</tr>
					<tr>
						<td><label>Address:</label></td>
						<td><input type="text" name="address" placeholder="Address"
							value="${item.address}" /></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="phoneNumber"
							placeholder="Phone Number" value="${item.phoneNumber}" />
						</td>
					</tr>
					<tr>
						<td><label>Total Price:</label></td>
						<td><input type="text" name="totalPrice"
							placeholder="Total Price" value="${item.totalPrice}" /></td>
					</tr>
					<tr>
						<td><label>Status:</label></td>
						<td style="display: flex"><input type="radio" name="status"
							value="true" style="width: 20px" /> <label>Đã
								thanh toán</label> <input type="radio" name="status" value="false"
							style="width: 20px" /> <label>Chưa thanh toán</label></td>
					</tr>
					<tr>
						<td><label>User id:</label></td>
						<td><select name="userId">
								<c:forEach var="u" items="${listUser}">
									<option value="${u.id}">${u.fullName}</option>
								</c:forEach>
						</select></td>
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
			<a href="admin-order">Back to List</a>
		</p>
	</div>
</div>

<jsp:include page="/view/admin/footer/admin-footer.jsp"></jsp:include>
