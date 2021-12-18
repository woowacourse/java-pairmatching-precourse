package pairmatching.domains.crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewPair {
	Map<Crew, Crew> crewMap = new HashMap<>();

	public void clear() {
		crewMap.clear();
	}

	public void getCrew(Crews crews) {
		List<Crew> crewList;
		if (crews instanceof BackendCrews) {
			crewList = ((BackendCrews)crews).getBackendCrews();
		} else if (crews instanceof FrontendCrews) {
			crewList = ((FrontendCrews)crews).getFrontendCrews();
		}

		matchingCrews(crewList);
	}

	private void matchingCrews(List<Crew> crews) {

	}
}
