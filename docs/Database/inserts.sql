--Admin User Inserts - 

use mylib;

insert into users 
(name, username, password, join_date, role, email, address1, address2, city, pin, mobile, landline, last_login, favoruite_category1, favoruite_category2, language) 
values 
('Aim','aim_ami','aim_ami123','2014-10-21','Role_Admin','aim_ami@aim123.com','Aim 123 House No 11','Street 42 , sector 40','Indore','452001','9999299992','7312338933','2014-10-21 17:24:11','Technology','Computer','English');
insert into users 
(name, username, password, join_date, role, email, address1, address2, city, pin, mobile, landline, last_login, favoruite_category1, favoruite_category2, language) 
values 
('A','a','a','2014-11-06','Role_Admin','a@aim123.com','House No B/11','Street A/II, sector 40','Indore','452001','9299299992','7312338913','2014-11-06 17:24:11','Programming','Computer','English');

commit;
