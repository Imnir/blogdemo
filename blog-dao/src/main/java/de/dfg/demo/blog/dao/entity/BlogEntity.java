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


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc

/**
 * The Class BlogEntity.
 */
@Entity
@NamedQuery(name = BlogEntity.QUERY_BY_TITEL, query = "SELECT e FROM BlogEntity e")
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
	private LocalDate datum;

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

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
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