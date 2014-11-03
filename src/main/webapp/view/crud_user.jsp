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
				favoruiteCategory2 : {
					title : 'favoruiteCategory2',
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

		//$('#UserTableContainer').jtable('load');
	});
</script>
