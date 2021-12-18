package pairmatching.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;

public class PairService {

	public static void resetPairs() {
		PairRepository.reset();
	}

	public static void makeBackPairs(String mission) {
		List<Crew> shuffleCrew = Randoms.shuffle(CrewRepository.backCrew);
		Pairs pairs = null;
		if (shuffleCrew.size() % 2 == 0) {
			pairs = new Pairs(makePairsWhenEven(shuffleCrew));
		}
		if (shuffleCrew.size() % 2 == 1) {
			pairs = new Pairs(makePairsWhenOdd(shuffleCrew));
		}
		if (PairRepository.validateBackPairs(mission, pairs)) {
			PairRepository.addBackPairs(mission, pairs);
		}
	}

	public static void makeFrontPairs(String mission) {
		List<Crew> shuffleCrew = Randoms.shuffle(CrewRepository.frontCrew);
		Pairs pairs = null;
		if (shuffleCrew.size() % 2 == 0) {
			pairs = new Pairs(makePairsWhenEven(shuffleCrew));
		}
		if (shuffleCrew.size() % 2 == 1) {
			pairs = new Pairs(makePairsWhenOdd(shuffleCrew));
		}
		if (PairRepository.validateFrontPairs(mission, pairs)) {
			PairRepository.addFrontPairs(mission, pairs);
		}
	}

	private static List<Pair> makePairsWhenEven(List<Crew> shuffleCrew) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < shuffleCrew.size(); i += 2) {
			Set<Crew> pair = new HashSet<>();
			pair.add(shuffleCrew.get(i));
			pair.add(shuffleCrew.get(i + 1));
			pairs.add(new Pair(pair));
		}
		return pairs;
	}

	private static List<Pair> makePairsWhenOdd(List<Crew> shuffleCrew) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < shuffleCrew.size() - 3; i += 2) {
			Set<Crew> pair = new HashSet<>();
			pair.add(shuffleCrew.get(i));
			pair.add(shuffleCrew.get(i + 1));
			pairs.add(new Pair(pair));
		}
		Set<Crew> pair = new HashSet<>();
		for (int i = 3; i > 0; i--) {
			pair.add(shuffleCrew.get(shuffleCrew.size() - i));
		}
		pairs.add(new Pair(pair));
		return pairs;
	}

	public static void getBackPairs(String mission) {

	}

	public static void getFrontPairs(String mission) {

	}
}
