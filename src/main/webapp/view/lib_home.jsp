<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>MyLib</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../bcss/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<link href="../bcss/styles.css" rel="stylesheet">

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="../bjs/bootstrap.min.js"></script>
<script src="../bjs/scripts.js"></script>
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
							<h3>Authors</h3>
						</li>
					</ul>
					<ul class="nav hidden-xs" id="lg-menu">
						<li class="active"><a href="#featured"> <i
								class="glyphicon glyphicon-list-alt"></i> James Gosling
						</a></li>
					</ul>

					<ul class="list-unstyled hidden-xs" id="sidebar-footer">
						<li><a href="http://www.bootply.com"><h3>MyLib</h3> <i
								class="glyphicon glyphicon-heart-empty"></i> Impetus</a></li>
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
								<li><a href="#"> Home</a></li>
								<li><a href="#"> SignUp</a></li>
								<li><a href="#"> Login</a></li>
							</ul>
						</nav>
					</div>
					<!-- /top nav -->

					<div class="padding">

						<div class="full">
							<form class="form">
								<div class="list-inline"
									style="max-width: 360px; text-align: right;">
									<p>
										<input type="text" class="form-control" placeholder="Category"
											name="srch-term" id="srch-term" /> <input type="text"
											class="form-control" placeholder="Author" name="srch-term"
											id="srch-term" /> <input type="text" class="form-control"
											placeholder="Book name" name="srch-term" id="srch-term" />
									</p>
									<div class="input-group-btn">
										<button class="btn btn-primary pull-right" type="submit">Search
										</button>
									</div>
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
											<h4>Books</h4>
										</div>
										<div class="panel-body">
											<div class="list-inline ">

												<table>
													<tr>
														<td><img height="100px;" alt="book-image"
															src="../img/Gitanjali.jpg" /> <br />Title: Rabindra <br />Author:
															Rabindra</td>
														<td><img height="100px;" alt="book-image"
															src="../img/Java2_TheCompleteReference5Edition.jpg" /> <br />Title:
															The Complete Reference - Java <br />Author: Herbert
															Schieldt</td>
														<td><img height="100px;" alt="book-image"
															src="../img/Gitanjali.jpg" /> <br />Title: Rabindra <br />Author:
															Rabindra</td>
														<td><img height="100px;" alt="book-image"
															src="../img/Java2_TheCompleteReference5Edition.jpg" /> <br />Title:
															The Complete Reference - Java <br />Author: Herbert
															Schieldt</td>
													</tr>
												</table>

											</div>
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


	<!--post modal-->
	<div id="postModal" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">Ã—</button>
					Update Status
				</div>
				<div class="modal-body">
					<form class="form center-block">
						<div class="form-group">
							<textarea class="form-control input-lg" autofocus=""
								placeholder="What do you want to share?"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div>
						<button class="btn btn-primary btn-sm" data-dismiss="modal"
							aria-hidden="true">Post</button>
						<ul class="pull-left list-inline">
							<li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li>
							<li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li>
							<li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
