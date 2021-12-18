package pairmatching.repository;

import java.util.LinkedList;
import java.util.List;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;
import pairmatching.exception.NoPairsException;

public class PairsRepository {
	private static final List<Pairs> pairsList = new LinkedList<>();

	public static boolean contains(Course course, Level level, String mission) {
		return pairsList.stream()
			.filter(pairs -> pairs.getCourse().equals(course))
			.filter(pairs -> pairs.getLevel().equals(level))
			.anyMatch(pairs -> pairs.getMission().equals(mission));
	}

	public static void create(Pairs pairs) {
		pairsList.add(pairs);
	}

	public static Pairs find(Course course, Level level, String mission) {
		return pairsList.stream()
			.filter(pairs -> pairs.getCourse().equals(course))
			.filter(pairs -> pairs.getLevel().equals(level))
			.filter(pairs -> pairs.getMission().equals(mission))
			.findFirst()
			.orElseThrow(NoPairsException::new);
	}

	public static void clear() {
		pairsList.clear();
	}

	public static boolean existsOtherLevel(Pairs newPairs) {
		for (Pairs pairs : pairsList) {
			if (checkDuplicate(pairs, newPairs)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkDuplicate(Pairs pairs, Pairs newPairs) {
		for (Pair newPair : newPairs.getPairList()) {
			boolean hasPair = pairs.hasPair(newPair);
			if (hasPair) {
				return true;
			}
		}
		return false;
	}

}
