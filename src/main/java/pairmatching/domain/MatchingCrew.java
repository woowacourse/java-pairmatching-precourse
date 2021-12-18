package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingCrew {
	private List<Crew> crewList = new ArrayList<>();

	public MatchingCrew(Crew crew1, Crew crew2) {
		crewList.add(crew1);
		crewList.add(crew2);
	}

	public MatchingCrew(Crew crew1, Crew crew2, Crew crew3) {
		crewList.add(crew1);
		crewList.add(crew2);
		crewList.add(crew3);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(crewList.get(0).toString());
		for (int i = 1; i < crewList.size(); i++) {
			stringBuilder.append(" : ").append(crewList.get(i).toString());
		}
		return stringBuilder.toString();
	}
}
