<script type="text/javascript">
	$(document).ready(function() {
		$('#SubscriptionTableContainer').jtable({
			title : 'Table of subscriptions',
			selecting : true, //Enable selecting 
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			sorting : true, //Enable sorting
			defaultSorting : 'Name ASC', //Set default sorting

			actions : {
				listAction : '/elibrary/ws/subscription/listSubscriptions',
				createAction : '/elibrary/ws/subscription/createSubscription',
				updateAction : '/elibrary/ws/subscription/updateSubscription',
				deleteAction : '/elibrary/ws/subscription/deleteSubscription'
			},
			fields : {
				subscriptionId : {
					key : true,
					list : false
				},
				plan : {
					title : 'plan',
					inputclass : 'validate[required]'
				},
				planName : {
					title : 'planName',
					inputclass : 'validate[required]'
				},
				bookLimit : {
					title : 'booklimit'
				},
				issueLimit : {
					title : 'issuelimit'
				},
				period : {
					title : 'period'
				},
				rate : {
					title : 'rate'
				}
			}
		});

		//$('#SubscriptionTableContainer').jtable('load');
	});
</script>