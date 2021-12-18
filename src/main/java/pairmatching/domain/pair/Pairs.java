package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.level.Level;

public class Pairs {
	private static final int DEFAULT_PAIR_COUNT = 2;
	private static final int ODD_PAIR_COUNT = 3;

	private final Set<Pair> pairs;
	private final Course course;
	private final Level level;
	private final String mission;

	private Pairs(Course course, Level level, String mission, Set<Pair> pairs) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pairs = pairs;
	}

	public static Pairs createRandom(Course course, Level level, String mission, List<Crew> crews) {
		// TODO: 리팩토링 필요
		List<Crew> remainingCrews = Randoms.shuffle(crews);
		Set<Pair> pairs = new LinkedHashSet<>();

		while (remainingCrews.size() > 0) {
			pairs.add(getRandomPair(remainingCrews));
		}

		return new Pairs(course, level, mission, pairs);
	}

	private static Pair getRandomPair(List<Crew> remainingCrews) {
		List<Crew> pair = new ArrayList<>();

		int pairCount = DEFAULT_PAIR_COUNT;
		if (remainingCrews.size() == ODD_PAIR_COUNT) {
			pairCount = ODD_PAIR_COUNT;
		}
		for (int i = 0; i < pairCount; i++) {
			pair.add(remainingCrews.get(0));
			remainingCrews.remove(0);
		}

		return Pair.from(pair);
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	@Override
	public String toString() {
		return course + " | " + level + " | " + mission + " | " + pairs.toString();
	}
}
