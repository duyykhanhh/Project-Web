<jsp:include page="header/admin-header.jsp"></jsp:include>
<div class="container-fluid px-4">
	<h1 class="mt-4">Dashboard</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item active">Dashboard</li>
	</ol>
	<hr />
</div>
<div class="row" style="margin: 20px">
	<div class="col-xl-3 col-md-6">
		<div class="card bg-primary text-white mb-4">
			<div class="card-body">Products</div>
			<div
				class="card-footer d-flex align-items-center justify-content-between">
				<div class="small text-white">Total number: ${totalProduct }</div>
			</div>
		</div>
	</div>

	<div class="col-xl-3 col-md-6">
		<div class="card bg-primary text-white mb-4">
			<div class="card-body">Users</div>
			<div
				class="card-footer d-flex align-items-center justify-content-between">
				<div class="small text-white">Total number: ${totalUser }</div>
			</div>
		</div>
	</div>



	<div class="col-xl-3 col-md-6">
		<div class="card bg-primary text-white mb-4">
			<div class="card-body">Orders</div>
			<div
				class="card-footer d-flex align-items-center justify-content-between">
				<div class="small text-white">Total number: ${totalOrder }</div>
			</div>
		</div>
	</div>

	<div class="col-xl-3 col-md-6">
		<div class="card bg-primary text-white mb-4">
			<div class="card-body">Order Details</div>
			<div
				class="card-footer d-flex align-items-center justify-content-between">
				<div class="small text-white">Total number: ${numberOrderdetail }</div>
			</div>
		</div>
	</div>

</div>
<jsp:include page="footer/admin-footer.jsp"></jsp:include>