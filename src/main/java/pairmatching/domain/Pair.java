package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private List<Crew> crewList = new ArrayList<>();

	public Pair(Crew ...crews) {
		for (Crew crew : crews) {
			crewList.add(crew);
		}
	}
}
