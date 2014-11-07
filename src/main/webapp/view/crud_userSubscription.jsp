<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#UserSubscriptionTableContainer')
								.jtable(
										{
											title : 'Table of userSubscriptions',
											selecting : true, //Enable selecting 
											paging : true, //Enable paging
											pageSize : 10, //Set page size (default: 10)
											sorting : true, //Enable sorting
											defaultSorting : 'Name ASC', //Set default sorting

											actions : {
												listAction : '/elibrary/ws/userSubscription/listUserSubscriptions',
												createAction : '/elibrary/ws/userSubscription/createUserSubscription',
												updateAction : '/elibrary/ws/userSubscription/updateUserSubscription',
												deleteAction : '/elibrary/ws/userSubscription/deleteUserSubscription'
											},
											fields : {
												userSubscriptionId : {
													key : true,
													list : false
												},
												user : {
													title : 'user'
												},
												subscription : {
													title : 'subscription'
												},
												startDate : {
													title : 'startDate',
													type : 'date'
												},
												alertDate : {
													title : 'alertDate',
													type : 'date'
												},
												endDate : {
													title : 'endDate',
													type : 'date'
												},
												paymentBy : {
													title : 'paymentBy'

												},
												paymentReceived : {
													title : 'paymentReceived'
												},
												receivedBy : {
													title : 'receivedBy'
												},
												receivedDate : {
													title : 'receivedDate',
													type : 'date'
												},
												chequeOfBank : {
													title : 'chequeOfBank'
												},
												chequeNendumber : {
													title : 'chequeNendumber'
												},
												amount : {
													title : 'amount'
												}
											}
										});

						//$('#UserSubscriptionTableContainer').jtable('load');
					});
</script>
