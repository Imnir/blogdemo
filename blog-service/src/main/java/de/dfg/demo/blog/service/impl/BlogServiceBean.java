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
import de.dfg.demo.blog.service.BlogService;
import de.dfg.neufa.DFGLogging;
import de.dfg.neufa.antrag.bo.AntragBO;
import de.dfg.neufa.antrag.dao.AntragDao;
import de.dfg.neufa.antrag.service.AntragService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


/**
 * The Class AntragServiceBean.
 */
@Stateless
public class BlogServiceBean implements BlogService {


	@Override
	public List<BlogBO> findAllBlogs() {
		BlogBO blog1 = new BlogBO();
		blog1.setAutor("Ich");
		blog1.setBlogtext("Test");
		blog1.setTitel("Titel");
		blog1.setDatum(new Date());

		BlogBO blog2 = blog1;
		List<BlogBO> list = new ArrayList<>();

		list.add(blog1);
		list.add(blog2);

		return list;
	}
}
