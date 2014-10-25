package com.impetus.elibrary.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_subscriptions database table.
 * 
 */
@Entity
@Table(name="user_subscriptions")
@NamedQuery(name="UserSubscription.findAll", query="SELECT u FROM UserSubscription u")
public class UserSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_subscription_id")
	private int userSubscriptionId;

	@Temporal(TemporalType.DATE)
	@Column(name="alert_date")
	private Date alertDate;

	private int amount;

	@Column(name="cheque_number")
	private String chequeNumber;

	@Column(name="cheque_of_bank")
	private String chequeOfBank;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="payment_by")
	private String paymentBy;

	@Column(name="payment_received")
	private String paymentReceived;

	@Column(name="received_by")
	private String receivedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="received_date")
	private Date receivedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Subscription
	@ManyToOne
	@JoinColumn(name="subscription_id")
	private Subscription subscription;

	public UserSubscription() {
	}

	public int getUserSubscriptionId() {
		return this.userSubscriptionId;
	}

	public void setUserSubscriptionId(int userSubscriptionId) {
		this.userSubscriptionId = userSubscriptionId;
	}

	public Date getAlertDate() {
		return this.alertDate;
	}

	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getChequeNumber() {
		return this.chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getChequeOfBank() {
		return this.chequeOfBank;
	}

	public void setChequeOfBank(String chequeOfBank) {
		this.chequeOfBank = chequeOfBank;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPaymentBy() {
		return this.paymentBy;
	}

	public void setPaymentBy(String paymentBy) {
		this.paymentBy = paymentBy;
	}

	public String getPaymentReceived() {
		return this.paymentReceived;
	}

	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public String getReceivedBy() {
		return this.receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

}