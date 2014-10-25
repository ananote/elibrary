package com.impetus.elibrary.model;

import java.io.Serializable;
import javax.persistence.*;
//import java.util.List;
import java.util.Set;


/**
 * The persistent class for the subscriptions database table.
 * 
 */
@Entity
@Table(name="subscriptions")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subscription_id")
	private int subscriptionId;

	@Column(name="book_limit")
	private short bookLimit;

	@Column(name="issue_limit")
	private short issueLimit;

	private short period;

	private String plan;

	@Column(name="plan_name")
	private String planName;

	private short rate;

	//bi-directional many-to-one association to UserSubscription
	@OneToMany(mappedBy="subscription")
	private Set<UserSubscription> userSubscriptions;

	public Subscription() {
	}

	public int getSubscriptionId() {
		return this.subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public short getBookLimit() {
		return this.bookLimit;
	}

	public void setBookLimit(short bookLimit) {
		this.bookLimit = bookLimit;
	}

	public short getIssueLimit() {
		return this.issueLimit;
	}

	public void setIssueLimit(short issueLimit) {
		this.issueLimit = issueLimit;
	}

	public short getPeriod() {
		return this.period;
	}

	public void setPeriod(short period) {
		this.period = period;
	}

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public short getRate() {
		return this.rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	/*public Set<UserSubscription> getUserSubscriptions() {
		return this.userSubscriptions;
	}

	public void setUserSubscriptions(Set<UserSubscription> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public UserSubscription addUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().add(userSubscription);
		userSubscription.setSubscription(this);

		return userSubscription;
	}

	public UserSubscription removeUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().remove(userSubscription);
		userSubscription.setSubscription(null);

		return userSubscription;
	}*/

}