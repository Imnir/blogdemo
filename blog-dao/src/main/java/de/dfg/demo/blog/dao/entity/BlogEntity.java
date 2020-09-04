/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-dao
 * Datum: 24.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/

package de.dfg.demo.blog.dao.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

// TODO: Auto-generated Javadoc

/**
 * The Class AntragEntity.
 */
@Entity
@NamedQuery(name = BlogEntity.QUERY_BY_TITEL, query = "SELECT e FROM BlogEntity")
@Table(name = "Blog")

public class BlogEntity implements Serializable {

	/** The Constant QUERY_BY_TITEL. */
	public static final String QUERY_BY_TITEL = "BlogEntity.QUERY_BY_TITEL";
	
	/** The Constant QUERY_PARAMETER_TITEL. */
	public static final String QUERY_PARAMETER_TITEL = "QUERY_PARAMETER_TITEL";

	/** The id. */
	@Id
	@Column(name = "BLOG_ID", nullable=false)
	private long id;

	/** The titel */
	@Column(name="BLOG_TITEL")
	private String titel;

	/** The Date */
	@Column(name = "BLOG_DATE")
	private LocalDate date;

	/** The author */
	@Column(name="BLOG_AUTHOR")
	private String author;

	/** The Blogtext */
	@Column(name="BLOG_TEXT")
	private String text;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

}