package pairmatching.domain.crew;

import java.util.ArrayList;

public class BackendCrewRepository extends CrewRepository {
	private static final ArrayList<Crew> backendCrews = new ArrayList<>();

	public static void add(Crew crew) {
		add(backendCrews, crew);
	}
}
