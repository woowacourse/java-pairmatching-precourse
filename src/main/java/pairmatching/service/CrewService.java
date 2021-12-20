package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.ExceptionMessage;
import pairmatching.constant.Level;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.exception.MatchFailException;
import pairmatching.repository.CrewRepository;

public class CrewService {
	private final CrewRepository crewRepository;

	public CrewService(List<String> crewNames) {
		this.crewRepository = new CrewRepository(crewNames);
	}

	public List<Crew> getCrewsShuffled() {
		return Randoms.shuffle(crewRepository.getCrewNames())
			.stream()
			.map(name -> crewRepository.findByName(name).orElseThrow(() -> new MatchFailException(
				ExceptionMessage.INVALID_CREW)))
			.collect(
				Collectors.toList());
	}

	public Mission match(Mission mission, int trialNumber) {
		try {
			return matchOnce(mission);
		} catch (MatchFailException e) {
			if (trialNumber == 3)
				throw new MatchFailException(ExceptionMessage.MATCHING_FAIL);
			return match(mission, trialNumber + 1);
		}
	}

	private Mission matchOnce(Mission mission) throws MatchFailException {
		List<Crew> crews = getCrewsShuffled();
		List<Pair> result = new ArrayList<>();

		int index = 0;
		while (index < crews.size()) {
			Pair pair = getPairFromCrews(crews, mission.getLevel(), index);
			result.add(pair);
			index += pair.size();
		}

		mission.setPairList(result);
		return mission;
	}

	public void clearHistories() {
		crewRepository.clearHistories();
	}

	private Pair getPairFromCrews(List<Crew> crews, Level level, int index) {
		if (crews.size() - index == 3)
			return new Pair(level, crews.get(index), crews.get(index + 1),
				crews.get(index + 2));
		return new Pair(level, crews.get(index), crews.get(index + 1));
	}
}
