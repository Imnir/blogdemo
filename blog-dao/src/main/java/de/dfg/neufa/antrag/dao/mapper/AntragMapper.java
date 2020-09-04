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
package de.dfg.neufa.antrag.dao.mapper;

import java.io.Serializable;

import de.dfg.neufa.antrag.bo.AntragBO;
import de.dfg.neufa.antrag.dao.entity.AntragEntity;

/**
 * The Class AntragMapper.
 */
public class AntragMapper implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Map BO to entity.
	 *
	 * @param bo the bo
	 * @return the antrag entity
	 */
	public static final AntragEntity mapBOToEntity(AntragBO bo) {
		AntragEntity e = new AntragEntity();
		e.setId(bo.getId());
		e.setTitelDeutsch(bo.getTitelDeutsch());
		e.setTitelEnglisch(bo.getTitelEnglisch());
		e.setEingangsDatum(bo.getEingangsDatum());
		e.setAntragDauer(bo.getAntragDauer());
		e.setBewilligungDauer(bo.getBewilligungDauer());
		//e.setAntragStatus(bo.getAntragStatus());   needs a JOIN
		e.setAntragSumme(bo.getAntragSumme());
		e.setBewilligungSumme(bo.getBewilligungSumme());
		return e;
	}

	/**
	 * Map entity to BO.
	 *
	 * @param e the e
	 * @return the antrag BO
	 */
	public static final AntragBO mapEntityToBO(AntragEntity e) {
		AntragBO bo = new AntragBO();
		if(e != null) {
			bo.setId(e.getId());
			bo.setTitelDeutsch(e.getTitelDeutsch());
			bo.setTitelEnglisch(e.getTitelEnglisch());
			bo.setEingangsDatum(e.getEingangsDatum());
			bo.setAntragDauer(e.getAntragDauer());
			bo.setBewilligungDauer(e.getBewilligungDauer());
			//bo.setAntragStatus(e.getAntragStatus()); 	needs a JOIN
			bo.setAntragSumme(e.getAntragSumme());
			bo.setBewilligungSumme(e.getBewilligungSumme());
		return bo;
		}
		return null;
	}
}
