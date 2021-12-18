package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;

public class FrontendCrewRepository extends CrewRepository{
	private static final ArrayList<Crew> frontendCrews = new ArrayList<>();

	public static void add(Crew crew) {
		add(frontendCrews, crew);
	}

	public static List<Crew> getRandomOrder() {
		return getRandomOrder(frontendCrews);
	}
}
