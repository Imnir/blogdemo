/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-service
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/

package de.dfg.neufa.antrag.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.dfg.neufa.DFGLogging;
import de.dfg.neufa.antrag.bo.AntragBO;
import de.dfg.neufa.antrag.dao.AntragDao;
import de.dfg.neufa.antrag.service.AntragService;


/**
 * The Class AntragServiceBean.
 */
@Stateless
public class AntragServiceBean implements AntragService {
	
	/** The Constant TECH. */
	private static final Logger TECH = DFGLogging.getTechLogger(AntragServiceBean.class);
	
	/** The Constant EJB. */
	private static final Logger EJB = DFGLogging.getEJBLogger(AntragServiceBean.class);

	/** The antrag dao. */
	@EJB
	AntragDao antragDao;


	/**
	 * Ready.
	 */
	@PostConstruct
	private void ready() {

		EJB.info("NEW SERVICE INSTANCE OF: "+this.getClass().getName());		
	}
	
	/**
	 * Destroy.
	 */
	@PreDestroy
	private void destroy() {
		EJB.info("DESTROY SERVICE INSTANCE OF: " + this.getClass().getName());

	}

    /**
     * Find antraege by titel.
     *
     * @param searchString the search string
     * @return the list
     */
    @Override	
    public List<AntragBO> findAntraegeByTitel(final String searchString) {
		TECH.info("FIND ANTRAG BY TITEL: " + searchString);
		return antragDao.findAntraegeByTitel("%"+searchString+"%");
	}
	
	/**
	 * Gets the antraege by id.
	 *
	 * @param id the id
	 * @return the antraege by id
	 */
	@Override
	public AntragBO getAntraegeById(Long id) {
		return antragDao.getAntraegeById(id);
	}


}
