package de.dfg.demo.blog.api;

import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.neufa.antrag.bo.AntragBO;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
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

}