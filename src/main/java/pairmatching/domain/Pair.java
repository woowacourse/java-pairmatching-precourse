package pairmatching.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pairmatching.constant.ExceptionMessage;
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
			throw new MatchFailException(ExceptionMessage.MATCHING_FAIL);
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
