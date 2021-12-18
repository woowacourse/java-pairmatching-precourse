package pairmatching.model;

import java.util.List;

import pairmatching.service.MakingShuffleList;

public class MissionInfo {
	public String course;
	public String level;
	public String mission;
	public List<String> missionList;

	public MissionInfo(String course, String level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

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

	public boolean checkReDuple(String course, String level, List<String> crew) {
		if (!course.equals(this.course) || !level.equals(this.level)) {
			return false;
		}

		for (int i = 0; i < crew.size() / 2; i++) {
			int cnt = 0;
			if (crew.get(i).equals(missionList.get(i)) || crew.get(i + 1).equals(missionList.get(i + 1))) {
				cnt++;
			}

			if (crew.get(i).equals(missionList.get(i + 1)) || crew.get(i).equals(missionList.get(i + 1))) {
				cnt++;
			}

			if (cnt == 2)
				return true;
		}
		
		return false;
	}
}
