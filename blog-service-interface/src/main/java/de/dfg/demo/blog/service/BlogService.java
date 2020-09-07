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
package de.dfg.demo.blog.service;

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.neufa.antrag.bo.AntragBO;

import javax.ejb.Local;
import java.util.List;


/**
 * The Interface AntragService.
 */
@Local
public interface BlogService {

	public List<BlogBO> findAllBlogs();
	public void speichern(BlogBO bo);

}
