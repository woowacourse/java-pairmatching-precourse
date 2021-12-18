package pairmatching.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairMatching {
	public List<String> backendCrew;
	public List<String> frontendCrew;
	public Set<MissionInfo> missionInfoSet;

	public PairMatching() {
		backendCrew = new ArrayList<String>();
		frontendCrew = new ArrayList<String>();
		missionInfoSet = new HashSet<MissionInfo>();
	}

	public void makePair(String CourseLevelMission) {
		String[] str = CourseLevelMission.split(", ", -1);
		MissionInfo missionInfo = new MissionInfo(str[0], str[1], str[2], backendCrew);
		missionInfoSet.add(missionInfo);
	}
}
