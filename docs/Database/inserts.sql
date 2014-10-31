insert into users 
(name, username, password, join_date, role, email, address1, address2, city, pin, mobile, landline, last_login, favoruite_category1, favoruite_category2, language) 
values 
('Aim','aim_ami','aim_ami123','2014-10-21','Role_user','aim_ami@aim123.com','Aim 123 House No 11','Street 42 , sector 40','Indore','452001','9999299992','7312338933','2014-10-21 17:24:11','Technology','Computer','English');

----------------------------------------
/*Subscription Inserts */
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('Monthly','Monthly Plan',10,1,30,150);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('Monthly+','Monthly Plus Plan',10,2,30,180);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('3monthly','Tri Monthly Plan',40,2,90,300);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('3monthly+','Tri Monthly Plus Plan',50,3,90,400);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('6Monthly','Six Monthly Plan',100,3,180,750);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('6Monthly+','Six Monthly Plus Plan',150,5,180,900);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('Yearly','Yearly Plan',300,5,365,1500);
insert into subscriptions(plan, plan_name, book_limit, issue_limit, period, rate) values ('Yearly+','Yearly Plus Plan',500,5,365,1800);

----------------------------------------
/*Books Inserts */
