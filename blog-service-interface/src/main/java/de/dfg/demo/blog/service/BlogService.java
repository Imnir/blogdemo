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

	public List<BlogBO> findAllBlogs();

	public void speichern(BlogBO bo);

	public List<BlogBO> findBlogByDate(LocalDate date);

	public BlogBO getBlogByID (Long id);

	public void deleteBlog (Long id);

}
