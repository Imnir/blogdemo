package de.dfg.demo.blog.api;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.dfg.demo.blog.bo.BlogBO;

@Path("blog")
public interface BlogAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blogs")
	List<BlogBO> findAllBlogs();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void speichern(BlogBO bo);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/change")
	void changeBlog(Long id, BlogBO bo);

	@DELETE
	@Path("/{blogId}")
	void deleteBlog(@PathParam("blogId") Long id);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	BlogBO getBlogById(Long id);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/date")
	List<BlogBO> findBlogByDate (LocalDate date);

}