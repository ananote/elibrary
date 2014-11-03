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
						'Anthologies' : 'Anthologies',
						'Art' : 'Art',
						'Autobiographies' : 'Autobiographies',
						'Biographies' : 'Biographies',
						'Comics' : 'Comics',
						'Computer' : 'Computer',
						'Cookbooks' : 'Cookbooks',
						'Diaries' : 'Diaries',
						'Dictionaries' : 'Dictionaries',
						'Drama' : 'Drama',
						'Encyclopaedia' : 'Encyclopaedia',
						'Fantasy' : 'Fantasy',
						'Fiction' : 'Fiction',
						'Games' : 'Games',
						'Geography' : 'Geography',
						'Guide' : 'Guide',
						'History' : 'History',
						'Horror' : 'Horror',
						'Java' : 'Java',
						'Journals' : 'Journals',
						'Kids' : 'Kids',
						'Literature' : 'Literature',
						'Maths' : 'Maths',
						'Microsoft' : 'Microsoft',
						'Mystery' : 'Mystery',
						'Mythology' : 'Mythology',
						'Oracle' : 'Oracle',
						'Poetry' : 'Poetry',
						'Prayer books' : 'Prayer books',
						'Programming' : 'Programming',
						'Quiz' : 'Quiz',
						'Religious' : 'Religious',
						'Romance' : 'Romance',
						'Satire' : 'Satire',
						'Science' : 'Science',
						'Science fiction' : 'Science fiction',
						'Self help' : 'Self help',
						'Series' : 'Series',
						'Sports' : 'Sports',
						'Technology' : 'Technology',
						'Travel' : 'Travel',
						'Trilogies' : 'Trilogies'
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
	});
</script>
