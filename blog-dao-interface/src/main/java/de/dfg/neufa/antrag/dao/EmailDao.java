/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-dao-interface
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.dao;

import java.util.List;

import javax.ejb.Local;

/**
 * The Interface EmailDao.
 */
@Local
public interface EmailDao {

	/**
	 * Send.
	 *
	 * @param from the from
	 * @param recipients the recipients
	 * @param subject the subject
	 * @param body the body
	 */
	public void send(String from, List<String> recipients, String subject, String body);
}