<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Product Detail</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/styledetail.css"
	type="text/css">

<link href="${pageContext.request.contextPath}/view/web/css/style.css"
	rel="stylesheet" />
<!-- responsive style -->
<link
	href="${pageContext.request.contextPath}/view/web/css/responsive.css"
	rel="stylesheet" />

<link rel='stylesheet prefetch'
	href='https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/view/web/css/shop-details.css">


</head>

<body>

	<header class="header_section">
		<div class="container">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/trang-chu"> <span>
						ABC Chicken </span>
				</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class=""> </span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav  mx-auto ">
						<li class="nav-item active"><a class="nav-link"
							href="${pageContext.request.contextPath}/trang-chu">Trang ch???
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/thuc-don">Th???c ????n</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/about">About</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/order">?????t b??n</a></li>
					</ul>
					<div class="user_option">
						<a href="${pageContext.request.contextPath}/login"
							class="user_link"> <i class="fa fa-user" aria-hidden="true"></i>
						</a> <a class="cart_link"
							href="${pageContext.request.contextPath}/cart"> <svg
								version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
								viewBox="0 0 456.029 456.029"
								style="enable-background: new 0 0 456.029 456.029;"
								xml:space="preserve">
                    <g>
                      <g>
                        <path
									d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                     c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                      </g>
                    </g>
                            <g>
                      <g>
                        <path
									d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                     C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                     c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                     C457.728,97.71,450.56,86.958,439.296,84.91z" />
                      </g>
                    </g>
                            <g>
                      <g>
                        <path
									d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                     c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                      </g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                            <g>
                    </g>
                  </svg>
						</a>
						<form class="form-inline">
							<button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
								<i class="fa fa-search" aria-hidden="true"></i>
							</button>
						</form>
						<a href="${pageContext.request.contextPath}/thuc-don"
							class="order_online"> Order Online </a>
					</div>
				</div>
			</nav>
		</div>
	</header>


	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src="${item.image }" alt="ACB Chicken">
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>${item.name }</h3>

						<div class="product__details__price">
							<c:set var="p" value="${item.price}" />
							<fmt:setLocale value="vi_VN" />
							<fmt:formatNumber value="${p}" type="currency"
								maxFractionDigits="0" />
						</div>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a href="#" class="primary-btn">Th??m v??o gi??? h??ng</a>
						<ul>
							<li><b>Tr???ng th??i</b> <span>C??n h??ng</span></li>
							<li><b>Shipping</b> <span>10-15 ph??t. <samp>Mi???n
										ph?? h??m nay</samp></span></li>
							<li><b>Khuy???n m??i</b> <span>Kh??ng c??</span></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">M??
									t???</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-2" role="tab" aria-selected="false">Th??ng tin</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Th??ng tin s???n ph???m</h6>
									<p>- Nguy??n li???u ???????c l???y t??? nh???ng c?? s??? t???t nh???t.</p>
									<p>- Ph???n ??n ph?? h???p t??? 1 - 2 ng?????i ??n.</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-2" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Th??ng tin</h6>
									<p>- ?????m b???o an to??n th???c ph???m</p>
									<p>- ???????c ch???ng nh???n b???i C???c an to??n th???c ph???m</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>B??nh lu???n</h6>
									<!--                                Ch??? nh???p b??nh lu???n-->
									<div class="comment-box">
										<div class="user-img-container">
											<img class="user-img" src="img/avatar/avatar1.jpg">
										</div>
										<div class="user-name">
											<span>Kh??nh</span>
										</div>
										<div class="comment-content">
											<textarea class="textContent-box" name="txtContent"
												placeholder="M???i b???n nh???p b??nh lu???n"></textarea>
										</div>
									</div>
									<!--End nh???p b??nh lu???n-->


									<div class="some-comments">
										<div class="user-img-container">
											<img class="user-img" src="img/avatar/avatar2.jpg">
										</div>
										<div class="main">
											<div class="user-name">
												<span>Nam</span> <span class="time-post">2h tr?????c</span>
											</div>

											<div class="textContent">
												<span>M??n ??n r???t ngon!!!</span>
											</div>
											<div class="vote">
												<i class="icon-thumbs-up-alt"></i> <span>28</span> <i
													class="icon-thumbs-down-alt"></i> <span>1</span> <span>Ph???n
													h???i</span>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section End -->

	<!-- footer section -->
	<footer class="footer_section">
		<div class="container">
			<div class="row">
				<div class="col-md-4 footer-col">
					<div class="footer_contact">
						<h4>Li??n h???</h4>
						<div class="contact_link_box">
							<a href=""> <i class="fa fa-map-marker" aria-hidden="true"></i>
								<span> V??? tr?? </span>
							</a> <a href=""> <i class="fa fa-phone" aria-hidden="true"></i> <span>
									+84 123456789 </span>
							</a> <a href=""> <i class="fa fa-envelope" aria-hidden="true"></i>
								<span> Email: lienhe@abcvietnam.com.vn </span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 footer-col">
					<div class="footer_detail">
						<a href="" class="footer-logo"> ABC Chicken </a>
						<p>C???a h??ng g?? r??n s??? 1 Vi???t Nam</p>
						<div class="footer_social">
							<a href=""> <i class="fa fa-facebook" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-twitter" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-linkedin" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-instagram" aria-hidden="true"></i>
							</a> <a href=""> <i class="fa fa-pinterest" aria-hidden="true"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 footer-col">
					<h4>Th???i gian ho???t ?????ng</h4>
					<p>M???i ng??y</p>
					<p>10:00 s??ng -10:00 t???i</p>
				</div>
			</div>
			<div class="footer-info">
				<p>
					&copy; <span id="displayYear"></span> All Rights Reserved By <a
						href="https://html.design/">Free Html Templates</a>
				</p>
			</div>
		</div>
	</footer>
	<!-- footer section -->


	<!-- Js Plugins -->
	<script
		src="${pageContext.request.contextPath}/view/web/js/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/jquery.nice-select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/jquery.slicknav.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/mixitup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/view/web/js/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/view/web/js/main.js"></script>


</body>

</html>