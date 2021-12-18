package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingCrew {
	List<Crew> crewList =  new ArrayList<>();

	public MatchingCrew(Crew crew1, Crew crew2) {
		crewList.add(crew1);
		crewList.add(crew2);
	}

	public MatchingCrew(Crew crew1, Crew crew2, Crew crew3) {
		crewList.add(crew1);
		crewList.add(crew2);
	}

	public List<Crew> getCrewList() {
		return crewList;
	}
}
