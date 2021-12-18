package pairmatching.model;

import java.util.HashSet;
import java.util.Set;

public class MatchingHistory {
	private Set<Matching> history = new HashSet<>();

	public boolean has(Matching newMatching) {
		return history.stream()
			.anyMatch(matching -> matching.equals(newMatching));
	}

	public Matching getSameMatch(Matching newMatching) {
		return history.stream()
			.filter(matching -> matching.equals(newMatching))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 매칭이 존재하지 않습니다."));
	}

	public void add(Matching newMatching) {
		Matching origin = getSameMatch(newMatching);
		history.remove(origin);
		history.add(newMatching);
	}
}
