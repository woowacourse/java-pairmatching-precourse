package pairmatching.domain;

import static pairmatching.Constants.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.service.MatchService;

public class Match {
	private MatchingInformation information;
	private List<Pair> pairList;

	private Match(MatchingInformation information, List<Pair> pairList) {
		this.information = information;
		this.pairList = pairList;
	}

	public static Match of(MatchingInformation information) {
		int trial = 0;
		List<Pair> pairList;
		do {
			pairList = getRandomPairs(information);
			trial++;
		} while (MatchService.isDuplicatedPair(information.getLevel(), pairList) && trial < MAX_TRIAL);
		if (trial >= MAX_TRIAL) {
			throw new IllegalArgumentException(FAIL_UNTIL_MAX_TRIAL);
		}
		return new Match(information, pairList);
	}

	private static List<Pair> getRandomPairs(MatchingInformation information) {
		List<String> shuffleNames = Randoms.shuffle(CrewRepository.getCrewNames(information.getCourse()));
		List<Pair> pairList = getPairList(CrewRepository.getCrews(information.getCourse(), shuffleNames));
		return pairList;
	}

	private static List<Pair> getPairList(List<Crew> crewList) {
		if (crewList.size() % 2 != 0) {
			return oddCrewPair(crewList);
		}
		return evenCrewPair(crewList);
	}

	private static List<Pair> evenCrewPair(List<Crew> crewList) {
		List<Pair> pairList = new ArrayList<>();
		int size = crewList.size();
		for (int i = 0; i < size - 1; i += 2) {
			pairList.add(new Pair(crewList.get(i), crewList.get(i + 1)));
		}
		return pairList;
	}

	private static List<Pair> oddCrewPair(List<Crew> crewList) {
		List<Pair> pairList = new ArrayList<>();
		int size = crewList.size();
		for (int i = 0; i < size - 3; i += 2) {
			pairList.add(new Pair(crewList.get(i), crewList.get(i + 1)));
		}
		pairList.add(new Pair(crewList.get(size - 3), crewList.get(size - 2), crewList.get(size - 1)));
		return pairList;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	public boolean isLevel(Level level) {
		return level.equals(information.getLevel());
	}

	public boolean hasInformation(MatchingInformation information) {
		return this.information.equals(information);
	}

	public MatchingInformation getInformation() {
		return information;
	}
}
