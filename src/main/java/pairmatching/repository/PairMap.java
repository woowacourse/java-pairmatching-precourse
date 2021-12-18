package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairKey;

public class PairMap {
	private static final Map<PairKey, List<Crew>> pairs = new HashMap<>();

	public static boolean contains(String course, String level, String mission) {
		PairKey key = new PairKey(Course.find(course), Level.find(level), Mission.find(mission));
		return pairs.containsKey(key);
	}

	public static void add(PairKey key, List<Crew> crews) {
		pairs.put(key, crews);
	}
}
