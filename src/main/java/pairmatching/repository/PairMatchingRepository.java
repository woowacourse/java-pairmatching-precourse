package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.PairMatching;

public class PairMatchingRepository {
	private static final PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();

	Map<Integer, PairMatching> pairMatchingMap = new HashMap<>();

	private PairMatchingRepository() {
	}

	public static PairMatchingRepository getInstance() {
		return pairMatchingRepository;
	}

	public void addPairMathching(PairMatching pairMatching) {
		pairMatchingMap.put(pairMatching.hashCode(), pairMatching);
	}
}
