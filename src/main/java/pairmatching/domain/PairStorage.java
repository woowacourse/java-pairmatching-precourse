package pairmatching.domain;

import java.util.HashMap;

public class PairStorage {
	public HashMap<Level, HashMap<String, Pairs>> backEndPair = new HashMap<>();
	public HashMap<Level, HashMap<String, Pairs>> frontEndPair = new HashMap<>();

	public void initPairStorage() {
		backEndPair = new HashMap<>();
		frontEndPair = new HashMap<>();
	}

	public Pairs getPairs(Level level, String mission, String course) {
		try {
			if (course.equals(Course.BACKEND.getName())) {
				return backEndPair.get(level).get(mission);
			}
			return frontEndPair.get(level).get(mission);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
	}
}
