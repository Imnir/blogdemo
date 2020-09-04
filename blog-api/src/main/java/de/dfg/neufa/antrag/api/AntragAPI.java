package de.dfg.neufa.antrag.api;
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import de.dfg.neufa.antrag.bo.AntragBO;
 
@Path("antrag")
public interface AntragAPI {
 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/info")
	String getInfo(@Context SecurityContext securityContext);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/watchlist/{id}")
	Boolean toggleWatchlist(@Context SecurityContext securityContext, @PathParam("id") Long antragId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/watchlist/{id}")
	Boolean isOnWatchlist(@Context SecurityContext securityContext, @PathParam("id") Long antragId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/watchlist")
	List<AntragBO> getWatchlist(@Context SecurityContext securityContext);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	AntragBO getAntragById(@PathParam("id") Long antragId);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/titel/{titel}")
	List<AntragBO> findAntragById(@PathParam("titel") String titel);

}