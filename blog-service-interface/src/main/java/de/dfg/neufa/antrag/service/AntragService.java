/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-service-interface
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.service;

import java.util.List;

import javax.ejb.Local;

import de.dfg.neufa.antrag.bo.AntragBO;


/**
 * The Interface AntragService.
 */
@Local
public interface AntragService {
	
	/**
	 * Find antraege by titel.
	 *
	 * @param titel the titel
	 * @return the list
	 */
	public List<AntragBO> findAntraegeByTitel(String titel);
	
	/**
	 * Gets the antraege by id.
	 *
	 * @param id the id
	 * @return the antraege by id
	 */
	public AntragBO getAntraegeById(Long id) ;
}
