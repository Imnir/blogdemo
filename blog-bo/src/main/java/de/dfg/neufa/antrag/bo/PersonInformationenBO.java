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


/**
 * The Class PersonInformationenBO.
 */
public class PersonInformationenBO implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The vorname. */
	private String vorname;

	/** The nachname. */
	private String nachname;

	/** The account name. */
	private String accountName;

	/** The personal nummer. */
	private String personalNummer;

	/** The raum. */
	private String raum;

	/** The foto url. */
	private String fotoUrl;

	/**
	 * Instantiates a new person informationen BO.
	 */
	public PersonInformationenBO() {
	}

	/**
	 * Instantiates a new person informationen BO.
	 *
	 * @param personalNummer the personal nummer
	 */
	public PersonInformationenBO(final String personalNummer) {
		this.personalNummer = personalNummer;
	}

	/**
	 * Instantiates a new person informationen BO.
	 *
	 * @param personalNummer the personal nummer
	 * @param nachname the nachname
	 * @param vorname the vorname
	 * @param raum the raum
	 * @param fotoUrl the foto url
	 */
	public PersonInformationenBO(final String personalNummer, final String nachname, final String vorname,
			final String raum, final String fotoUrl) {
		this.personalNummer = personalNummer;
		this.nachname = nachname;
		this.vorname = vorname;
		this.raum = raum;
		this.fotoUrl = fotoUrl;
	}

	/**
	 * Gets the vorname.
	 *
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Sets the vorname.
	 *
	 * @param vorname the new vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * Gets the nachname.
	 *
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Sets the nachname.
	 *
	 * @param nachname the new nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * Gets the account name.
	 *
	 * @return the account name
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Sets the account name.
	 *
	 * @param accountName the new account name
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Gets the personal nummer.
	 *
	 * @return the personal nummer
	 */
	public String getPersonalNummer() {
		return personalNummer;
	}

	/**
	 * Sets the personal nummer.
	 *
	 * @param personalNummer the new personal nummer
	 */
	public void setPersonalNummer(String personalNummer) {
		this.personalNummer = personalNummer;
	}

	/**
	 * Gets the raum.
	 *
	 * @return the raum
	 */
	public String getRaum() {
		return raum != null ? raum : "";
	}

	/**
	 * Sets the raum.
	 *
	 * @param raum the new raum
	 */
	public void setRaum(String raum) {
		this.raum = raum;
	}

	/**
	 * Sets the foto url.
	 *
	 * @param url the new foto url
	 */
	public void setFotoUrl(String url) {
		this.fotoUrl = url;
	}

	/**
	 * Gets the foto url.
	 *
	 * @return the foto url
	 */
	public String getFotoUrl() {
		return fotoUrl;
	}

	/**
	 * Gets the name vorname.
	 *
	 * @return the name vorname
	 */
	public String getNameVorname() {
		String ret = "";
		if (nachname == null || vorname == null) {
			return ret;
		}
		ret += nachname;
		ret += ", ";
		ret += vorname;
		return ret;
	}

	/**
	 * Gets the name vorname raum.
	 *
	 * @return the name vorname raum
	 */
	public String getNameVornameRaum() {
		String ret = "";
		String nameVorname = getNameVorname();
		if (nameVorname == null || nameVorname.isEmpty()) {
			return ret;
		}
		ret += "[" + (raum != null ? raum : "./.") + "]";
		ret += " - " + nameVorname;
		return ret;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personalNummer == null) ? 0 : personalNummer.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonInformationenBO other = (PersonInformationenBO) obj;
		if (personalNummer == null) {
			if (other.personalNummer != null) {
				return false;
			}
		} else if (!personalNummer.equals(other.personalNummer)) {
			return false;
		}
		return true;
	}
}
