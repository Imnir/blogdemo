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

package de.dfg.neufa.antrag.dao.entity;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AntragEntity.
 */
@Entity
@NamedQuery(name = AntragEntity.QUERY_BY_ID, query = "SELECT e FROM AntragEntity e WHERE e.id = :" + AntragEntity.QUERY_PARAMETER_ID)
@NamedQuery(name = AntragEntity.QUERY_BY_TITELD, query = "SELECT e FROM AntragEntity e WHERE e.titelDeutsch LIKE :" + AntragEntity.QUERY_PARAMETER_TITELD)
@Table(name = "ANTRAG")
public class AntragEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant QUERY_BY_TITELD. */
	public static final String QUERY_BY_TITELD = "AntragEntity.QUERY_BY_TITELD";
	
	/** The Constant QUERY_BY_ID. */
	public static final String QUERY_BY_ID = "AntragEntity.QUERY_BY_ID";
	
	/** The Constant QUERY_PARAMETER_TITELD. */
	public static final String QUERY_PARAMETER_TITELD = "QUERY_PARAMETER_TITELD";
	
	/** The Constant QUERY_PARAMETER_ID. */
	public static final String QUERY_PARAMETER_ID = "QUERY_PARAMETER_ID";


	/** The id. */
	@Id
	@Column(name = "ANT_ID", nullable=false)
	private long id;

	/** The titel deutsch. */
	@Column(name = "ANT_TITELD")
	private String titelDeutsch = "";		// ANTRAG.ANT_TITELD

	/** The titel englisch. */
	@Column(name = "ANT_TITELE")
	private String titelEnglisch = "";		// ANTRAG.ANT_TITELE

	/** The eingangs datum. */
	@Column(name = "ANT_EINGANGSDATUM")
	private LocalDate eingangsDatum;		// ANTRAG.ANT_EINGANGSDATUM

	/** The antrag dauer. */
	@Column(name = "ANT_ANTRAGDAUER") // ANTRAG.ANT_ANTRAGDAUER
	private Long antragDauer;

	/** The antrag summe. */
	@Column(name = "ANT_ANTRAGSUMME") // ANTRAG.ANT_ANTRAGSUMME
	private Double antragSumme;

	/** The bewilligung dauer. */
	@Column(name = "ANT_BEWILLIGUNGDAUER")
	private Long bewilligungDauer; // ANTRAG.ANT_BEWILLIGUNGSDAUER

	/** The bewilligung summe. */
	@Column(name = "ANT_BEWILLIGUNGSUMME")
	private Double bewilligungSumme;		// ANTRAG.ANT_BEWILLIGUNGSUMME

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the titel deutsch.
	 *
	 * @return the titel deutsch
	 */
	public String getTitelDeutsch() {
		return titelDeutsch;
	}

	/**
	 * Sets the titel deutsch.
	 *
	 * @param titelDeutsch the new titel deutsch
	 */
	public void setTitelDeutsch(String titelDeutsch) {
		this.titelDeutsch = titelDeutsch;
	}

	/**
	 * Gets the titel englisch.
	 *
	 * @return the titel englisch
	 */
	public String getTitelEnglisch() {
		return titelEnglisch;
	}

	/**
	 * Sets the titel englisch.
	 *
	 * @param titelEnglisch the new titel englisch
	 */
	public void setTitelEnglisch(String titelEnglisch) {
		this.titelEnglisch = titelEnglisch;
	}

	/**
	 * Gets the eingangs datum.
	 *
	 * @return the eingangs datum
	 */
	public LocalDate getEingangsDatum() {
		return eingangsDatum;
	}

	/**
	 * Sets the eingangs datum.
	 *
	 * @param eingangsDatum the new eingangs datum
	 */
	public void setEingangsDatum(LocalDate eingangsDatum) {
		this.eingangsDatum = eingangsDatum;
	}

	/**
	 * Gets the antrag dauer.
	 *
	 * @return the antrag dauer
	 */
	public Long getAntragDauer() {
		return antragDauer;
	}

	/**
	 * Sets the antrag dauer.
	 *
	 * @param antragDauer the new antrag dauer
	 */
	public void setAntragDauer(Long antragDauer) {
		this.antragDauer = antragDauer;
	}

	/**
	 * Gets the antrag summe.
	 *
	 * @return the antrag summe
	 */
	public Double getAntragSumme() {
		return antragSumme;
	}

	/**
	 * Sets the antrag summe.
	 *
	 * @param antragSumme the new antrag summe
	 */
	public void setAntragSumme(Double antragSumme) {
		this.antragSumme = antragSumme;
	}

	/**
	 * Gets the bewilligung dauer.
	 *
	 * @return the bewilligung dauer
	 */
	public Long getBewilligungDauer() {
		return bewilligungDauer;
	}

	/**
	 * Sets the bewilligung dauer.
	 *
	 * @param bewilligungDauer the new bewilligung dauer
	 */
	public void setBewilligungDauer(Long bewilligungDauer) {
		this.bewilligungDauer = bewilligungDauer;
	}

	/**
	 * Gets the bewilligung summe.
	 *
	 * @return the bewilligung summe
	 */
	public Double getBewilligungSumme() {
		return bewilligungSumme;
	}

	/**
	 * Sets the bewilligung summe.
	 *
	 * @param bewilligungSumme the new bewilligung summe
	 */
	public void setBewilligungSumme(Double bewilligungSumme) {
		this.bewilligungSumme = bewilligungSumme;
	}

}