package com.impetus.elibrary.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_emails database table.
 * 
 */
@Entity
@Table(name="user_emails")
@NamedQuery(name="UserEmail.findAll", query="SELECT u FROM UserEmail u")
public class UserEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="email_id")
	private int emailId;

	@Column(name="alert_type")
	private String alertType;

	@Lob
	private String content;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="from_user_email")
	private String fromUserEmail;

	private String subject;

	public UserEmail() {
	}

	public int getEmailId() {
		return this.emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getAlertType() {
		return this.alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFromUserEmail() {
		return this.fromUserEmail;
	}

	public void setFromUserEmail(String fromUserEmail) {
		this.fromUserEmail = fromUserEmail;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	/*
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="to_user_email", referencedColumnName="email")
	private User user;
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/

}