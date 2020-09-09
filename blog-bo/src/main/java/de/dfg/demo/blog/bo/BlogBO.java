/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-bo
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.demo.blog.bo;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 * The Class AntragBO.
 */
public class BlogBO implements Serializable {

	private static final DateTimeFormatter  df = DateTimeFormatter .ofPattern("dd.MM.yyyy");
	private String titel;
	private LocalDate datum;
	private String autor;
	private String blogtext;
	private static long id = 0L;

	public BlogBO(){
		id++;
		this.datum = LocalDate.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getBlogtext() {
		return blogtext;
	}
	public void setBlogtext(String blogtext) {
		this.blogtext = blogtext;
	}
	public String getDatumAsString() {
		return BlogBO.df.format(this.getDatum());
	}

}
