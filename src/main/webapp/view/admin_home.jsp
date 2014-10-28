<%@ include file="crud_header.jsp"%>
<style>
#mylib-header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#mylib-nav {
	line-height: 30px;
	background-color: #eeeeee;
	width: 210px;
	float: left;
	padding: 5px;
}

#mylib-section {
	width: 350px;
	float: left;
	padding: 10px;
}

#mylib-footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
<body>

	<div id="mylib-header">
		<h1>My Library - Admin Pages</h1>
	</div>

	<div id="mylib-nav">
		<ul id="menu" style="width: 200px;">
			<li><a href="#">Spring</a></li>
			<li><a href="#">Spring</a></li>
			<li><a href="#">Reports</a>
				<ul>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
				</ul></li>
			<li><a href="#">Spring</a></li>
			<li><a href="#">Spring</a></li>
		</ul>
	</div>

	<div id="mylib-section">
		<h1>CRUD</h1>
		<p>CRUD is the CRUD.</p>
		<div id="BookTableContainer"></div>
		<div id="UserTableContainer"></div>
	</div>

	<div id="mylib-footer">Copyright © Impetus.com</div>




	<script type="text/javascript">
		$("#menu").menu();
		$("#UserTableContainer").hide();
	</script>
	<%@ include file="crud_book.jsp"%>
	<%@ include file="crud_user.jsp"%>
</body>
<%@ include file="crud_footer.jsp"%>
