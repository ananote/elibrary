/* Document Name - Readme.txt*/
/*Purpose - To describe the flow of implementation of System. */

System Information - 
1. Operating System - Windows 7/8/8.1
2. Database - MySQL 5.1 (MyIASM)
3. Language - Java 7
4. Platform - J2EE
5. Framework - Spring
6. Other Development Frameworks -  hibernate with MVC
7. Server Used - Maven Jetty 
8. Development Environment tool - Eclipse

=================================================================================================================
Database Implementation - Go to Docs/Database folder
=================================================================================================================
1. Install mentioned database server and set the password impetus. 
2. Execute MySQL_LIB_TABLES.sql on root. (it will create the required database "mylib" and its tables in the database). 
3. The list of created tables and its corresponding column details are available in the database folder's excel file "Database Tables". 
4. Contents of "Database Tables" Excel - 
	a. Table Column Details
	b. Hard-coded values used in the system
5. Inserts for the table - Populates only master tables, other than the following tables all tables are opreational tables. 
	a. Books (books.sql)
	b. Subscriptions (subscriptions.sql)
	c. users (users.sql)
6. ER_Diagram - Attached png file describes the ER model of the database. More focus was on front end and middle layer programming therefore database is crisp and non-normalized. 
7. MySQL_LIB_Tables_DROP.sql - file for deleting all the created tables. 
=================================================================================================================
UML
=================================================================================================================
Currently it is having Use case and class diagrams only. ER Diagram is already included in database folder. 

=================================================================================================================
Current Status as per Date 28/10/2014
=================================================================================================================
What we can see currently - 
1. Library Home page (few links are not live, author list not sorted, 
2. Users login page (User page need to identify as per their role pending, session management pending, User home page is pending)
3. Admin Pages - Crud can add update delete the master table data (reporting, Emails specific things are pending)

Pending list - 
1. Application integration is pending
2. reports are pending
3. complete flow of book request to return is pending
4. Other deliverables includes UML diagrams pending
5. Scheduled upload is pending
6. PDF reports pending
7. Adding using excel file is pending

=======================================================================================================================
On-line Library Management Pages 
=======================================================================================================================
Library Home pages - 
http://localhost:8080/elibrary/view/lib_home.jsp

User Login Page - 
http://localhost:8080/elibrary/view/lib_login.jsp

Admin Crud Pages - 
http://localhost:8080/elibrary/view/admin_home.jsp
