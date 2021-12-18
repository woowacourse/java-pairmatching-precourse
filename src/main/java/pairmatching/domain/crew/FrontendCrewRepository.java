package pairmatching.domain.crew;

import java.util.ArrayList;

public class FrontendCrewRepository extends CrewRepository{
	private static final ArrayList<Crew> frontendCrews = new ArrayList<>();

	public static void add(Crew crew) {
		add(frontendCrews, crew);
	}
}
