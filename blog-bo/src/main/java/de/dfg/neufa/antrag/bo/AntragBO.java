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
package de.dfg.neufa.antrag.bo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class AntragBO.
 */
public class AntragBO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;
	
	/** The titelDeutsch. */
	private String titelDeutsch = "";		// ANTRAG.ANT_TITELD
	private String titelEnglisch = "";		// ANTRAG.ANT_TITELE
	private String antragStatus = "";		// ANTRAGSTATUS.AST_BEZEICHNUNGEXTERN
	private LocalDate eingangsDatum;		// ANTRAG.ANT_EINGANGSDATUM
	private Double antragSumme;				// ANTRAG.ANT_ANTGRAGSUMME
	private Double bewilligungSumme;		// ANTRAG.ANT_BEWILLIGUNGSUMME
	private long antragDauer;				// ANTRAG.ANT_ANTRAGDAUER
	private long bewilligungDauer; // ANTRAG.ANT_BEWILLIGUNGDAUER

	/** The Constant PROPERTY_ID. */
	public static final String PROPERTY_ID = "id";
	
	/** The Constant PROPERTY_NAME. */
	public static final String PROPERTY_TITEL_DEUTSCH = "titelDeutsch";
	
	

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
	 *
	 * @return titelEnglisch
	 */
	public String getTitelEnglisch() {
		return titelEnglisch;
	}

	/**
	 *
	 * @param titelEnglisch
	 */
	public void setTitelEnglisch(String titelEnglisch) {
		this.titelEnglisch = titelEnglisch;
	}

	/**
	 *
	 * @return antragStatus
	 */
	public String getAntragStatus() {
		return antragStatus;
	}

	/**
	 *
	 * @param antragStatus
	 */
	public void setAntragStatus(String antragStatus) {
		this.antragStatus = antragStatus;
	}

	/**
	 *
	 * @return eingangsDatum
	 */
	public LocalDate getEingangsDatum() {
		return eingangsDatum;
	}

	/**
	 *
	 * @param eingangsDatum
	 */
	public void setEingangsDatum(LocalDate eingangsDatum) {
		this.eingangsDatum = eingangsDatum;
	}

	/**
	 *
	 * @return antragSumme
	 */
	public Double getAntragSumme() {
		return antragSumme;
	}

	/**
	 *
	 * @param antragSumme
	 */
	public void setAntragSumme(Double antragSumme) {
		this.antragSumme = antragSumme;
	}

	/**
	 *
	 * @return bewilligungSumme
	 */
	public Double getBewilligungSumme() {
		return bewilligungSumme;
	}

	/**
	 *
	 * @param bewilligungSumme
	 */
	public void setBewilligungSumme(Double bewilligungSumme) {
		this.bewilligungSumme = bewilligungSumme;
	}

	/**
	 *
	 * @return antragDauer
	 */
	public long getAntragDauer() {
		return antragDauer;
	}

	/**
	 *
	 * @param antragDauer
	 */
	public void setAntragDauer(long antragDauer) {
		this.antragDauer = antragDauer;
	}

	/**
	 *
	 * @return bewilligungDauer
	 */
	public long getBewilligungDauer() {
		return bewilligungDauer;
	}

	/**
	 *
	 * @param bewilligungDauer
	 */
	public void setBewilligungDauer(long bewilligungDauer) {
		this.bewilligungDauer = bewilligungDauer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((titelDeutsch == null) ? 0 : titelDeutsch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntragBO other = (AntragBO) obj;
		if (id != other.id)
			return false;
		if (titelDeutsch == null) {
			if (other.titelDeutsch != null)
				return false;
		} else if (!titelDeutsch.equals(other.titelDeutsch))
			return false;
		return true;
	}


}
