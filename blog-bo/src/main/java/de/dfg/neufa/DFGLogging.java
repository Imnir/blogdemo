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

import java.util.logging.Logger;

/**
 * The Class DFGLogging.
 */
@SuppressWarnings("rawtypes")
public class DFGLogging {

	/** The Constant ACCESS_CAT. */
	private static final String ACCESS_CAT = "access";

	/** The Constant EMAIL_CAT. */
	private static final String EMAIL_CAT = "email";

	/** The Constant BUSINESS_CAT. */
	private static final String BUSINESS_CAT = "business";

	/** The Constant TECH_CAT. */
	private static final String TECH_CAT = "tech";

	/** The Constant PERFORMANCE_CAT. */
	private static final String PERFORMANCE_CAT = "performance";

	/** The Constant EJB_CAT. */
	private static final String EJB_CAT = "ejb";
	
	/** The Constant FATAL_CAT. */
	private static final String FATAL_CAT = "fatal";

	/** The Constant MDC_APPLICATION. */
	public static final String MDC_APPLICATION = "application";
	
	/** The Constant MDC_SESSION_ID. */
	public static final String MDC_SESSION_ID = "sessionid";
	
	/** The Constant MDC_USERID. */
	public static final String MDC_USERID = "userid";
	

	/**
	 * Instantiates a new DFG logging.
	 */
	private DFGLogging() {
		throw new IllegalStateException("DFGLogging class");
	}

	/**
	 * 
	 * /** delivers an email logger (log of requests and responses).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getEmailLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.EMAIL_CAT, cl);
	}


	/**
	 * delivers an access logger (log of requests and responses).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getAccessLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.ACCESS_CAT, cl);
	}

/**
 * delivers an business logger (log of service classes).
 *
 * @param cl the cl
 * @return Logger
 */
	public static Logger getBusinessLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.BUSINESS_CAT, cl);
	}

	/**
	 * delivers an fatal logger (log of fatal events).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getFatalLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.FATAL_CAT, cl);
	}

	/**
	 * delivers an ejb logger (log of performance events).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getEJBLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.EJB_CAT, cl);
	}
	
	/**
	 * delivers an performance logger (log of performance events).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getPerformanceLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.PERFORMANCE_CAT, cl);
	}

	/**
	 * delivers an tech logger (log of technical information).
	 *
	 * @param cl the cl
	 * @return Logger
	 */
	public static Logger getTechLogger(Class cl) {
		return DFGLogging.getLogger(DFGLogging.TECH_CAT, cl);
	}

	/**
	 * Gets the logger.
	 *
	 * @param name the name
	 * @param cl   the cl
	 * @return the logger
	 */
	private static Logger getLogger(String name, Class cl) {
		if (cl != null) {
			name = name + "." + cl.getName();
		}
		return Logger.getLogger(name);
	}

}