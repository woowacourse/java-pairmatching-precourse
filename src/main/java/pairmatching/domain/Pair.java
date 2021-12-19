package pairmatching.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.constant.Level;
import pairmatching.exception.MatchFailException;

public class Pair {
	private Set<Crew> crewSet;

	public Pair(Level level, Crew... crews) throws MatchFailException {
		this.crewSet = new HashSet<>();
		Arrays.stream(crews).forEach(crew -> validateCrew(level, crew));
		crewSet.addAll(Arrays.asList(crews));
		Arrays.stream(crews).forEach(crew -> addHistory(level, crew));
	}

	private void validateCrew(Level level, Crew crew) {
		boolean didMeet = crewSet.stream().anyMatch(crewExisting -> crewExisting.didMeet(level, crew.getName()));
		if (didMeet)
			throw new MatchFailException("매칭에 실패했습니다. 이미 만난 적 있는 페어가 있습니다");
	}

	private void addHistory(Level level, Crew crew) {
		crewSet.forEach(crewExisting -> crewExisting.addHistory(level, crew.getName()));
	}

	public List<String> getCrews() {
		return crewSet.stream().map(Crew::getName).collect(Collectors.toList());
	}

	public int size() {
		return crewSet.size();
	}

	@Override
	public String toString() {
		return String.join(" : ", getCrews());
	}
}
