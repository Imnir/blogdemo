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
package de.dfg.demo.blog.dao;

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.neufa.antrag.bo.AntragBO;

import javax.ejb.Local;
import java.util.List;


/**
 * The Interface AntragDao.
 */
@Local
public interface BlogDao {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<BlogBO> findAllBlogs();

	/**
	 * Blog anlegen
	 *
	 *
	 */
	
	public void addBlog(BlogBO bo);

}