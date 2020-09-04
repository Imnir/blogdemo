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
 * The Class FilterItem.
 */
public class FilterItem implements Serializable {
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
 
	/** The name. */
	private String name;
	
	/** The typ. */
	private TYP typ;
	
	/** The case sensitive. */
	private boolean caseSensitive;
	
	/** The filter value 1. */
	private transient Object filterValue1;
	
	/** The filter value 2. */
	private transient Object filterValue2;
	
	/**
	 * The Enum TYP.
	 */
	public enum TYP {
		
		/** The equal case sensitiv. */
		EQUAL_CASE_SENSITIV,
		
		/** The equal case insensitiv. */
		EQUAL_CASE_INSENSITIV,
		
		/** The not equal case sensitiv. */
		NOT_EQUAL_CASE_SENSITIV,
		
		/** The not equal case insensitiv. */
		NOT_EQUAL_CASE_INSENSITIV,
		
		/** The like case sensitiv. */
		LIKE_CASE_SENSITIV,
		
		/** The like case insensitiv. */
		LIKE_CASE_INSENSITIV,
		
		/** The greater than. */
		GREATER_THAN,
		
		/** The greater than or equal to. */
		GREATER_THAN_OR_EQUAL_TO,
		
		/** The lower than. */
		LOWER_THAN,
		
		/** The lower than or equal to. */
		LOWER_THAN_OR_EQUAL_TO,
		
		/** The between. */
		BETWEEN, 
		
		/** The in. */
		IN, 
		
		/** The not in. */
		NOT_IN,
	}
	
	/**
	 * Instantiates a new filter item.
	 *
	 * @param name the name
	 * @param typ the typ
	 * @param filterValue1 the filter value 1
	 * @param filterValue2 the filter value 2
	 */
	public FilterItem(String name, TYP typ, Object filterValue1, Object filterValue2) {
		this.name=name;
		this.typ=typ;
		this.filterValue1=filterValue1;
		this.filterValue2=filterValue2;
	}
 
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
 
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
 
	/**
	 * Gets the typ.
	 *
	 * @return the typ
	 */
	public TYP getTyp() {
		return typ;
	}
 
	/**
	 * Sets the typ.
	 *
	 * @param typ the new typ
	 */
	public void setTyp(TYP typ) {
		this.typ = typ;
	}
 
	/**
	 * Gets the filter value 1.
	 *
	 * @return the filter value 1
	 */
	public Object getFilterValue1() {
		return filterValue1;
	}
 
	/**
	 * Sets the filter value 1.
	 *
	 * @param filterValue1 the new filter value 1
	 */
	public void setFilterValue1(Object filterValue1) {
		this.filterValue1 = filterValue1;
	}
 
	/**
	 * Gets the filter value 2.
	 *
	 * @return the filter value 2
	 */
	public Object getFilterValue2() {
		return filterValue2;
	}
 
	/**
	 * Sets the filter value 2.
	 *
	 * @param filterValue2 the new filter value 2
	 */
	public void setFilterValue2(Object filterValue2) {
		this.filterValue2 = filterValue2;
	}
 
	/**
	 * Checks if is case sensitive.
	 *
	 * @return true, if is case sensitive
	 */
	public boolean isCaseSensitive() {
		return caseSensitive;
	}
 
	/**
	 * Sets the case sensitive.
	 *
	 * @param caseSensitive the new case sensitive
	 */
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}
  
}
