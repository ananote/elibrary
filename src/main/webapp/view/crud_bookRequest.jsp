<%@ include file="crud_header.jsp" %> 
<body>
	<div id="BookRequestTableContainer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#BookRequestTableContainer').jtable({
				title : 'Table of Book Requests',
				selecting: true, //Enable selecting 
                paging: true, //Enable paging
                pageSize: 10, //Set page size (default: 10)
                sorting: true, //Enable sorting
                defaultSorting: 'Name ASC', //Set default sorting
                
				actions : {
					listAction : '/elibrary/ws/bookRequest/listBookRequests',
					createAction : '/elibrary/ws/bookRequest/createBookRequest',
					updateAction : '/elibrary/ws/bookRequest/updateBookRequest',
					deleteAction : '/elibrary/ws/bookRequest/deleteBookRequest'
				},
				fields : {
					requestId : {
						key : true,
						list : false
					},
					book : {
						title : 'book'
					},
					user : {
						title : 'user'
					},
					status : {
						title : 'status',
						options : {'1':'Unshelfed', '2':'Shelfed', '3':'Requested', '4':'Cancelled', '5':'Ready', '6':'Issued', '7':'Request_Return', '8':'Returned'}
					},
					bookName : {
						title : 'bookName'
					},
					requestDate : {
						title : 'requestDate',
						type : 'date'
					},
					issueDate : {
						title : 'issueDate',
						type : 'date'
												
					},
					returnRequestDate : {
						title : 'returnRequestDate',
						type : 'date'
												
					},
					returnDate : {
						title : 'returnDate',
						type : 'date'
												
					},
					cancelDate : {
						title : 'cancelDate',
						type : 'date'
												
					},
					daysBookIssued : {
						title : 'daysBookIssued'
					}
				}
			});

			$('#BookRequestTableContainer').jtable('load');
		});
	</script>
</body>
<%@ include file="crud_footer.jsp" %>
