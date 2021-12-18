package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchInfo {
	String course;
	String level;
	String mission;
	List<Pair> pairList = new ArrayList<>();
	List<String> crewNames = new ArrayList<>();
	static final Crew backend = new Crew("백엔드");
	static final Crew frontend = new Crew("프론트엔드");

	public MatchInfo(String[] selections) {
		this.course = selections[0];
		this.level = selections[1];
		this.mission = selections[2];
	}

	private void storeCrewNames() {
		if (course.equals("백엔드")) {
			crewNames = backend.getNames();
		}
		if (course.equals("프론트엔드")) {
			crewNames = frontend.getNames();
		}
	}

	public void match(List<MatchInfo> matchInfos) {
		storeCrewNames();
		while (crewNames.size() != 0) {
			if (crewNames.size() == 3) {
				Pair pair = new Pair(crewNames.get(0), crewNames.get(1));
				if (isExistPair(matchInfos, pair)) {
					storeCrewNames();
					continue;
				}
				pair.add(crewNames.get(2));
				pairList.add(pair);
				crewNames.clear();
				return;
			}
			Pair pair = new Pair(crewNames.get(0), crewNames.get(1));
			if (isExistPair(matchInfos, pair)) {
				storeCrewNames();
			}
			pairList.add(pair);
			crewNames.remove(0);
			crewNames.remove(0);
		}
	}

	private boolean isExistPair(List<MatchInfo> matchInfos, Pair pair) {
		for (MatchInfo matchInfo : matchInfos) {
			for (int i = 0; i < matchInfo.pairList.size(); i++) {
				if (pairList.get(i).isExistPair(pair)) {
					return true;
				}
			}
		}
		return false;
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

	public boolean isSameLevel(MatchInfo matchInfo) {
		return this.level.equals(matchInfo.level);
	}

	public MatchInfo search(String course, String level, String mission) {
		if (this.course.equals(course) && this.level.equals(level) && this.mission.equals(mission)) {
			return this;
		}
		return null;
	}

	public void resetPair() {
		pairList.clear();
	}
}
