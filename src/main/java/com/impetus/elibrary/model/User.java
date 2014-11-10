package com.impetus.elibrary.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * The persistent class for the users database table.
 * 
 */
@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;

	private String address1;

	private String address2;

	@Column(name="book_issue")
	private Short bookIssue;

	@Column(name="book_issue_limit")
	private Short bookIssueLimit;

	private String city;

	@Column(name="current_subscriptionid")
	private Integer currentSubscriptionid;

	@Column(name="email")
	private String email;
	
	@Column(name="favoruite_category1")
	private String favoruiteCategory1;

	@Column(name="favoruite_category2")
	private String favoruiteCategory2;

	@Temporal(TemporalType.DATE)
	@Column(name="join_date")
	private Date joinDate;

	private String landline;

	private String language;

	@Column(name="last_login")
	private Timestamp lastLogin;

	private String mobile;

	private String name;

	private String password;

	private String pin;

	private String role;

	@Temporal(TemporalType.DATE)
	@Column(name="subscription_enddate")
	private Date subscriptionEnddate;

	@Column(name="subscription_plan")
	private String subscriptionPlan;

	@Column(name="total_book_issued")
	private Short totalBookIssued;

	@Column(name="user_image_url")
	private String userImageUrl;

	private String username;

	//bi-directional many-to-one association to BookRequest
/*	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<BookRequest> bookRequests;*/

	//bi-directional many-to-one association to UserSubscription
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<UserSubscription> userSubscriptions;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Short getBookIssue() {
		return this.bookIssue;
	}

	public void setBookIssue(Short bookIssue) {
		Logger.getLogger(User.class).info("Setting book issue limit " + bookIssueLimit);
		this.bookIssue = bookIssue;
	}

	public Short getBookIssueLimit() {
		return this.bookIssueLimit;
	}

	public void setBookIssueLimit(Short bookIssueLimit) {
		Logger.getLogger(User.class).info("Setting book issue limit " + bookIssueLimit);
		this.bookIssueLimit = bookIssueLimit;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCurrentSubscriptionid() {
		return this.currentSubscriptionid;
	}

	public void setCurrentSubscriptionid(Integer currentSubscriptionid) {
		this.currentSubscriptionid = currentSubscriptionid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFavoruiteCategory1() {
		return this.favoruiteCategory1;
	}

	public void setFavoruiteCategory1(String favoruiteCategory1) {
		this.favoruiteCategory1 = favoruiteCategory1;
	}

	public String getFavoruiteCategory2() {
		return this.favoruiteCategory2;
	}

	public void setFavoruiteCategory2(String favoruiteCategory2) {
		this.favoruiteCategory2 = favoruiteCategory2;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getLandline() {
		return this.landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getSubscriptionEnddate() {
		return this.subscriptionEnddate;
	}

	public void setSubscriptionEnddate(Date subscriptionEnddate) {
		this.subscriptionEnddate = subscriptionEnddate;
	}

	public String getSubscriptionPlan() {
		return this.subscriptionPlan;
	}

	public void setSubscriptionPlan(String subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}

	public Short getTotalBookIssued() {
		return this.totalBookIssued;
	}

	public void setTotalBookIssued(Short totalBookIssued) {
		this.totalBookIssued = totalBookIssued;
	}

	public String getUserImageUrl() {
		return this.userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*public Set<BookRequest> getBookRequests() {
		return this.bookRequests;
	}

	public void setBookRequests(Set<BookRequest> bookRequests) {
		this.bookRequests = bookRequests;
	}

	public BookRequest addBookRequest(BookRequest bookRequest) {
		getBookRequests().add(bookRequest);
		bookRequest.setUserId(this.userId);

		return bookRequest;
	}

	public BookRequest removeBookRequest(BookRequest bookRequest) {
		getBookRequests().remove(bookRequest);
		bookRequest.setUserId(0);

		return bookRequest;
	}*/

	public Set<UserSubscription> getUserSubscriptions() {
		return this.userSubscriptions;
	}

	public void setUserSubscriptions(Set<UserSubscription> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public UserSubscription addUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().add(userSubscription);
		userSubscription.setUser(this);

		return userSubscription;
	}

	public UserSubscription removeUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().remove(userSubscription);
		userSubscription.setUser(null);

		return userSubscription;
	}
	
	

/*	public Set<UserEmail> getUserEmails() {
		return this.userEmails;
	}
	public void setUserEmails(Set<UserEmail> userEmails) {
		this.userEmails = userEmails;
	}
	public UserEmail addUserEmail(UserEmail userEmail) {
		getUserEmails().add(userEmail);
		userEmail.setUser(this);
		return userEmail;
	}
	public UserEmail removeUserEmail(UserEmail userEmail) {
		getUserEmails().remove(userEmail);
		userEmail.setUser(null);
		return userEmail;
	}
	//bi-directional many-to-one association to UserEmail
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<UserEmail> userEmails;
*/

}