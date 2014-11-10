<script>
	function showBookRequests() {
		
		var bookRequestAPI = "/elibrary/ws/bookRequest/listUserBookRequests";
		var userid = <%=user.getUserId()%>;
		var jsonDataStr = 'userId='+userid+'&pageType=request';
		$.ajax({
			type : "GET",
			url : bookRequestAPI,
			contentType : "application/json",
			data : jsonDataStr,
			success : function(result) {
				var htmlCode = "";
				htmlCode = htmlCode + '<div class="container">';
				htmlCode = htmlCode + '  <h2>Book Requests</h2>';
				htmlCode = htmlCode + '  <table class="table table-bordered">';
				htmlCode = htmlCode + '    <thead>';
				htmlCode = htmlCode + '      <tr>';
				htmlCode = htmlCode + '        <th>Book Name</th>';
				htmlCode = htmlCode + '        <th>Issue Date</th>';
				htmlCode = htmlCode + '        <th>Days Book Issued</th>';
				htmlCode = htmlCode + '        <th>Status</th>';
				htmlCode = htmlCode + '      </tr>';
				htmlCode = htmlCode + '    </thead>';
				htmlCode = htmlCode + '    <tbody>';
				for ( var i = 0; i < result.length; i++) {
					htmlCode = htmlCode + '      <tr>';
					htmlCode = htmlCode + '        <td>'+result[i].bookName+'</td>';
					htmlCode = htmlCode + '        <td>'+result[i].issueDate+'</td>';
					htmlCode = htmlCode + '        <td>'+result[i].daysBookIssued+'</td>';
					htmlCode = htmlCode + '        <td>'+result[i].status+'</td>';
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
	
	function showMyShelf(userid) {
		<%-- var userid = <%=user.getUserId()%>; --%> 
		var bookRequestAPI = "/elibrary/ws/bookRequest/listUserBookRequests";
		
		$
		.getJSON(bookRequestAPI, {
			
			format : "json",
     		userId : userid,
     		pageType : "application/json"
		})
		.done(
				function(data) {
					var htmlCode = "";
					for ( var i = 0; i < data.length; i++) {

						htmlCode = htmlCode
								+ '<div class="mylib-entry"> <mylib-figure><img src="' + base_url +'/'+ data[i].bookImageUrl + '" alt="'+data[i].name+'" />';
						htmlCode = htmlCode + '<mylib-figcaption>'
									+ '<li class="active"><a href="javaScript:showBook(\''
									+ data[i].bookId + '\');"> '
									+ data[i].bookName + '</a></li>'
								+ '</mylib-figcaption> ';
						htmlCode = htmlCode
								+ '</mylib-figure> </div>';
					}
					var divs = document.getElementsByName("book_catalogue");
					divs[0].innerHTML = htmlCode;
					var divs2 = document.getElementsByName("table_container");
					divs2[0].innerHTML = "&nbsp;";
				});
	};
</script>