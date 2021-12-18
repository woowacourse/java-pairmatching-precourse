package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrontendCrewRepository extends CrewRepository{
	private static final ArrayList<Crew> frontendCrews = new ArrayList<>();
	private static final Map<Crew, List<Crew>> frontendPairs = new HashMap<>();

	public static void add(Crew crew) {
		addCrew(frontendCrews, crew);
		addCrewToPair(frontendPairs, crew);
	}

	public static List<Crew> getRandomOrder() {
		return getRandomOrder(frontendCrews);
	}

	public static boolean haveMeet(Crew targetCrew, List<Crew> crews) {
		return haveMeet(frontendPairs, targetCrew, crews);
	}
}
