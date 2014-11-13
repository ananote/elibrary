var base_url = "/elibrary";

function showBook(bookId) {
	var booksAPI = "/elibrary/ws/book/getBook/" + bookId;

	$
			.getJSON(booksAPI, {
				format : "json"
			})
			.done(
					function(data) {
						var htmlCode = "";
						htmlCode = htmlCode
								+ '<div class="show-image"><img src="'
								+ base_url + '/' + data.imageUrl + '" alt="'
								+ data.name + '" />';
						htmlCode = htmlCode + '<li> Title : ' + data.name
								+ '</li> ';
						htmlCode = htmlCode + '<li> Author : ' + data.author
								+ '</li> ';
						htmlCode = htmlCode + '<li> Category : '
								+ data.category + '</li> ';
						htmlCode = htmlCode + '<li> Description : '
								+ data.description + '</li> ';
						htmlCode = htmlCode + '<li> Publication : '
								+ data.publication + '</li> ';
						htmlCode = htmlCode + '<li> ISBN : ' + data.ISBN
								+ '</li> ';
						htmlCode = htmlCode + '<li> Status : ' + data.status
								+ '</li> ';
						htmlCode = htmlCode + '<li> Language : '
								+ data.Language + '</li> ';
						htmlCode = htmlCode
								+ '<br><hr> <a href="/elibrary"><b><font color=blue>Back Home</font></b></a>';
						htmlCode = htmlCode + ' </div>';

						var divs = document.getElementsByName("book_catalogue");
						divs[0].innerHTML = "";
						divs[0].innerHTML = htmlCode;

					});
};

function listAllBooks() {
	var booksAPI = "/elibrary/ws/book/listBooks";
	$
			.getJSON(booksAPI, {
				jtStartIndex : "0",
				jtPageSize : "20",
				format : "json"
			})
			.done(
					function(data) {
						var htmlCode = "";
						for (var i = 0; i < data.length; i++) {

							htmlCode = htmlCode
									+ '<div class="mylib-entry"> <mylib-figure><img src="'
									+ base_url + '/' + data[i].imageUrl
									+ '" alt="' + data[i].name + '" />';
							htmlCode = htmlCode
									+ '<mylib-figcaption>'
									+ '<li class="active"><a href="javaScript:showBook(\''
									+ data[i].bookId + '\');"> ' + data[i].name
									+ '</a></li>' + '</mylib-figcaption> ';
							htmlCode = htmlCode + '</mylib-figure> </div>';
						}
						var divs = document.getElementsByName("book_catalogue");
						divs[0].innerHTML = "";
						// alert(htmlCode);
						divs[0].innerHTML = htmlCode;

					});
}

function listAllAuthors() {
	var booksAPI = "/elibrary/ws/book/listAllAuthors";
	$
			.getJSON(booksAPI, {
				jtStartIndex : "0",
				jtPageSize : "20",
				format : "json"
			})
			.done(
					function(data) {
						var htmlCode = "";
						for (var i = 0; i < data.length; i++) {

							htmlCode = htmlCode
									+ '<li class="active"><a href="javaScript:listByAuthor(\''
									+ data[i].author + '\');"> '
									+ data[i].author + '</a></li>';
						}
						var divs = document.getElementsByName("author_list");
						divs[0].innerHTML = "";
						// alert(htmlCode);
						divs[0].innerHTML = htmlCode;

					});
}

function listByAuthor(author) {
	var booksAPI = "/elibrary/ws/book/listBooks";
	$
			.getJSON(booksAPI, {
				jtStartIndex : "0",
				jtPageSize : "20",
				author : author,
				format : "json"
			})
			.done(
					function(data) {
						var htmlCode = "";
						for (var i = 0; i < data.length; i++) {

							htmlCode = htmlCode
									+ '<div class="mylib-entry"> <mylib-figure><img src="'
									+ base_url + '/' + data[i].imageUrl
									+ '" alt="' + data[i].name + '" />';
							
							htmlCode = htmlCode + '<mylib-figcaption>'
							+ '<li class="active"><a href="javaScript:showBook(\''
							+ data[i].bookId + '\');"> '
							+ data[i].name + '</a></li>'
						+ '</mylib-figcaption> ';
							htmlCode = htmlCode + '</mylib-figure> </div>';
						}
						var divs = document.getElementsByName("book_catalogue");
						divs[0].innerHTML = "";
						// alert(htmlCode);
						divs[0].innerHTML = htmlCode;

					});
};

function listBySearch(s_name, s_author, s_category) {
	var name = document.getElementById("s_name").value;
	var author = document.getElementById("s_author").value;
	var category = document.getElementById("s_category").value;
	var booksAPI = "/elibrary/ws/book/listBooks";
	$
			.getJSON(booksAPI, {
				jtStartIndex : "0",
				jtPageSize : "20",
				name : name,
				author : author,
				category : category,
				format : "json"
			})
			.done(
					function(data) {
						var htmlCode = "";
						for (var i = 0; i < data.length; i++) {

							htmlCode = htmlCode
									+ '<div class="mylib-entry"> <mylib-figure><img src="'
									+ base_url + '/' + data[i].imageUrl
									+ '" alt="' + data[i].name + '" />';
							
							htmlCode = htmlCode + '<mylib-figcaption>'
							+ '<li class="active"><a href="javaScript:showBook(\''
							+ data[i].bookId + '\');"> '
							+ data[i].name + '</a></li>'
						+ '</mylib-figcaption> ';
							htmlCode = htmlCode + '</mylib-figure> </div>';
						}
						var divs = document.getElementsByName("book_catalogue");
						divs[0].innerHTML = "";
						// alert(htmlCode);
						divs[0].innerHTML = htmlCode;

					});
};