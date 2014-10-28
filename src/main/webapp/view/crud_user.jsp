
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
						'1' : 'Science fiction',
						'2' : 'Satire',
						'3' : 'Drama',
						'4' : 'Romance',
						'5' : 'Mystery',
						'6' : 'Horror',
						'7' : 'Self help',
						'8' : 'Guide',
						'9' : 'Travel',
						'10' : 'Kids',
						'11' : 'Religious',
						'12' : 'Science',
						'13' : 'History',
						'14' : 'Maths',
						'15' : 'Anthologies',
						'16' : 'Poetry',
						'17' : 'Encyclopaedia',
						'18' : 'Dictionaries',
						'19' : 'Comics',
						'20' : 'Art',
						'21' : 'Cookbooks',
						'22' : 'Diaries',
						'23' : 'Journals',
						'24' : 'Prayer books',
						'25' : 'Series',
						'26' : 'Trilogies',
						'27' : 'Biographies',
						'28' : 'Autobiographies',
						'29' : 'Fantasy',
						'30' : 'Technology',
						'31' : 'Computer',
						'32' : 'Programming',
						'33' : 'Quiz',
						'34' : 'Games',
						'35' : 'Sports',
						'36' : 'Geography',
						'37' : 'Java',
						'38' : 'Oracle',
						'39' : 'Microsoft',
						'40' : 'Mythology',
						'41' : 'Literature',
						'42' : 'Fiction'
					},
					optionsSorting : 'text'
				},
				favoruiteCategory2 : {
					title : 'favoruiteCategory2',
					options : {
						'1' : 'Science fiction',
						'2' : 'Satire',
						'3' : 'Drama',
						'4' : 'Romance',
						'5' : 'Mystery',
						'6' : 'Horror',
						'7' : 'Self help',
						'8' : 'Guide',
						'9' : 'Travel',
						'10' : 'Kids',
						'11' : 'Religious',
						'12' : 'Science',
						'13' : 'History',
						'14' : 'Maths',
						'15' : 'Anthologies',
						'16' : 'Poetry',
						'17' : 'Encyclopaedia',
						'18' : 'Dictionaries',
						'19' : 'Comics',
						'20' : 'Art',
						'21' : 'Cookbooks',
						'22' : 'Diaries',
						'23' : 'Journals',
						'24' : 'Prayer books',
						'25' : 'Series',
						'26' : 'Trilogies',
						'27' : 'Biographies',
						'28' : 'Autobiographies',
						'29' : 'Fantasy',
						'30' : 'Technology',
						'31' : 'Computer',
						'32' : 'Programming',
						'33' : 'Quiz',
						'34' : 'Games',
						'35' : 'Sports',
						'36' : 'Geography',
						'37' : 'Java',
						'38' : 'Oracle',
						'39' : 'Microsoft',
						'40' : 'Mythology',
						'41' : 'Literature',
						'42' : 'Fiction'
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
