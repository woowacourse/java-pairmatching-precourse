package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.PairCrews;

public class PairMatchingRepository {
	private static final PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();

	private Map<Integer, PairCrews> pairCrewsMap = new HashMap<>();

	private PairMatchingRepository() {
	}

	public static PairMatchingRepository getInstance() {
		return pairMatchingRepository;
	}

	public void add(PairCrews pairCrews) {
		pairCrewsMap.put(pairCrews.hashCode(), pairCrews);
	}

	public PairCrews getPairCrews(int key) {
		return pairCrewsMap.get(key);
	}
}
