package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BackendCrewRepository extends CrewRepository {
	private static final ArrayList<Crew> backendCrews = new ArrayList<>();
	private static final Map<Crew, List<Crew>> backendPairs = new HashMap<>();

	public static void add(Crew crew) {
		addCrew(backendCrews, crew);
		addCrewToPair(backendPairs, crew);
	}

	public static List<Crew> getRandomOrder() {
		return getRandomOrder(backendCrews);
	}

	public static boolean haveMeet(Crew targetCrew, Set<Crew> crews) {
		return haveMeet(backendPairs, targetCrew, crews);
	}
}
