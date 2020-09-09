package de.dfg.demo.blog.api;

import de.dfg.demo.blog.bo.BlogBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("blog")
public interface BlogAPI {
 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/info")
	String getInfo();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blogs")
	List<BlogBO> findAllBlogs();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void speichern(BlogBO bo);

	@DELETE
	@Path("/blog/{blogId}")
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