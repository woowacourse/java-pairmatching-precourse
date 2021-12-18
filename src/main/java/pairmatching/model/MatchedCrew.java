package pairmatching.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchedCrew {
	private Map<Level, List<Crew>> matchedCrew = new HashMap<>();

	public void add(Level level, Crew crew) {
		if (matchedCrew.containsKey(level)) {
			List<Crew> crewList = matchedCrew.get(level);
			if (crewList.contains(crew)) {
				throw new IllegalArgumentException("이미 매칭된 적 있는 크루입니다");
			}
			crewList.add(crew);
			matchedCrew.put(level, crewList);
		}
		matchedCrew.put(level, Arrays.asList(crew));
	}
}
