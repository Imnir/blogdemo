/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-dao
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.dfg.neufa.DFGLogging;
import de.dfg.neufa.antrag.bo.AntragBO;
import de.dfg.neufa.antrag.dao.entity.AntragEntity;
import de.dfg.neufa.antrag.dao.mapper.AntragMapper;



/**
 * The Class AntragDaoEJBImpl.
 */
@Stateless
public class AntragDaoEJBImpl extends AbstractDao<AntragEntity, AntragBO> implements AntragDao {
	
	/** The Constant EJB. */
	private static final Logger EJB = DFGLogging.getEJBLogger(AntragDaoEJBImpl.class);


	/**
	 * Ready.
	 */
	@PostConstruct
	private void ready() {
		EJB.info("NEW SERVICE INSTANCE OF: " + this.getClass().getName());
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
	 * @param titel the titel
	 * @return the list
	 */
	@Override
	public List<AntragBO> findAntraegeByTitel(String titel) {
		TypedQuery<AntragEntity> query = this.getEntityManager().createNamedQuery(AntragEntity.QUERY_BY_TITELD, AntragEntity.class);
		query.setParameter(AntragEntity.QUERY_PARAMETER_TITELD, titel);
		query.setMaxResults(1000);
		return super.loadAndMapEntities(query, AntragMapper::mapEntityToBO);
	}
	
	/**
	 * Gets the antraege by id.
	 *
	 * @param id the id
	 * @return the antraege by id
	 */
	@Override
	public AntragBO getAntraegeById(Long id) {
		TypedQuery<AntragEntity> query = this.getEntityManager().createNamedQuery(AntragEntity.QUERY_BY_ID, AntragEntity.class);
		query.setParameter(AntragEntity.QUERY_PARAMETER_ID, id);
		return AntragMapper.mapEntityToBO(query.getSingleResult());
	}

}
