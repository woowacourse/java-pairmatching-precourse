package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String toString() {
		List<String> crewNames = crews.stream()
			.map(Crew::getName)
			.collect(Collectors.toList());
		return String.join(" : " , crewNames);
	}
}
