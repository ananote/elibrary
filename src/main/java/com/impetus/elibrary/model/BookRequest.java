package com.impetus.elibrary.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the book_requests database table.
 * 
 */
@Entity
@Table(name="book_requests")
@NamedQuery(name="BookRequest.findAll", query="SELECT b FROM BookRequest b")
public class BookRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="request_id")
	private int requestId;

	@Column(name="book_name")
	private String bookName;

	@Temporal(TemporalType.DATE)
	@Column(name="cancel_date")
	private Date cancelDate;

	@Column(name="days_book_issued")
	private short daysBookIssued;

	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	@Temporal(TemporalType.DATE)
	@Column(name="request_date")
	private Date requestDate;

	@Temporal(TemporalType.DATE)
	@Column(name="return_date")
	private Date returnDate;

	@Temporal(TemporalType.DATE)
	@Column(name="return_request_date")
	private Date returnRequestDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="update_timestamp")
	private Date updateTimestamp;
	
	@Column(name="admin_response")
	private short adminResponse;
	 

	private String status;

	//bi-directional many-to-one association to Book
	@ManyToOne//(fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	private Book book;

	//bi-directional many-to-one association to User
	@ManyToOne//(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public BookRequest() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getCancelDate() {
		return this.cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public short getDaysBookIssued() {
		return this.daysBookIssued;
	}

	public void setDaysBookIssued(short daysBookIssued) {
		this.daysBookIssued = daysBookIssued;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReturnRequestDate() {
		return this.returnRequestDate;
	}

	public void setReturnRequestDate(Date returnRequestDate) {
		this.returnRequestDate = returnRequestDate;
	}
	
	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp= updateTimestamp;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public short getAdminResponse() {
		return this.adminResponse;
	}
	
	public void setAdminResponse(short adminResponse) {
		this.adminResponse = adminResponse;
	}


}