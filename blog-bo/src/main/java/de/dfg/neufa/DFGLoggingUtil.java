/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-util
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa;

/**
 * The Class DFGLoggingUtil.
 */
public class DFGLoggingUtil {
	
	/** The start. */
	long start;
	
	/**
	 * Instantiates a new DFG logging util.
	 */
	public DFGLoggingUtil() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * Gets the duration in sec.
	 *
	 * @return the duration in sec
	 */
	public long getDurationInSec(){
		long end =  System.currentTimeMillis();
		return (end-start)/1000;
	}
	
	/**
	 * Gets the duration in MS.
	 *
	 * @return the duration in MS
	 */
	public long getDurationInMS(){
		long end =  System.currentTimeMillis();
		return (end-start);
	}

}