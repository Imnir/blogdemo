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
package de.dfg.demo.blog.dao.mapper;

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.demo.blog.dao.entity.BlogEntity;

import java.io.Serializable;

/**
 * The Class AntragMapper.
 */
public class BlogMapper implements Serializable {

	/**
	 * Map BO to entity.
	 *
	 * @param bo the bo
	 * @return the antrag entity
	 */
	public static final BlogEntity mapBOToEntity(BlogBO bo) {
		BlogEntity e = new BlogEntity();
		e.setId(bo.getId());
		e.setTitel(bo.getTitel());
		e.setDatum(bo.getDatum());
		e.setText(bo.getBlogtext());
		e.setAuthor(bo.getAutor());
		return e;
	}

	/**
	 * Map entity to BO.
	 *
	 * @param e the e
	 * @return the antrag BO
	 */
	public static final BlogBO mapEntityToBO(BlogEntity e) {
		BlogBO bo = new BlogBO();
		if(e != null) {
			bo.setId(e.getId());
			bo.setTitel(e.getTitel());
			bo.setDatum(e.getDatum());
			bo.setAutor(e.getAuthor());
			bo.setBlogtext(e.getText());
		return bo;
		}
		return null;
	}
}
