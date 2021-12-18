package pairmatching.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
	private static final List<Crew> crews = new ArrayList<>();

	public static void addCrews(Crew crew) {
		crews.add(crew);
	}

	public static List<Crew> findBackendCrews() {
		return crews.stream().filter(crew -> crew.isBackend()).collect(Collectors.toList());
	}

	public static List<Crew> findFrontendCrews() {
		return crews.stream().filter(crew -> crew.isFrontend()).collect(Collectors.toList());
	}
}
