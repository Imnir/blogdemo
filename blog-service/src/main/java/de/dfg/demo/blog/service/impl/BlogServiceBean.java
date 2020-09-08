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

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.demo.blog.dao.BlogDao;
import de.dfg.demo.blog.service.BlogService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;


/**
 * The Class AntragServiceBean.
 */
@Stateless
public class BlogServiceBean implements BlogService {

	@EJB
	BlogDao blogdao;
	static long id = 0;

	@Override
	public List<BlogBO> findAllBlogs() {
		BlogBO bo = new BlogBO();
		bo.setBlogtext("Text");
		bo.setAutor("Autor");
		bo.setTitel("Titel");
		this.speichern(bo);
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
}
