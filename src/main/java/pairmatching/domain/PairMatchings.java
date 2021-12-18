package pairmatching.domain;

import java.util.List;
import java.util.Optional;

public class PairMatchings {
	public List<PairMatching> pairMatchings;

	public void initialization() {
		pairMatchings.clear();
	}

	public Optional<PairMatching> find(PairMatching pairMatching) {
		return pairMatchings.stream()
			.filter(e -> e.getCourse() == pairMatching.getCourse() && e.getLevel() == pairMatching.getLevel()
				&& e.getMission() == pairMatching.getMission())
			.findAny();
	}
}
