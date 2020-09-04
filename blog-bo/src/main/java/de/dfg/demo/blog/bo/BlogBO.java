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
import java.util.Date;

/**
 * The Class AntragBO.
 */
public class BlogBO implements Serializable {

	private String titel;
	private Date datum;
	private String autor;
	private String blogtext;
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
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
	

}
