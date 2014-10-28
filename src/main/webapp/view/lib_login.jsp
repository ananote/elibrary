<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>MyLib</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${baseURL}/bcss/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="${baseURL}/bcss/styles.css" rel="stylesheet">

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="${baseURL}/bjs/bootstrap.min.js"></script>
<script src="${baseURL}/bjs/scripts.js"></script>
<style type="text/css">
.mylib-wrapper {
	width: 720px;
	margin: 0px auto;
}

.mylib-header {
	margin: 40px 0px 20px 0px;
}

.mylib-entry {
	width: 220px;
	float: left;
	margin: 10px;
	height: 218px;
	background-image: url("../img/shadow.png");
	background-repeat: no-repeat;
	background-position: bottom;
}

mylib-figure {
	display: block;
	width: 202px;
	height: 190px;
	background-color: #e7e3d8;
	margin: 0px;
	padding: 9px;
	text-align: center;
}

mylib-figure img {
	height: 150px;
	border: 1px solid #d6d6d6;
	display: block;
	margin-left: auto;
	margin-right: auto;
}

mylib-figcaption {
	background-image: url("../img/icon.png");
	padding-left: 20px;
	background-repeat: no-repeat;
	text-align: center;
}
</style>
</head>

<body>
	<div class="wrapper">
		<div class="box">
			<div class="row row-offcanvas row-offcanvas-left">

				<!-- sidebar -->
				<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">

					<ul class="nav">
						<li><a href="#" data-toggle="offcanvas"
							class="visible-xs text-center"><i
								class="glyphicon glyphicon-chevron-right"></i></a></li>
					</ul>

					<ul class="list-unstyled hidden-xs" id="sidebar-header">
						<li>
							<h3>Login to MyLib</h3>
						</li>
					</ul>
					<ul class="nav hidden-xs" id="lg-menu">
						<div name="author_list" id="author_list"></div>
					</ul>

					<ul class="list-unstyled hidden-xs" id="sidebar-footer">
						<li><a href="http://www.bootply.com"><h3>MyLib-Login</h3>
								<i class="glyphicon glyphicon-heart-empty"></i> Impetus</a></li>
					</ul>

				</div>
				<!-- /sidebar -->

				<!-- main right col -->
				<div class="column col-sm-10 col-xs-11" id="main">

					<!-- top nav -->
					<div class="navbar navbar-blue navbar-static-top">
						<nav class="collapse navbar-collapse" role="navigation">
							<ul class="nav navbar-nav">
								<li><h3>MyLib - Library Management Solution</h3></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="register_user.jsp"> SignUp</a></li>
							</ul>
						</nav>
					</div>
					<!-- /top nav -->

					<div class="padding">

						<div class="full col-sm-9">

							<!-- content -->
							<div class="row">

								<!-- main col left -->
								<div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4>Login</h4>
										</div>
										<div class="panel-body">
											<form method="POST" action="/elibrary/ws/login/loginuser">
												<center>
													<table border="0" width="30%" cellpadding="5">
														<thead>
															<tr>
																<th colspan="2">Login Here</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>User Name</td>
																<td><input type="text" name="username" /></td>
															</tr>
															<tr>
																<td>Password</td>
																<td><input type="password" name="password" /></td>
															</tr>
															<tr>
																<td colspan="2">
																<c:if test="${not empty errorMsg}">
  																	<font color="red">${errorMsg}</font>
																</c:if>
																</td>
															</tr>
															<tr>
																<td></td>
																<td><input type="submit" value="Login" /> <input
																	type="reset" value="Reset" /></td>
															</tr>
															<tr>
																<td colspan="2">Yet Not Registered!! <a
																	href="register_user.jsp"><b><font color="blue">
																				Register Here</font><b></a>
																</td>
															</tr>
														</tbody>
													</table>
												</center>
											</form>

											<hr>
										</div>
									</div>


								</div>
							</div>
							<!--/row-->

							<div class="row" id="footer">
								<div class="col-sm-6"></div>
								<div class="col-sm-6">
									<p>
										<a href="#" class="pull-right">Impetus©Copyright 2014</a>
									</p>
								</div>
							</div>

						</div>
						<!-- /col-9 -->
					</div>
					<!-- /padding -->
				</div>
				<!-- /main -->

			</div>
		</div>
	</div>

	<script>
		
	</script>
</body>
</html>
