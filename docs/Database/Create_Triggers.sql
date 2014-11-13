/* Creating trigger on Book Request to Update its status at Book for the book_id*/
DELIMITER |
CREATE TRIGGER Trig_book_status BEFORE UPDATE ON  book_requests 
FOR EACH ROW 
	BEGIN
	DECLARE
		issuedate date;
		set issuedate=(select Issue_date from book_requests where request_id=new.request_id);
		IF (NEW.status='Issued') THEN 
			UPDATE books SET books.status='Issued' WHERE books.Book_id=New.Book_id;
			set new.issue_date=SYSDATE();
		ELSEIF NEW.status='Returned' THEN 
			UPDATE books SET books.status='Available' WHERE books.Book_id=New.Book_id;
			set new.return_date=SYSDATE();
			set new.days_book_issued=DATEDIFF(SYSDATE(), issuedate);
		END IF;
		set new.admin_response=1;
	END
	|
DELIMITER ;

/* Creating trigger on User_subscription when it get started updates users table*/
DELIMITER |
CREATE TRIGGER Trig_User_subscription_User BEFORE update ON  user_subscriptions 
FOR EACH ROW 
BEGIN
DECLARE booklimit, issuelimit INT;
	DECLARE plan_name varchar(15);
	set booklimit = (select book_limit from subscriptions s where s.subscription_id=new.Subscription_id);
	set issuelimit = (select issue_limit  from subscriptions s where s.subscription_id=new.Subscription_id);
	set plan_name = (select plan from subscriptions s where s.subscription_id=new.Subscription_id);
	UPDATE users SET users.Subscription_plan=plan_name,
		users.book_issue_limit=issuelimit, 
		users.total_book_issued=booklimit
		where users.user_id=new.user_id ; 
	update users set users.subscription_endDate= Case 
														when plan_name in ('Monthly','Monthly+') then (Sysdate()+interval 30 day)
														When plan_name in ('3monthly','3Monthly+') then (Sysdate()+interval 90 day)
														When plan_name in ('6monthly','6Monthly+') then (Sysdate()+interval 180 day)
														When plan_name in ('Yearly','Yearly+') then (Sysdate()+interval 365 day)
													else null end where users.user_id=new.user_id ; 
	set new.alert_date=Case 
														when plan_name in ('Monthly','Monthly+') then (Sysdate()+interval 25 day)
														When plan_name in ('3monthly','3Monthly+') then (Sysdate()+interval 85 day)
														When plan_name in ('6monthly','6Monthly+') then (Sysdate()+interval 175 day)
														When plan_name in ('Yearly','Yearly+') then (Sysdate()+interval 360 day)
													else null end ;
	set new.end_date=Case 
														when plan_name in ('Monthly','Monthly+') then (Sysdate()+interval 30 day)
														When plan_name in ('3monthly','3Monthly+') then (Sysdate()+interval 90 day)
														When plan_name in ('6monthly','6Monthly+') then (Sysdate()+interval 180 day)
														When plan_name in ('Yearly','Yearly+') then (Sysdate()+interval 365 day)
													else null end ;
	END
	|
DELIMITER ;
