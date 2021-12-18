package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pairmatching.domain.PairMatching;
import pairmatching.domain.WoowaCourse;

public class WoowaCourseRepository {

	private static final Map<WoowaCourse, PairMatching> woowaCourses = new HashMap<>();

	public Optional<Map.Entry<WoowaCourse, PairMatching>> findOne(WoowaCourse woowaCourse) {
		return woowaCourses.entrySet().stream().filter(course -> course.getKey().equals(woowaCourse)).findAny();
	}

	public Map<WoowaCourse, PairMatching> get() {
		Map<WoowaCourse, PairMatching> map = new HashMap<>(woowaCourses);
		return map;
	}

	public void add(WoowaCourse woowaCourse, PairMatching pairMatching) {
		woowaCourses.put(woowaCourse, pairMatching);
	}

	public void clearAll() {
		woowaCourses.clear();
	}
}
