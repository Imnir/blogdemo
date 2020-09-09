package de.dfg.demo.blog.api.impl;

import de.dfg.demo.blog.api.BlogAPI;
import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.demo.blog.service.BlogService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@SessionScoped
public class BlogAPIImpl implements BlogAPI, Serializable {

	@EJB
	BlogService blogservice;

	@Override
	public String getInfo(){
		String msg = "Mein erster Webservice !!!";
		return msg;
	}

	@Override
	public List<BlogBO> findAllBlogs() {
		return blogservice.findAllBlogs();
	}

	@Override
	public void speichern(BlogBO bo) {
		blogservice.speichern(bo);
	}

	@Override
	public void deleteBlog(Long id) {

	}

	@Override
	public BlogBO getBlogById(Long id) {
		return blogservice.getBlogByID(id);
	}

	@Override
	public List<BlogBO> findBlogByDate(LocalDate date) {
		return blogservice.findBlogByDate(date);
	}

}