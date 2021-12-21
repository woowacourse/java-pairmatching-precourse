package pairmatching.domain;

import static pairmatching.constant.ErrorMessage.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PairMatching {

	private static final int TRY_AGAIN_LIMIT = 3;

	private HashMap<Curriculum, List<String>> matchingPair;
	private static final CrewGroup crewGroup = new CrewGroup();

	public PairMatching() {
		matchingPair = new HashMap<>();
	}

	public void run(Curriculum curriculum) {
		matchingPair.put(curriculum, matchCrews(curriculum));
	}

	private List<String> matchCrews(Curriculum curriculum) {
		for (int i = 0; i < TRY_AGAIN_LIMIT; i++) {
			List<String> shuffledCrews = crewGroup.getShuffledCrewNames(curriculum.getCourse());
			// get 안쓰는 방법을 생각해보아야 한다.
			if (!checkMetBefore(shuffledCrews, curriculum)) {
				return shuffledCrews;
			}
		}
		throw new IllegalArgumentException(NO_MATCHING_WAY);
	}

	public boolean isEmpty(Curriculum curriculum) {
		return matchingPair.keySet().stream()
			.noneMatch(thisCurriculum -> thisCurriculum.equals(curriculum));
	}

	public List<String> getMatching(Curriculum curriculum) {
		if (!isEmpty(curriculum)) {
			throw new IllegalArgumentException(NO_MATCHING_LOG);
		}
		return matchingPair.entrySet().stream()
			.filter(entry -> entry.getKey().equals(curriculum))
			.map(Map.Entry::getValue)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(DEFAULT));
	}

	private boolean checkMetBefore(List<String> crews, Curriculum curriculum) {
		// 비교구현
		return false;
	}

	public void clearMatching() {
		matchingPair = new HashMap<>();
	}
}
