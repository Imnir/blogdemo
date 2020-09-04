package de.dfg.neufa.antrag.api.impl;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import de.dfg.neufa.antrag.api.AntragAPI;
import de.dfg.neufa.antrag.bo.AntragBO;
import de.dfg.neufa.antrag.service.AntragService;
import de.dfg.neufa.authentication.LoggedInUser;
 
@SessionScoped
public class AntragAPIImpl implements AntragAPI, Serializable {

	@EJB
	private AntragService antragService;

	private List<Long> watchList = new ArrayList<>();

	@Override
	public AntragBO getAntragById(Long id) {
		return antragService.getAntraegeById(id);
	}

	@Override
	public String getInfo(@Context SecurityContext securityContext) {
		LoggedInUser loggedInUser = new LoggedInUser(securityContext);
		return loggedInUser.getUserFirstnameLastname();
	}

	@Override
	public List<AntragBO> findAntragById(String titel) {
		return antragService.findAntraegeByTitel(titel);
	}


	@Override
	public Boolean isOnWatchlist(SecurityContext securityContext, Long antragId) {
		return watchList.contains(antragId);
	}


	@Override
	public List<AntragBO> getWatchlist(SecurityContext securityContext) {
		List<AntragBO> myWatchList = new ArrayList<>();
		for (Long antraId : watchList) {
			myWatchList.add(antragService.getAntraegeById(antraId));
		}
		return myWatchList;
	}

	@Override
	public Boolean toggleWatchlist(SecurityContext securityContext, Long antragId) {
		if (!watchList.contains(antragId)) {
			watchList.add(antragId);
		} else {
			watchList.remove(antragId);
		}
		return watchList.contains(antragId);
	}
}