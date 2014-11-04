<%@page import="java.util.List"%>
<%@page import="com.impetus.elibrary.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.impetus.elibrary.model.User"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.mylib-alignleft {
	float: left;
}

.mylib-alignright {
	float: right;
}

.mylib-aligncenter {
	float: center;
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
							<h3>MyLib</h3> <%
 	User user = (User) session.getAttribute("loggedin_user");
 %> <b>Welcome <%=user.getName()%></b> <br />
						</li>
					</ul>
					<ul class="nav hidden-xs" id="lg-menu">
						<!-- <div name="author_list" id="author_list"> </div> -->
						<h5>
							<a href="#">My Shelf</a>
						</h5>
						<h5>
							<a href="#">Book Issued</a>
						</h5>
						<h5>
							<a href="#">Request Book</a>
						</h5>
						<h5>
							<a>History</a>
						</h5>
						<h6>
							<a> </a><a href="#">Books</a>
						</h6>
						<h6>
							<a> </a><a href="#">Subscriptions</a>
						</h6>
						<h5>
							<a href="#">Profile</a>
						</h5>

					</ul>

					<ul class="list-unstyled hidden-xs" id="sidebar-footer">
						<li><h4>MyLib-User Home</h4> Impetus</li>
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
								<li><a class="mylib-alignright"
									href="${baseURL}/ws/login/logoutUser"> <font color="white">Signout</font></a></li>
							</ul>
						</nav>
					</div>
					<!-- /top nav -->

					<div class="padding">
						<div class="full">
							<form class="form">
								<div class="list-inline"
									style="max-width: 100%; text-align: right; float: left">
									<table>
										<tr>
											<td><input type="text" class="form-control"
												placeholder="Category" name="s_category" id="s_category" /></td>
											<td><input type="text" class="form-control"
												placeholder="Author" name="s_author" id="s_author" /></td>
											<td><input type="text" class="form-control"
												placeholder="Book name" name="s_name" id="s_name" /></td>
											<td>
												<div class="input-group-btn">
													<button class="btn btn-primary pull-right" type="button"
														onclick="listBySearch(s_name,s_author,s_category);">Search
													</button>

												</div>
											</td>
										</tr>
									</table>
								</div>
							</form>
						</div>

						<div class="full col-sm-9">

							<!-- content -->
							<div class="row">

								<!-- main col left -->
								<div>

									<div class="panel panel-default">
										<div class="panel-heading">
											<h4><%=user.getName()%> - Books for you!!!
											</h4>
										</div>
										<div class="panel-body">
											<div id="book_catalogue" name="book_catalogue"
												class="mylib-wrapper" />

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
		var base_url = "/elibrary";
		
		(function() {
			var fav_category = '<%=user.getFavoruiteCategory1()%>'+'\') or category=(\''+'<%=user.getFavoruiteCategory2()%>';
			var booksAPI = "/elibrary/ws/book/listBooks";
			$
					.getJSON(booksAPI, {
						jtStartIndex : "0",
						jtPageSize : "20",
						category : fav_category,
						format : "json"
					})
					.done(
							function(data) {
								var htmlCode = "";
								for ( var i = 0; i < data.length; i++) {

									htmlCode = htmlCode
											+ '<div class="mylib-entry"> <mylib-figure><img src="' + base_url + '/' + data[i].imageUrl + '" alt="'+data[i].name+'" />';
									htmlCode = htmlCode + '<mylib-figcaption>'
											+ data[i].name
											+ '</mylib-figcaption> ';
									htmlCode = htmlCode
											+ '</mylib-figure> ';
									htmlCode= htmlCode + '<br>'; 		
									htmlCode= htmlCode 
									+ '<input type="button" onclick="Function()" float="center">Interested</input> </div>';
								}
								var divs = document
										.getElementsByName("book_catalogue");
								divs[0].innerHTML = "";
								divs[0].innerHTML = htmlCode;

							});
		})();

		function listBySearch(s_name, s_author, s_category) {
			var name = document.getElementById("s_name").value;
			var author = document.getElementById("s_author").value;
			var category = document.getElementById("s_category").value;
			var booksAPI = "/elibrary/ws/book/listBooks";
			$
					.getJSON(booksAPI, {
						jtStartIndex : "0",
						jtPageSize : "20",
						name : name,
						author : author,
						category : category,
						format : "json"
					})
					.done(
							function(data) {
								var htmlCode = "";
								for ( var i = 0; i < data.length; i++) {

									htmlCode = htmlCode
											+ '<div class="mylib-entry"> <mylib-figure><img src="' + base_url +'/'+ data[i].imageUrl + '" alt="'+data[i].name+'" />';
									htmlCode = htmlCode + '<mylib-figcaption>'
											+ data[i].name
											+ '</mylib-figcaption> ';
									htmlCode = htmlCode
											+ '</mylib-figure> </div>';
								}
								var divs = document
										.getElementsByName("book_catalogue");
								divs[0].innerHTML = "";
								//alert(htmlCode);
								divs[0].innerHTML = htmlCode;

							});
		};
		
		 /* function getBookDetails(){
			var booksAPI="/elibaray/ws/book/getBook" 
			
		}; */
	</script>
</body>
</html>
