
<script type="text/javascript">
	function loadFilterColumns(val) {

		// Remove existing options from filterColumnName select box
		// Add * option to filterColumnName select box
		switch (val) {
		case 1:
			// bookTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var BookVar = [ "All", "Name", "Author", "Publication", "Status" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < BookVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = BookVar[i];
				opt.value = BookVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#BookTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()
				});
			});
			$('#LoadRecordsButton').click();
			break;
		case 2:
			// UserTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var UserVar = [ "Name", "subscription_plan", "Email",
					"favoruite_category1", "favoruite_category2" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < UserVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = UserVar[i];
				opt.value = UserVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#UserTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()

				});
			});
			$('#LoadRecordsButton').click();
			break;
		case 3:
			//SubscriptionTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var UserVar = [ "plan","rate" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < UserVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = UserVar[i];
				opt.value = UserVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#SubscriptionTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()

				});
			});
			$('#LoadRecordsButton').click();
			break;
		case 4:
			//UserSubscriptionTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var UserVar = [ "payment_by","received_by","cheque_of_bank" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < UserVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = UserVar[i];
				opt.value = UserVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#UserSubscriptionTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()

				});
			});
			$('#LoadRecordsButton').click();
			break;
		case 5:
			//BookRequestTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var UserVar = [ "status","book_name","admin_response" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < UserVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = UserVar[i];
				opt.value = UserVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#BookRequestTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()

				});
			});
			$('#LoadRecordsButton').click();
			break;
		case 6:
			//UserEmailTableContainer
			document.getElementById('filterColumnName').options.length = 0;
			var UserVar = [ "from_user_email","to_user_email","alert_type" ];
			var sel = document.getElementById('filterColumnName');
			for ( var i = 0; i < UserVar.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = UserVar[i];
				opt.value = UserVar[i];
				sel.appendChild(opt);
			}
			$('#LoadRecordsButton').click(function(e) {
				e.preventDefault();
				$('#UserEmailTableContainer').jtable('load', {
					filterColumnName : $('#filterColumnName').val(),
					filterColumnValue : $('#filterColumnValue').val()

				});
			});
			$('#LoadRecordsButton').click();

			break;
		case 7:
			//$("#ReportTableContainer").show();
			break;
		}
	};
</script>
<%@ include file="crud_book.jsp"%>
