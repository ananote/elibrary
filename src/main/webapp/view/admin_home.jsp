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
<body onload="showCrud(1)">

	<div id="mylib-header">
		<a class="mylib-alignright" href="${baseURL}/ws/login/logoutUser"><font color="white">Signout</font></a>
		<h1 class="mylib-aligncenter">My Library - Admin Pages</h1>
		
	</div>

	<div id="mylib-nav">
		<ul id="menu" style="width: 200px;">
			<li><a href="#" onclick="showCrud(1)">Books</a></li>
			<li><a href="#" onclick="showCrud(2)">Users</a></li>
			<li><a href="#" onclick="showCrud(3)">Subscriptions</a></li>
			<li><a href="#" onclick="showCrud(4)">UserSubscriptions</a></li>
			<li><a href="#" onclick="showCrud(5)">Book Requests</a></li>
			<li><a href="#" onclick="showCrud(6)">Emails</a></li>
			<li><a href="#" onclick="showCrud(7)">Reports</a>
				<ul>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
					<li><a href="#">Spring</a></li>
				</ul></li>
		</ul>
	</div>

	<div id="mylib-section">
		<h4> MyLib CRUD Operations </h4>
		<div id="BookTableContainer"></div>
		<div id="UserTableContainer"></div>
		<div id="SubscriptionTableContainer"></div>
		<div id="UserSubscriptionTableContainer"></div>
		<div id="BookRequestTableContainer"></div>
		<div id="UserEmailTableContainer"></div>
	</div>

	<div id="mylib-footer">Copyright © Impetus.com</div>

	<script type="text/javascript">
		$("#menu").menu();
		
		function showCrud (val) {
			$("#BookTableContainer").hide();
			$("#UserTableContainer").hide();
			$("#SubscriptionTableContainer").hide();
			$("#UserSubscriptionTableContainer").hide();
			$("#BookRequestTableContainer").hide();
			$("#UserEmailTableContainer").hide();
			//alert(val);
			switch (val)
			{
				case 1: $("#BookTableContainer").show();
				break;
				case 2: $("#UserTableContainer").show();
				break;
				case 3: $("#SubscriptionTableContainer").show();
				break;
				case 4: $("#UserSubscriptionTableContainer").show();
				break;
				case 5: $("#BookRequestTableContainer").show();
				break;
				case 6: $("#UserEmailTableContainer").show();
				break;
				case 7: $("#ReportTableContainer").show();
				break;
			}
						};
			
	</script>
	<%@ include file="crud_book.jsp"%>
	<%@ include file="crud_user.jsp"%>
	<%@ include file="crud_subscription.jsp"%>
	<%@ include file="crud_userSubscription.jsp"%>
	<%@ include file="crud_bookRequest.jsp"%>
	<%@ include file="crud_userEmail.jsp"%>
</body>
<%@ include file="crud_footer.jsp"%>
