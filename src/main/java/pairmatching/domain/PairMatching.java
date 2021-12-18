package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PairMatching {
	private HashMap<Curriculum, List<String>> matchingPair;
	private HashMap<String, String> matchingLog;
	private CrewGroup crewGroup = new CrewGroup();

	public PairMatching() {
	}

	public void run(Curriculum curriculum) {
		if (isEmpty(curriculum)) {
			matchingPair.put(curriculum, crewGroup.getShuffledCrews());
		}
	}

	public List<String> printMatching(Curriculum curriculum) {
		if (isEmpty(curriculum)) {
			throw new IllegalArgumentException();
		}
		return matchingPair.entrySet().stream()
			.filter(cur -> cur.getKey().equals(curriculum))
			.map(Map.Entry::getValue)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("못찾았습니다."));
	}

	public boolean isEmpty(Curriculum curriculum) {
		Optional<Curriculum> curriculumOptional = matchingPair.keySet().stream()
			.filter(cur -> cur.equals(curriculum))
			.findAny();
		return curriculumOptional.isPresent();
	}

	public void clearMatching() {
		matchingPair = new HashMap<>();

	}
}
