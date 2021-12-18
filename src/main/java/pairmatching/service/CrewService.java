package pairmatching.service;

import pairmatching.domain.crew.BackendCrews;
import pairmatching.domain.crew.FrontendCrews;

public class CrewService {
	private BackendCrews backendCrews;
	private FrontendCrews frontendCrews;

	public CrewService(BackendCrews backendCrews, FrontendCrews frontendCrews) {
		this.backendCrews = backendCrews;
		this.frontendCrews = frontendCrews;
	}
}
