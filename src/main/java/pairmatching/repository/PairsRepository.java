package pairmatching.repository;

import java.util.LinkedList;
import java.util.List;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.pair.Pairs;
import pairmatching.exception.NoPairsException;

public class PairsRepository {
	private static final List<Pairs> pairsList = new LinkedList<>();

	public static boolean contains(Course course, Level level, String mission) {
		return pairsList.stream()
			.filter(pairs -> pairs.getCourse().equals(course))
			.filter(pairs -> pairs.getLevel().equals(level))
			.filter(pairs -> pairs.getMission().equals(mission))
			.count() > 0;
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

}
