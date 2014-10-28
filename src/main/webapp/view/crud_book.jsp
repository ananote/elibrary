<script type="text/javascript">
	$(document).ready(function() {
		$('#BookTableContainer').jtable({
			title : 'Table of Books',
			selecting : true, //Enable selecting 
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			sorting : true, //Enable sorting
			defaultSorting : 'Name ASC', //Set default sorting

			actions : {
				listAction : '/elibrary/ws/book/listBooks',
				createAction : '/elibrary/ws/book/createBook',
				updateAction : '/elibrary/ws/book/updateBook',
				deleteAction : '/elibrary/ws/book/deleteBook'
			},
			fields : {
				bookId : {
					key : true,
					list : false
				},
				name : {
					title : 'name',
					inputclass : 'validate[required]'
				},
				category : {
					title : 'category',
					options : {
						'Science fiction' : 'Science fiction',
						'Satire' : 'Satire',
						'Drama' : 'Drama',
						'Romance' : 'Romance',
						'Mystery' : 'Mystery',
						'Horror' : 'Horror',
						'Self help' : 'Self help',
						'Guide' : 'Guide',
						'Travel' : 'Travel',
						'Kids' : 'Kids',
						'Religious' : 'Religious',
						'Science' : 'Science',
						'History' : 'History',
						'Maths' : 'Maths',
						'Anthologies' : 'Anthologies',
						'Poetry' : 'Poetry',
						'Encyclopaedia' : 'Encyclopaedia',
						'Dictionaries' : 'Dictionaries',
						'Comics' : 'Comics',
						'Art' : 'Art',
						'Cookbooks' : 'Cookbooks',
						'Diaries' : 'Diaries',
						'Journals' : 'Journals',
						'Prayer books' : 'Prayer books',
						'Series' : 'Series',
						'Trilogies' : 'Trilogies',
						'Biographies' : 'Biographies',
						'Autobiographies' : 'Autobiographies',
						'Fantasy' : 'Fantasy',
						'Technology' : 'Technology',
						'Computer' : 'Computer',
						'Programming' : 'Programming',
						'Quiz' : 'Quiz',
						'Games' : 'Games',
						'Sports' : 'Sports',
						'Geography' : 'Geography',
						'Java' : 'Java',
						'Oracle' : 'Oracle',
						'Microsoft' : 'Microsoft',
						'Mythology' : 'Mythology',
						'Literature' : 'Literature',
						'Fiction' : 'Fiction'
					},
					optionsSorting : 'text'
				},
				author : {
					title : 'author'
				},
				rating : {
					title : 'rating'
				},
				imageUrl : {
					title : 'imageUrl'

				},
				status : {
					title : 'status'
				},
				addDate : {
					title : 'addDate',
					type : 'date'
				},
				description : {
					title : 'description'
				},
				publication : {
					title : 'publication'
				},
				isbn : {
					title : 'isbn'
				},
				publishedYear : {
					title : 'publishedYear'
				},
				edition : {
					title : 'edition',
				},
				language : {
					title : 'language'
				}
			}
		});

		$('#BookTableContainer').jtable('load');
	});
</script>
