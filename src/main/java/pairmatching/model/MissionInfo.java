package pairmatching.model;

import java.util.List;

import pairmatching.service.MakingShuffleList;

public class MissionInfo {
	public String course;
	public String level;
	public String mission;
	public List<String> missionList;

	public MissionInfo(String course, String level, String mission, List<String> memberList) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		missionList = MakingShuffleList.shuffle(memberList);
	}

	public boolean find(String CourseLevelMission) {
		String[] str = CourseLevelMission.split(", ", -1);

		if (!str[0].equals(course) || !str[1].equals(level) || !str[2].equals(mission)) {
			return false;
		}
		
		return true;
	}
}
