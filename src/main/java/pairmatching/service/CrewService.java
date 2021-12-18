package pairmatching.service;

import java.util.List;

import pairmatching.repository.CrewRepository;
import pairmatching.util.CrewReadUtils;

public class CrewService {
	private CrewRepository crewRepository;

	public CrewService() {
		List<String> frontendCrews = CrewReadUtils.readFrontendCrews();
		List<String> backendCrews = CrewReadUtils.readBackendCrews();
		this.crewRepository = new CrewRepository(frontendCrews, backendCrews);
	}
}
