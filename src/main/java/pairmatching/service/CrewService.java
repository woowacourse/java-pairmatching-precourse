package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Course;
import pairmatching.repository.CrewRepository;
import pairmatching.util.CrewReadUtils;

public class CrewService {
	private CrewRepository crewRepository;

	public CrewService() {
		CrewReadUtils crewReadUtils = new CrewReadUtils();
		List<String> frontendCrews = crewReadUtils.readFrontendCrews();
		List<String> backendCrews = crewReadUtils.readBackendCrews();
		this.crewRepository = new CrewRepository(frontendCrews, backendCrews);
	}

	public List<String> getCrewsShuffled(Course course) {
		return Randoms.shuffle(crewRepository.getCrews(course));
	}
}
