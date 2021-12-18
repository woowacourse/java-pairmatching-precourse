package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Pairs {
	private static List<Pair> pairList = new ArrayList<>();

	public static List<Pair> createPair(List<Crew> crewList, Mission mission) {
		List<Crew> shuffle = Randoms.shuffle(crewList);
		for (int i = 0; i < shuffle.size()-4; i+=2) {
			pairList.add(new Pair(mission, crewList.subList(i, i + 2)));
		}
		pairList.add(new Pair(mission, crewList.subList(shuffle.size() - 3, shuffle.size())));
		return pairList;
	}
}
