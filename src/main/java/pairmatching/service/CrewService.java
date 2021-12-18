package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Pair;
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

	public boolean didMeet(Course course, Level level, String name, String opponent) {
		return crewRepository.findByName(course, name).didMeet(level,opponent);
	}

	public void addToHistory(Course course, Level level, List<Pair> pairList) {
		pairList.forEach(pair -> {
			addToHistoryEach(course,level,pair);
		});
	}

	private void addToHistoryEach(Course course, Level level, Pair pair){
		pair.getCrews().forEach(s -> {
			pair.getCrewsExcept(s).forEach(s1 -> {
				crewRepository.findByName(course, s).addHistory(level, s1);
			});
		});
	}
}
