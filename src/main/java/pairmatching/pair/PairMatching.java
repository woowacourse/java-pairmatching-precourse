package pairmatching.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.crew.Crew;
import pairmatching.crew.CrewRepository;

public class PairMatching {
	private static final String ERROR_NOT_MATCHING = "매칭 할 수 없습니다.";
	private static final String ERROR_NOT_FOUND_MATCHING = "매칭 이력이 없습니다.";
	private static final int MAXIMUM_TIME = 3;
	private static final int ZERO = 0;
	private static final int LAST_ONE = 1;
	private static final int PAIR = 2;
	private static final int ODD = 1;

	private List<String> backendCrews;
	private List<String> frontendCrews;
	private List<Pair> pairs;

	public PairMatching() {
		this.backendCrews = loadBackendCrews();
		this.frontendCrews = loadFrontendCrews();
		this.pairs = new ArrayList<>();
	}

	private List<String> loadBackendCrews() {
		return CrewRepository.findBackendCrews()
			.stream()
			.map(Crew::toString)
			.collect(Collectors.toList());
	}

	private List<String> loadFrontendCrews() {
		return CrewRepository.findFrontendCrews()
			.stream()
			.map(Crew::toString)
			.collect(Collectors.toList());
	}

	public boolean alreadyPairsByPairTarget(PairTarget pairTarget) {
		return pairs.stream().anyMatch(pair -> pair.isSamePairTarget(pairTarget));
	}

	public void resetPairs(PairTarget pairTarget) {
		List<Pair> remove = pairs.stream()
			.filter(pair -> pair.isSamePairTarget(pairTarget))
			.collect(Collectors.toList());
		for (Pair each : remove) {
			pairs.remove(each);
		}
	}

	public List<Pair> findPairsByPairTarget(PairTarget pairTarget) {
		List<Pair> pairs = this.pairs.stream()
			.filter(pair -> pair.isSamePairTarget(pairTarget))
			.collect(Collectors.toList());
		if (pairs.size() == ZERO) {
			throw new IllegalArgumentException(ERROR_NOT_FOUND_MATCHING);
		}
		return pairs;
	}

	public void repeatMatching(PairTarget pairTarget) {
		int matchingTry = ZERO;
		while (matchingTry < MAXIMUM_TIME)
			try {
				matching(pairTarget);
				return;
			} catch (IllegalArgumentException illegalArgumentException) {
				matchingTry++;
			}

		throw new IllegalArgumentException(ERROR_NOT_MATCHING);
	}

	private void matching(PairTarget pairTarget) {
		if (pairTarget.isBackend()) {
			List<String> shuffledCrew = Randoms.shuffle(backendCrews);
			randomMatching(shuffledCrew, pairTarget);
			return;
		}
		if (pairTarget.isFrontend()) {
			List<String> shuffledCrew = Randoms.shuffle(frontendCrews);
			randomMatching(shuffledCrew, pairTarget);
			return;
		}
	}

	private void randomMatching(List<String> shuffledCrew, PairTarget pairTarget) {
		if (shuffledCrew.size() % PAIR == ZERO) {
			evenMatching(shuffledCrew, pairTarget);
			return;
		}
		if (shuffledCrew.size() % PAIR == ODD) {
			oddMatching(shuffledCrew, pairTarget);
			return;
		}
	}

	private void evenMatching(List<String> shuffledCrew, PairTarget pairTarget) {
		for (int i = ZERO; i < shuffledCrew.size() / PAIR; i++) {
			List<String> crews = new ArrayList<>();
			crews.add(shuffledCrew.get(i * PAIR));
			crews.add(shuffledCrew.get(i * PAIR + ODD));
			addPair(new Pair(crews, pairTarget));
		}
	}

	private void oddMatching(List<String> shuffledCrew, PairTarget pairTarget) {
		for (int i = ZERO; i < shuffledCrew.size() / PAIR; i++) {
			List<String> crews = new ArrayList<>();
			crews.add(shuffledCrew.get(i * PAIR));
			crews.add(shuffledCrew.get(i * PAIR + ODD));
			if (i == shuffledCrew.size() / PAIR - LAST_ONE) {
				crews.add(shuffledCrew.get(shuffledCrew.size() - LAST_ONE));
			}
			addPair(new Pair(crews, pairTarget));
		}
	}

	private void addPair(Pair pair) {
		validateDuplicateMatching(pair);
		pairs.add(pair);
	}

	private void validateDuplicateMatching(Pair pair) {
		if (pairs.stream().anyMatch(each -> each.isDuplicate(pair))) {
			throw new IllegalArgumentException(ERROR_NOT_MATCHING);
		}
	}
}
