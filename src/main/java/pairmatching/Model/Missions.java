package pairmatching.Model;

import java.util.ArrayList;
import java.util.List;

public class Missions {
	private static final int COURSE_INFO = 0;
	private static final int LEVEL_INFO = 1;
	private static final int MISSION_INFO = 2;

	private static List<Mission> missions = new ArrayList<>();

	public static Mission addMission(List<String> info){
		Mission mission = new Mission(Course.fineCourse(info.get(COURSE_INFO)),
			Level.fineLevel(info.get(LEVEL_INFO), info.get(MISSION_INFO)),info.get(MISSION_INFO));
		missions.add(mission);
		return mission;
	}
}
