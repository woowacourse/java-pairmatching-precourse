package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Pairs {
	// private static List<Pair> pairList = new ArrayList<>();
	private static Map<Mission, List<Pair>> missionListMap = new HashMap<>();

	public static List<Pair> getPairList(Mission mission) {
		return missionListMap.get(mission);
	}

	public static void createPair(List<Crew> crewList, Mission mission) {
		List<Crew> shuffle = Randoms.shuffle(crewList);
		List<Pair> pairList = new ArrayList<>();
		for (int i = 0; i < shuffle.size()-4; i+=2) {
			pairList.add(new Pair(mission, shuffle.subList(i, i + 2)));
		}
		pairList.add(new Pair(mission, shuffle.subList(shuffle.size() - 3, shuffle.size())));
		missionListMap.put(mission, pairList);
	}

	public static boolean isExistPair(Mission mission) {
		if (missionListMap.containsKey(mission)) {
			return true;
		}
		return false;
	}

	public static void initializePairs() {
		for (Mission mission : missionListMap.keySet()) {
			missionListMap.get(mission).clear();
		}
	}
}
