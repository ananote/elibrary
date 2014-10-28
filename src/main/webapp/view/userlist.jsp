<!DOCTYPE html>
<html>
<head>
<title>ToDo API Client Demo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
<script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.js"></script>
<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/knockout/knockout-2.2.1.js"></script>
</head>
<body>
    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="#">User Master</a>
        </div>
    </div>
    <div id="main" class="container">
        <table class="table table-striped">
            <tr><td style="width: 1px;"></td><td colspan="3"><b>User</b></td><td><b>Options</b></td></tr>
            <tr>
                <td><p><b>Name</b></p></td>
                <td><p><b>Address</b></p></td>
                <td><p><b>Email</b></p></td>
                <td><p><b>City</b></p></td>
            </tr>
            <!-- ko foreach: users -->
            <tr>
                <td><p data-bind="text: name"></p></td>
                <td><p data-bind="text: address1"></p></td>
                <td><p data-bind="text: email"></p></td>
                <td><p data-bind="text: city"></p></td>
                <td>
                    <button data-bind="click: $parent.beginEdit" class="btn">Edit</button>
                    <button data-bind="click: $parent.remove" class="btn">Delete</button>
                </td>
            </tr>
            <!-- /ko -->
        </table>
        <button data-bind="click: beginAdd" class="btn">Add User</button>
    </div>
    <script type="text/javascript">
        function UsersViewModel() {
            var self = this;
            self.usersURI = '/elibrary/ws/users/data';
            self.username = "miguel";
            self.password = "python";
            self.users = ko.observableArray();

            self.ajax = function(uri, method, data) {
                var request = {
                    url: uri,
                    type: method,
                    contentType: "application/json",
                    accept: "application/json",
                    cache: false,
                    dataType: 'json',
                    data: JSON.stringify(data),
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", 
                            "Basic " + btoa(self.username + ":" + self.password));
                    },
                    error: function(jqXHR) {
                        console.log("ajax error " + jqXHR.status);
                    }
                };
                return $.ajax(request);
            }

            self.beginAdd = function() {
                alert("Add");
            }
            self.beginEdit = function(user) {
                alert("Edit: " + user.name());
            }
            self.remove = function(user) {
                alert("Remove: " + user.name());
            }
            self.markInProgress = function(user) {
                //user.done(false);
            }
            self.markDone = function(user) {
                //user.done(true);
            }
            
            self.ajax(self.usersURI, 'GET').done(function(data) {
                for (var i = 0; i < data.users.length; i++) {
                    self.users.push({
                    	name: ko.observable(data.users[i].name),
                    	address1: ko.observable(data.users[i].address1),
                        email: ko.observable(data.users[i].email),
                        city: ko.observable(data.users[i].city)
                        
                    	/*uri: ko.observable(data.users[i].uri),
                        title: ko.observable(data.users[i].title),
                        description: ko.observable(data.users[i].description),
                        done: ko.observable(data.users[i].done)*/
                    });
                }
            });
        }
        
        //$().ready(function() {
            ko.applyBindings(new UsersViewModel(), $('#main')[0]);
        //});
    </script>
</body>
</html>