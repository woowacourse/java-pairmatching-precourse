package pairmatching.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Pairs {
	private static final List<Pair> pairs = new ArrayList<>();

	public static final List<Pair> pairs() {
		return Collections.unmodifiableList(pairs);
	}

	public static void addPair(Pair pair) {
		pairs.add(pair);
	}

	public static List<Pair> backendPairMatch() {
		List<Pair> pairs = new ArrayList<>();
		List<String> crewList;
		crewList = Randoms.shuffle(CrewRepository.findByCourse(Course.BACKEND));

		for (int i = 0; i < crewList.size(); i += 2) {
			List<String> pair = new ArrayList<>();
			pair.add(crewList.get(i));
			pair.add(crewList.get(i + 1));

			pairs.add(new Pair(pair));
		}

		return pairs;
	}

	public static List<Pair> frontendPairMatch() {
		List<Pair> pairs = new ArrayList<>();
		List<String> crewList;
		crewList = Randoms.shuffle(CrewRepository.findByCourse(Course.FRONTEND));

		for (int i = 0; i < crewList.size(); i = i + 2) {
			List<String> pair = new ArrayList<>();
			pair.add(crewList.get(i));
			pair.add(crewList.get(i + 1));

			pairs.add(new Pair(pair));
		}

		return pairs;
	}
}
