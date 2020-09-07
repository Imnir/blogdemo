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
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class AntragServiceBean.
 */
@Stateless
public class BlogServiceBean implements BlogService {

	@EJB
	BlogDao blogdao;

	@Override
	public List<BlogBO> findAllBlogs() {
		BlogBO blog1 = new BlogBO();
		blog1.setAutor("Ich");
		blog1.setBlogtext("Test");
		blog1.setTitel("Titel");
		blog1.setDatum(LocalDate.now());


		BlogBO blog2 = blog1;
		List<BlogBO> list = new ArrayList<>();

		list.add(blog1);
		list.add(blog2);

		return list;
	}
}
