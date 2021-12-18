package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crews;

	public Pair(List<Crew> crews) {
		this.crews = crews;
	}

	public List<Crew> getCrews() {
		return crews;
	}

	// public boolean isSamePair(List<Crew> comparedCrews) {
	// 	int crewSize = crews.size();
	// 	int comparedCrewSize = comparedCrews.size();
	// 	if (crewSize != comparedCrewSize) {
	// 		return false;
	// 	}
	// 	if((crews.get(0).equals(comparedCrews.get(0).getName()) ||
	// 		crews.get(0).equals(comparedCrews.get(1).getName()))
	// 	)
	// 	return true;
	// }

	@Override
	public String toString() {
		List<String> crewNameList = this.crews.stream()
			.map(Crew::getName)
			.collect(Collectors.toList());
		return String.join(" : ", crewNameList);
	}
}
