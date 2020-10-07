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

/**
 * The Class BlogEntity.
 */
@Entity
@NamedQuery(name = BlogEntity.QUERY_BY_ALL, query = "SELECT e FROM BlogEntity e")
@NamedQuery(name = BlogEntity.QUERY_BY_ID, query = "SELECT e FROM BlogEntity e WHERE e.id =:" + BlogEntity.QUERY_PARAMETER_ID)
@NamedQuery(name = BlogEntity.QUERY_BY_DATE, query = "SELECT e FROM BlogEntity e WHERE e.datum =:" + BlogEntity.QUERY_PARAMETER_DATE)
@Table(name = "Blog")

public class BlogEntity implements Serializable {

	/** The Constant QUERY_BY_ALL. */
	public static final String QUERY_BY_ALL = "BlogEntity.QUERY_BY_ALL";

	/** The Constant QUERY_BY_ID. */
	public static final String QUERY_BY_ID = "BlogEntity.QUERY_BY_ID";

	/** The Constant QUERY_PARAMETER_ID. */
	public static final String QUERY_PARAMETER_ID = "QUERY_PARAMETER_ID";

	/** The Constant QUERY_BY_DATE. */
	public static final String QUERY_BY_DATE = "BlogEntity.QUERY_BY_DATE";

	/** The Constant QUERY_PARAMETER_DATE. */
	public static final String QUERY_PARAMETER_DATE = "QUERY_PARAMETER_DATE";

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
	@Column(name="BLOG_TEXT", length=3000)
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