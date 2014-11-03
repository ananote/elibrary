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
														<td>Name:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="Name"></td>
													</tr>
													<tr>
														<td>Username:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="username"
															required="true"></td>
													</tr>
													<tr>
														<td>Password:</td>
														<td>&nbsp;</td>
														<td><input type="password" name="Password"></td>
													</tr>
													<tr>
														<td>Email:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="email"></td>
													</tr>
													<tr>
														<td>Address Line1:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="address1"></td>
													</tr>
													<tr>
														<td>Address Line2:</td>
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
														<td>Favoruite Category 1:</td>
														<td>&nbsp;</td>
														<td><select name="favoruiteCategory1">
																<option value="Anthologies" selected>Anthologies</option>
																<option value="Art">Art</option>
																<option value="Autobiographies">Autobiographies</option>
																<option value="Aiographies">Biographies</option>
																<option value="Comics">Comics</option>
																<option value="Computer">Computer</option>
																<option value="Cookbooks">Cookbooks</option>
																<option value="Diaries">Diaries</option>
																<option value="Dictionaries">Dictionaries</option>
																<option value="Drama">Drama</option>
																<option value="Encyclopaedia">Encyclopaedia</option>
																<option value="Fantasy">Fantasy</option>
																<option value="Fiction">Fiction</option>
																<option value="Games">Games</option>
																<option value="Geography">Geography</option>
																<option value="Guide">Guide</option>
																<option value="History">History</option>
																<option value="Horror">Horror</option>
																<option value="Java">Java</option>
																<option value="Journals">Journals</option>
																<option value="Kids">Kids</option>
																<option value="Literature">Literature</option>
																<option value="Maths">Maths</option>
																<option value="Microsoft">Microsoft</option>
																<option value="Mystery">Mystery</option>
																<option value="Mythology">Mythology</option>
																<option value="Oracle">Oracle</option>
																<option value="Poetry">Poetry</option>
																<option value="Prayer books">Prayer Books</option>
																<option value="Programming">Programming</option>
																<option value="Quiz">Quiz</option>
																<option value="Religious">Religious</option>
																<option value="Romance">Romance</option>
																<option value="Satire">Satire</option>
																<option value="Science">Science</option>
																<option value="Science fiction">Science fiction</option>
																<option value="Self help">Self help</option>
																<option value="Series">Series</option>
																<option value="Sports">Sports</option>
																<option value="Technology">Technology</option>
																<option value="Travel">Travel</option>
																<option value="Trilogies">Trilogies</option>
														</select></td>
													</tr>
													<tr>
														<td>Favoruite Category 2:</td>
														<td>&nbsp;</td>
														<td><select name="favoruiteCategory2">
																<option value="Anthologies" selected>Anthologies</option>
																<option value="Art">Art</option>
																<option value="Autobiographies">Autobiographies</option>
																<option value="Aiographies">Biographies</option>
																<option value="Comics">Comics</option>
																<option value="Computer">Computer</option>
																<option value="Cookbooks">Cookbooks</option>
																<option value="Diaries">Diaries</option>
																<option value="Dictionaries">Dictionaries</option>
																<option value="Drama">Drama</option>
																<option value="Encyclopaedia">Encyclopaedia</option>
																<option value="Fantasy">Fantasy</option>
																<option value="Fiction">Fiction</option>
																<option value="Games">Games</option>
																<option value="Geography">Geography</option>
																<option value="Guide">Guide</option>
																<option value="History">History</option>
																<option value="Horror">Horror</option>
																<option value="Java">Java</option>
																<option value="Journals">Journals</option>
																<option value="Kids">Kids</option>
																<option value="Literature">Literature</option>
																<option value="Maths">Maths</option>
																<option value="Microsoft">Microsoft</option>
																<option value="Mystery">Mystery</option>
																<option value="Mythology">Mythology</option>
																<option value="Oracle">Oracle</option>
																<option value="Poetry">Poetry</option>
																<option value="Prayer books">Prayer Books</option>
																<option value="Programming">Programming</option>
																<option value="Quiz">Quiz</option>
																<option value="Religious">Religious</option>
																<option value="Romance">Romance</option>
																<option value="Satire">Satire</option>
																<option value="Science">Science</option>
																<option value="Science fiction">Science fiction</option>
																<option value="Self help">Self help</option>
																<option value="Series">Series</option>
																<option value="Sports">Sports</option>
																<option value="Technology">Technology</option>
																<option value="Travel">Travel</option>
																<option value="Trilogies">Trilogies</option>
														</select></td>
													</tr>
													<tr>
														<td>User Image:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="user_image_url"></td>
													</tr>
													<tr>
														<td>Language:</td>
														<td>&nbsp;</td>
														<td><input type="text" name="language"></td>
													</tr>
													<tr>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
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
