package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairRepository {
	private static List<Pair> pairs = new ArrayList<>();

	public static void save(Pair pair) {
		pairs.add(pair);
	}

	public static void saveAll(List<Pair> pairList) {
		pairs.addAll(pairList);
	}

	public static List<Pair> findAll() {
		return pairs;
	}

	public static List<Pair> findByMission(Mission mission) {
		return pairs.stream().filter(p -> p.getMission().equals(mission)).collect(Collectors.toList());
	}
}
