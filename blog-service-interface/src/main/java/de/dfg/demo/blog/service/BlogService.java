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

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import de.dfg.demo.blog.bo.BlogBO;


/**
 * The Interface AntragService.
 */
@Local
public interface BlogService {

	List<BlogBO> findAllBlogs();

	void speichern(BlogBO bo);

	List<BlogBO> findBlogByDate(LocalDate date);

	BlogBO getBlogByID (Long id);

	void deleteBlog (Long id);

	void changeBlog (Long id, BlogBO bo);

}
