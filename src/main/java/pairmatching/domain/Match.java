package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Match {
	private MatchingInformation information;
	private List<Pair> pairList;

	private Match(MatchingInformation information, List<Pair> pairList) {
		this.information = information;
		this.pairList = pairList;
	}

	public static Match of(MatchingInformation information) {
		List<Pair> pairList = getPairList(Randoms.shuffle(CrewRepository.getCrews(information.getCourse())));
		return new Match(information, pairList);
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
			pairList.add(new Pair(crewList.get(i), crewList.get(i+1)));
		}
		return pairList;
	}

	private static List<Pair> oddCrewPair(List<Crew> crewList) {
		List<Pair> pairList = new ArrayList<>();
		int size = crewList.size();
		for (int i = 0; i < size - 3; i += 2) {
			pairList.add(new Pair(crewList.get(i), crewList.get(i+1)));
		}
		pairList.add(new Pair(crewList.get(size -3), crewList.get(size -2), crewList.get(size -1)));
		return pairList;
	}
}
