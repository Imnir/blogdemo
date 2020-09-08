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
import java.time.LocalDate;
import java.util.List;


/**
 * The Interface AntragService.
 */
@Local
public interface BlogService {

	List<BlogBO> findAllBlogs();

	void speichern(BlogBO bo);

	List<BlogBO> findBlogByDate(LocalDate date);

	BlogBO getBlogByID (Long id);

}
