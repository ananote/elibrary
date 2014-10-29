<script type="text/javascript">
	$(document).ready(function() {
		$('#UserTableContainer').jtable({
			title : 'Table of users',
			selecting : true, //Enable selecting 
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			sorting : true, //Enable sorting
			defaultSorting : 'Name ASC', //Set default sorting

			actions : {
				listAction : '/elibrary/ws/user/listUsers',
				createAction : '/elibrary/ws/user/createUser',
				updateAction : '/elibrary/ws/user/updateUser',
				deleteAction : '/elibrary/ws/user/deleteUser'
			},
			fields : {
				userId : {
					key : true,
					list : false
				},
				name : {
					title : 'name',
					inputclass : 'validate[required]'
				},
				address1 : {
					title : 'address1'
				},
				address2 : {
					title : 'address2'
				},
				bookIssue : {
					title : 'bookIssue'
				},
				bookIssueLimit : {
					title : 'bookIssueLimit'
				},
				city : {
					title : 'city'

				},
				currentSubscriptionid : {
					title : 'currentSubscriptionid'
				},
				email : {
					title : 'email',
					type : 'email',
					inputclass : 'validate[required]'
				},
				favoruiteCategory1 : {
					title : 'favoruiteCategory1',
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
				favoruiteCategory2 : {
					title : 'favoruiteCategory2',
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
				joinDate : {
					title : 'joinDate'
				},
				landline : {
					title : 'landline'
				},
				language : {
					title : 'language'
				},
				lastLogin : {
					title : 'lastLogin'
				},
				mobile : {
					title : 'mobile',
					inputclass : 'validate[required]'
				},
				password : {
					title : 'password',
					type : 'password',
					inputclass : 'validate[required]'
				},
				pin : {
					title : 'pin'
				},
				role : {
					title : 'role',
					inputclass : 'validate[required]',
					option : {
						'1' : 'Role_Admin',
						'2' : 'Role_Admin'
					}
				},
				subscriptionPlan : {
					title : 'subscriptionPlan'
				},
				totalBookIssued : {
					title : 'totalBookIssued'
				},
				username : {
					title : 'username',
					inputclass : 'validate[required]'
				},
				subscriptionEnddate : {
					title : 'subscriptionEnddate',
					create : false,
					edit : false
				}
			}
		});

		$('#UserTableContainer').jtable('load');
	});
</script>
