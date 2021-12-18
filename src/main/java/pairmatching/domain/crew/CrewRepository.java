package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Level;

public class CrewRepository {

	private final Map<Level, Crew> crews;

	public CrewRepository() {
		this.crews = new HashMap<>();
		crews.put(Level.LEVEL1, null);
		crews.put(Level.LEVEL2, null);
		crews.put(Level.LEVEL3, null);
		crews.put(Level.LEVEL4, null);
		crews.put(Level.LEVEL5, null);
	}

	public void init() {
		crews.clear();
		crews.put(Level.LEVEL1, null);
		crews.put(Level.LEVEL2, null);
		crews.put(Level.LEVEL3, null);
		crews.put(Level.LEVEL4, null);
		crews.put(Level.LEVEL5, null);
	}

	public List<Crew> getCrews(Level level) {
		List<Crew> crews = new LinkedList<>();
		for (Map.Entry<Level, Crew> entry : this.crews.entrySet()) {
			if (entry.getKey() != level) {
				continue;
			}
			crews.add(entry.getValue());
		}

		return crews;
	}

}
