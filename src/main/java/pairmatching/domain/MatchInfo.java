package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchInfo {
	String course;
	String level;
	String mission;
	List<Pair> pairList = new ArrayList<>();
	Crew backendCrew = new Crew("백엔드");
	Crew frontendCrew = new Crew("프론트엔드");

	public MatchInfo(String[] selections) {
		this.course = selections[0];
		this.level = selections[1];
		this.mission = selections[2];
	}

	public void match() {
		List<String> names = new ArrayList<>();
		if (course.equals("백엔드")) {
			names = backendCrew.getNames();
		}
		if (course.equals("프론트엔드")) {
			names = frontendCrew.getNames();
		}
		while (names.size() != 0) {
			if (names.size() == 3) {
				Pair pair = new Pair(names.get(0), names.get(1));
				pair.add(names.get(2));
				pairList.add(pair);
				names.clear();
				return;
			}
			Pair pair = new Pair(names.get(0), names.get(1));
			pairList.add(pair);
			names.remove(0);
			names.remove(0);
		}
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	public boolean isSameThing(String course, String level, String mission) {
		if (this.course.equals(course) && this.level.equals(level) && this.mission.equals(mission)) {
			return true;
		}
		return false;
	}
}
