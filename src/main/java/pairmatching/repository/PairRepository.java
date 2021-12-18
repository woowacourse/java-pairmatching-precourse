package pairmatching.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class PairRepository {
	public static LinkedHashMap<String, List<Pairs>> backPairs = new LinkedHashMap<>();
	public static LinkedHashMap<String, List<Pairs>> frontPairs = new LinkedHashMap<>();

	public static void reset() {
		backPairs = new LinkedHashMap<>();
		frontPairs = new LinkedHashMap<>();
	}

	public static boolean validateBackPairs(String mission, Pairs pairs) {
		List<Pairs> pairsList = backPairs.get(mission);
		for (Pairs Source : pairsList) {
			if (!checkEachPair(Source, pairs)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkEachPair(Pairs source, Pairs pairs) {
		List<Pair> pairList = pairs.getPairList();
		for (Pair pair : pairList) {
			if (source.contains(pair)) {
				return false;
			}
		}
		return true;
	}

	public static void addBackPairs(String mission, Pairs pairs) {
		List<Pairs> emptyList = new ArrayList<>();
		List<Pairs> pairsList = backPairs.getOrDefault(mission, emptyList);
		pairsList.add(pairs);
		backPairs.put(mission, pairsList);
	}

	public static boolean validateFrontPairs(String mission, Pairs pairs) {
		List<Pairs> pairsList = frontPairs.get(mission);
		for (Pairs Source : pairsList) {
			if (!checkEachPair(Source, pairs)) {
				return false;
			}
		}
		return true;
	}

	public static void addFrontPairs(String mission, Pairs pairs) {
		List<Pairs> emptyList = new ArrayList<>();
		List<Pairs> pairsList = frontPairs.getOrDefault(mission, emptyList);
		pairsList.add(pairs);
		frontPairs.put(mission, pairsList);
	}
}
