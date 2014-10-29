<script type="text/javascript">
	$(document).ready(function() {
		$('#UserEmailTableContainer').jtable({
			title : 'Table of userEmails',
			selecting : true, //Enable selecting 
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			sorting : true, //Enable sorting
			defaultSorting : 'Name ASC', //Set default sorting

			actions : {
				listAction : '/elibrary/ws/userEmail/listUserEmails',
				createAction : '/elibrary/ws/userEmail/createUserEmail',
				updateAction : '/elibrary/ws/userEmail/updateUserEmail',
				deleteAction : '/elibrary/ws/userEmail/deleteUserEmail'
			},
			fields : {
				emailId : {
					key : true,
					list : false
				},
				fromUserEmail : {
					title : 'fromUserEmail',
					type : 'email',
				},
				toUserEmail : {
					title : 'toUserEmail',
					type : 'email',
				},
				subject : {
					title : 'subject'
				},
				content : {
					title : 'content'
				},
				date : {
					title : 'date', 
					type : 'date'
				},
				alertType : {
					title : 'alertType'

				}
			}
		});

		$('#UserEmailTableContainer').jtable('load');
	});
</script>
