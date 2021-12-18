package pairmatching.domain;

import static pairmatching.utils.Constant.*;

import pairmatching.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MatchingInfo {
	private final String course;
	private final String level;
	private final String mission;
	private List<String> shuffledCrew = new ArrayList<>();

	public MatchingInfo(List<String> infos) {
		this.course = infos.get(COURSE_INFO);
		this.level = infos.get(LEVEL_INFO);
		this.mission = infos.get(MISSION_INFO);
	}

	public boolean isSame(List<String> info) {
		if (course.equals(info.get(COURSE_INFO))
				&& level.equals(info.get(LEVEL_INFO))
				&& mission.equals(info.get(MISSION_INFO))) {
			return true;
		}
		return false;
	}

	public void updatePairMatchingList(List<String> updatedList) {
		this.shuffledCrew = updatedList;
	}

	public List<String> getShuffledCrew() {
		return shuffledCrew;
	}
}
