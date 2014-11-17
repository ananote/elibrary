<script>
	function showSubscriptions() {
		
		var bookRequestAPI = "/elibrary/ws/subscription/listSubscriptions";
		$.ajax({
			type : "GET",
			url : bookRequestAPI,
			contentType : "application/json",
			success : function(result) {
				var htmlCode = "";
				htmlCode = htmlCode + '<div class="container">';
				htmlCode = htmlCode + '  <h2>Book Requests</h2>';
				htmlCode = htmlCode + '  <table class="table table-bordered">';
				htmlCode = htmlCode + '    <thead>';
				htmlCode = htmlCode + '      <tr>';
				htmlCode = htmlCode + '        <th width="1%" style="text-align:center">Select</th>';
				htmlCode = htmlCode + '        <th width="2%" style="text-align:center">Plan Name</th>';
				htmlCode = htmlCode + '        <th width="1%" style="text-align:center">Rate</th>';
				htmlCode = htmlCode + '        <th width="1%" style="text-align:center">Period(Days)</th>';
				htmlCode = htmlCode + '        <th width="1%" style="text-align:center">Book Limit</th>';
				htmlCode = htmlCode + '        <th width="1%" style="text-align:center">Max Book at a Time</th>';
				htmlCode = htmlCode + '      </tr>';
				htmlCode = htmlCode + '    </thead>';
				htmlCode = htmlCode + '    <tbody>';
				for ( var i = 0; i < result.length; i++) {
					htmlCode = htmlCode + '      <tr>';
					htmlCode = htmlCode + '        <td align="center"><input type="radio" name="subscription" value="'+result[i].subscrptionId+'"> </td>';
					htmlCode = htmlCode + '        <td align="center">'+result[i].planName+'</td>';
					htmlCode = htmlCode + '        <td align="center">'+result[i].rate+'</td>';
					htmlCode = htmlCode + '        <td align="center">'+result[i].period+'</td>';
					htmlCode = htmlCode + '        <td align="center">'+result[i].bookLimit+'</td>';
					htmlCode = htmlCode + '        <td align="center">'+result[i].issueLimit+'</td>';
					htmlCode = htmlCode + '      </tr>';
				}
				htmlCode = htmlCode + '   </tbody>';
				htmlCode = htmlCode + '  </table>';
				htmlCode = htmlCode + '</div>';
				var divs = document.getElementsByName("book_catalogue");
				divs[0].innerHTML = "&nbsp;";
				var divs2 = document.getElementsByName("table_container");
				divs2[0].innerHTML = htmlCode;
			},
			error : function(jqXHR, textStatus, errorThrown) {
				var htmlCode = '';
				htmlCode = htmlCode + '<br><font color="Red">' +
					"jqXHR statusCode" + jqXHR.statusCode() + 
					"textStatus " + textStatus +
					"errorThrown " + errorThrown +
					'</font>';
				htmlCode = htmlCode
					+ '<br><hr> <a href="/elibrary/view/user_home.jsp"><b><font color=blue>Back Home</font></b></a>';
			
				var divs = document
						.getElementsByName("status_panel");
				//divs[0].innerHTML = "";
				divs[0].innerHTML = htmlCode;
			}
		});
	};
	
	//function registerSubscriptions() 
	
</script>