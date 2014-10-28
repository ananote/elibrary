<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Master</title>

<link href="../../css/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
<link href="../../js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />

<script src="../../js/jquery-1.6.4.min.js" type="text/javascript"></script>
<script src="../../js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="../../js/jtable/jquery.jtable.js" type="text/javascript"></script>
<script src="../../js/jtable/external/json2.js" type="text/javascript"></script>

</head>

<body>
<H1>Ankit1</H1>
	<div id="UserTableContainer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#UserTableContainer').jtable({
				title : 'Table of users',
				selecting: true, //Enable selecting 
                paging: true, //Enable paging
                pageSize: 10, //Set page size (default: 10)
                sorting: true, //Enable sorting
				
				actions : {
					listAction : '/elibrary/ws/user/listUsers',
					createAction : '/elibrary/ws/user/createUser',
					updateAction : '/elibrary/ws/user/updateUser',
					deleteAction : '/elibrary/ws/user/deleteUser'
				},
				fields : {
					userId : {
						key : true,
						list : false
					},
					name : {
						title : 'name'
					},
					address1 : {
						title : 'address1'
					},
					address2 : {
						title : 'address2'
					},
					bookIssue : {
						title : 'bookIssue'
					},
					bookIssueLimit : {
						title : 'bookIssueLimit'
					},
					city : {
						title : 'city'
					},
					currentSubscriptionid : {
						title : 'currentSubscriptionid'
					},
					email : {
						title : 'email'
					},
					favoruiteCategory1 : {
						title : 'favoruiteCategory1'
					},
					favoruiteCategory2 : {
						title : 'favoruiteCategory2'
					},
					joinDate : {
						title : 'joinDate'
					},
					landline : {
						title : 'landline'
					},
					language : {
						title : 'language'
					},
					lastLogin : {
						title : 'lastLogin'
					},
					mobile : {
						title : 'mobile'
					},
					password : {
						title : 'password'
					},
					pin : {
						title : 'pin'
					},
					role : {
						title : 'role'
					},
					subscriptionPlan : {
						title : 'subscriptionPlan'
					},
					totalBookIssued : {
						title : 'totalBookIssued'
					},
					username : {
						title : 'username'
					},
					subscriptionEnddate : {
						title : 'subscriptionEnddate',
						create : false,
						edit : false
					}
				}
			});

			$('#UserTableContainer').jtable('load');
		});
	</script>
	
</body>
</html>