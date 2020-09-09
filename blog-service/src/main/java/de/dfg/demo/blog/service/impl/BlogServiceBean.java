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

package de.dfg.demo.blog.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.demo.blog.dao.BlogDao;
import de.dfg.demo.blog.service.BlogService;


/**
 * The Class AntragServiceBean.
 */
@Stateless
public class BlogServiceBean implements BlogService {

	@EJB
	BlogDao blogdao;
	private static long id = 0;

	@Override
	public List<BlogBO> findAllBlogs() {
		return blogdao.findAllBlogs();
	}

	@Override
	public void speichern(BlogBO bo) {
		bo.setId(id++);
		bo.setDatum(LocalDate.now());
		blogdao.addBlog(bo);
	}

	@Override
	public List<BlogBO> findBlogByDate(LocalDate date) {
		return blogdao.findBlogByDate(date);
	}

	@Override
	public BlogBO getBlogByID(Long id) {
		return blogdao.getBlogByID(id);
	}

	@Override
	public void deleteBlog(Long id) {
		blogdao.deleteBlog(id);
	}
}
