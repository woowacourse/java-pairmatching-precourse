package pairmatching.domains.crew;

import java.util.HashMap;
import java.util.Map;

public class CrewPair {
	Map<Crew, Crew> crewMap = new HashMap<>();

	public void clear() {
		crewMap.clear();
	}
}
