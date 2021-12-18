package pairmatching.domain;

import java.util.List;

public class CrewPair {
	private List<Crew> crews;

	public CrewPair(List<Crew> crews) {
		this.crews = crews;
	}

	public static CrewPair from(List<Crew> crews) {
		return new CrewPair(crews);
	}

	public boolean isSame(List<Crew> crewList) {
		for (Crew crew : crewList) {
			if (!crews.contains(crew)) {
				return false;
			}
		}
		return true;
	}
}
