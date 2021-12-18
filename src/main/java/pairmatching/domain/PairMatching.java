package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PairMatching {
	private HashMap<Curriculum, List<String>> matchingPair;
	private HashMap<String, String> matchingLog;
	private CrewGroup crewGroup = new CrewGroup();

	public PairMatching() {
	}

	public void run(Curriculum curriculum) {
		List<String> crews = getCrews();
		if (isEmpty(curriculum)) {
			matchingPair.put(curriculum, crews);
			logMeet(crews, curriculum.getLevel());
		}
	}

	private List<String> getCrews() {
		for (int i = 0; i < 3; i++) {
			List<String> shuffledCrews = crewGroup.getShuffledCrews();
			if (!checkMetBefore(shuffledCrews)) {
				return shuffledCrews;
			}
		}
		throw new IllegalArgumentException("3회 초과");
	}

	public boolean isEmpty(Curriculum curriculum) {
		Optional<Curriculum> curriculumOptional = matchingPair.keySet().stream()
			.filter(cur -> cur.equals(curriculum))
			.findAny();
		return curriculumOptional.isPresent();
	}

	private void logMeet(List<String> crews, String level) {
		for (int i = 0; i < crews.size(); ) {
			matchingLog.put(crews.get(i) + level, crews.get(i + 1));
			matchingLog.put(crews.get(i + 1) + level, crews.get(i));
			i += 2;
		}
		if (crews.size() / 2 == 1) {
			matchingLog.put(crews.get(crews.size() - 1) + level, crews.get(crews.size() - 2));
			matchingLog.put(crews.get(crews.size() - 1) + level, crews.get(crews.size() - 3));
			matchingLog.put(crews.get(crews.size() - 2) + level, crews.get(crews.size() - 1));
			matchingLog.put(crews.get(crews.size() - 2) + level, crews.get(crews.size() - 1));
			matchingLog.put(crews.get(crews.size() - 3) + level, crews.get(crews.size() - 1));
			matchingLog.put(crews.get(crews.size() - 3) + level, crews.get(crews.size() - 1));
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

	private boolean checkMetBefore(List<String> crews) {

	}

	public void clearMatching() {
		matchingPair = new HashMap<>();

	}
}
