/*creating database */

create database if not exists mylib /*!40100 default character set latin1 */;  

/*changing the database to mylib*/
use mylib;  

/* creating table books */
create table if not exists books		
(
book_id integer auto_increment, 
name varchar(300) not null,
category varchar(50) not null,
author varchar(100),
rating varchar(10),
image_url varchar(300),
status varchar(10),
add_date date,
description varchar(500),
publication varchar(100),
isbn varchar(50),
published_year varchar(5),
edition varchar(5),
language varchar(50),
primary key (book_id)
)
engine=myisam auto_increment=6 default charset=latin1;

/* creating table subscription */
create table if not exists subscriptions
(
subscription_id integer auto_increment,
plan varchar(15) not null,
plan_name varchar(100),
book_limit smallint,
issue_limit smallint,
period smallint,
rate smallint,
primary key (subscription_id), 
constraint uk_subs_plan unique key  (plan)
)
engine=myisam auto_increment=6 default charset=latin1;

/* creating table users */
create table if not exists users
(
user_id integer auto_increment,
name varchar(100) not null,
username varchar(30) not null,
password varchar(30) not null,
join_date date,
current_subscriptionid integer,
subscription_plan varchar(15),
subscription_enddate date,
book_issue smallint,
book_issue_limit smallint,
total_book_issued smallint,
role varchar(15) not null,
email varchar(300) not null,
address1 varchar(100),
address2 varchar(100),
city varchar(50),
pin varchar(10),
mobile varchar(10) not null,
landline varchar(10),
last_login timestamp,
favoruite_category1 varchar(50),
favoruite_category2 varchar(50),
user_image_url varchar(300),
language varchar(50),
primary key (user_id),
constraint fk_usr_current_subscriptionid foreign key(current_subscriptionid) references subscriptions (subscription_id),
constraint uk_users_email unique key (email), 
constraint uk_users_mobile unique key (mobile), 
constraint uk_users_username unique key (username)
)
engine=myisam auto_increment=6 default charset=latin1;


/* creating table book_requests */
create table if not exists book_requests
(
request_id integer auto_increment ,
book_id integer ,
user_id integer ,
status varchar(20) ,
book_name varchar(100) ,
request_date date ,
issue_date date ,
return_request_date date ,
return_date date ,
cancel_date date ,
days_book_issued smallint ,
update_timestamp timestamp,
admin_response smallint, 
primary key(request_id), 
constraint fk_bk_req_userid foreign key (user_id) references users (user_id),
constraint fk_bk_req_bookid foreign key (book_id) references books (book_id), 
constraint uk_bkReq_user_book unique key(user_id, book_id) 
)engine=myisam auto_increment=6 default charset=latin1;


/* creating table user_eamails */
create table if not exists user_emails
(
email_id integer auto_increment,
from_user_email varchar(300) ,
to_user_email varchar(300) ,
subject varchar(300) ,
content text ,
date date ,
alert_type varchar(30), 
primary key (email_id)
)engine=myisam auto_increment=6 default charset=latin1;

/* creating table user_subscription */
create table if not exists user_subscriptions
(
user_subscription_id integer auto_increment ,
user_id integer ,
subscription_id integer ,
start_date date ,
alert_date date ,
end_date date ,
payment_by varchar(10) ,
payment_received  varchar(3) ,
received_by varchar(100) ,
received_date date ,
cheque_of_bank varchar(200) ,
cheque_number varchar(10) ,
amount integer ,
primary key (user_subscription_id),
constraint fk_ur_subs_userid foreign key (user_id) references users (user_id),
constraint fk_ur_subs_subscriptionid foreign key (subscription_id) references subscriptions (subscription_id)
)engine=myisam auto_increment=6 default charset=latin1;
 
