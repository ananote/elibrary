<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL"
	value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
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
	background-image: url("${baseURL}/img/shadow.png");
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
	background-image: url("${baseURL}/img/icon.png");
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
							<h3>User Registration</h3>
						</li>
					</ul>
					<ul class="list-unstyled hidden-xs" id="sidebar-footer">
						<li><h4>MyLib</h4> Impetus</li>
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
											<h4>Registration : Please enter the details asked</h4>
										</div>
										<div class="panel-body">

											<form action="/elibrary/ws/user/register" method="POST">
												<table>
													<tr>
														<td colspan="3"><font color="red">&nbsp;${error}</font></td>
													</tr>
													<tr>
														<td>First Name:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="first_name"></td>
													</tr>
													<tr>
														<td>Name:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Name"></td>
													</tr>
													<tr>
														<td>username:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="username" required="true"></td>
													</tr>
													<tr>
														<td>Password:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Password"></td>
													</tr>
													<tr>
														<td>email:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="email"></td>
													</tr>
													<tr>
														<td>address1:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="address1"></td>
													</tr>
													<tr>
														<td>address2:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="address2"></td>
													</tr>
													<tr>
														<td>City:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="City"></td>
													</tr>
													<tr>
														<td>Pin:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Pin"></td>
													</tr>
													<tr>
														<td>Mobile:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Mobile"></td>
													</tr>
													<tr>
														<td>Landline:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Landline"></td>
													</tr>
													<tr>
														<td>Favoruite_category1:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Favoruite_category1"></td>
													</tr>
													<tr>
														<td>Favoruite_category2:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Favoruite_category2"></td>
													</tr>
													<tr>
														<td>user_image_url:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="user_image_url"></td>
													</tr>
													<tr>
														<td>language:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="language"></td>
													</tr>
													<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
													<tr>
														<td></td>
														<td><input type="submit" value="Submit" /></td>
														<td><input type="reset" value="Reset" /></td>
													</tr>
												</table>
											</form>
											
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
