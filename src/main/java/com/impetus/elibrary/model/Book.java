package com.impetus.elibrary.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
//import java.util.List;
import java.util.Set;


/**
 * The persistent class for the books database table.
 * 
 */
@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity
@Table(name="books")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int bookId;

	@Temporal(TemporalType.DATE)
	@Column(name="add_date")
	private Date addDate;

	private String author;

	private String category;

	private String description;

	private String edition;

	@Column(name="image_url")
	private String imageUrl;

	private String isbn;

	private String language;

	private String name;

	private String publication;

	@Column(name="published_year")
	private String publishedYear;

	private String rating;

	private String status;

	//bi-directional many-to-one association to BookRequest
	@OneToMany(mappedBy="book")
	private Set<BookRequest> bookRequests;
	public Book() {
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPublishedYear() {
		return this.publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BookRequest> getBookRequests() {
		return this.bookRequests;
	}

	public void setBookRequests(Set<BookRequest> bookRequests) {
		this.bookRequests = bookRequests;
	}

	public BookRequest addBookRequest(BookRequest bookRequest) {
		getBookRequests().add(bookRequest);
		bookRequest.setBook(this);

		return bookRequest;
	}

	public BookRequest removeBookRequest(BookRequest bookRequest) {
		getBookRequests().remove(bookRequest);
		bookRequest.setBook(null);

		return bookRequest;
	}

}