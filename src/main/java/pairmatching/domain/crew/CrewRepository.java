package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

	public Set<Crew> getCrews(Level level) {
		HashSet<Crew> crews = new HashSet<>();
		for (Map.Entry<Level, Crew> entry : this.crews.entrySet()) {
			if (entry.getKey() != level) {
				continue;
			}
			crews.add(entry.getValue());
		}

		return crews;
	}

}
