
<script type="text/javascript">
	function loadFilterColumns(val) {

		// Remove existing options from filterColumnName select box
		// Add * option to filterColumnName select box
		switch (val) {
		case 1:
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
			document.getElementById('filterColumnName').options.length = 0;
			// UserTableContainer
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
			//$("#SubscriptionTableContainer").show();
			break;
		case 4:
			//$("#UserSubscriptionTableContainer").show();
			break;
		case 5:
			//$("#BookRequestTableContainer").show();
			break;
		case 6:
			//$("#UserEmailTableContainer").show();
			break;
		case 7:
			//$("#ReportTableContainer").show();
			break;
		}
	};
</script>
<%@ include file="crud_book.jsp"%>
