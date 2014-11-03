<script type="text/javascript">
	$(document).ready(function() {
		$('#BookRequestTableContainer').jtable({
			title : 'Table of Book Requests',
			selecting : true, //Enable selecting 
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			sorting : true, //Enable sorting
			defaultSorting : 'Name ASC', //Set default sorting

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
					options : {
						'Unshelfed' : 'Unshelfed',
						'Shelfed' : 'Shelfed',
						'Requested' : 'Requested',
						'Cancelled' : 'Cancelled',
						'Ready' : 'Ready',
						'Issued' : 'Issued',
						'Request_Return' : 'Request_Return',
						'Returned' : 'Returned'
					}
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
				},
				updateTimestamp : {
					title : 'updateTimestamp',
					type: 'datetime',
					displayFormat: 'd/m/Y H:i'
				},
				adminResponse : {
					title : 'adminResponse'
					
				}
				
			}
		});

		$('#BookRequestTableContainer').jtable('load');
	});
</script>
