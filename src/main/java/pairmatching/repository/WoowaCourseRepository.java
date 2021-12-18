package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pairmatching.domain.PairMatching;
import pairmatching.domain.WoowaCourse;

public class WoowaCourseRepository {

	private static final Map<WoowaCourse, PairMatching> woowaCourses = new HashMap<>();

	public Optional<WoowaCourse> findOne(WoowaCourse woowaCourse) {
		return woowaCourses.keySet().stream().filter(course -> course.equals(woowaCourse)).findAny();
	}
}
