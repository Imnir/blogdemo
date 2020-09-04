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
 * The Class SortItem.
 */
public class SortItem implements Serializable {
 
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
 
	/** The name. */
	private String name;
	
	/** The asc. */
	private boolean asc;
	
	/**
	 * Instantiates a new sort item.
	 *
	 * @param name the name
	 * @param asc the asc
	 */
	public SortItem(String name, boolean asc) {
		this.name=name;
		this.asc=asc;
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
	 * Checks if is asc.
	 *
	 * @return true, if is asc
	 */
	public boolean isAsc() {
		return asc;
	}
 
	/**
	 * Sets the asc.
	 *
	 * @param asc the new asc
	 */
	public void setAsc(boolean asc) {
		this.asc = asc;
	}
 
}

