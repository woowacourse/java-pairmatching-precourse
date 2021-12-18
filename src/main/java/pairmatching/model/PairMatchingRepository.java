package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class PairMatchingRepository {
	private static final Map<Level, Map<Course, Pairs>> repository = new HashMap<>();

	public static void save(Pairs pairs, Level level, Course course) {
		Map<Course, Pairs> pairsListByLevel = findByLevel(level);
		pairsListByLevel.put(course, pairs);

		repository.put(level, pairsListByLevel);
	}

	public static Map<Course, Pairs> findByLevel(Level level) {
		return repository.get(level);
	}

}
