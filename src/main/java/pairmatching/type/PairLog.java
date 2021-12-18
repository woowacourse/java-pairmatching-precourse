package pairmatching.type;

import java.util.List;

public class PairLog {
	Course course;
	Level level;
	String mission;

	List<Crew> pairResult;

	public PairLog(Course course, Level level, String mission, List<Crew> pairResult) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pairResult = pairResult;
	}

	public boolean checkDuplicate(Course course, Level level, String mission) {
		if(this.course.equals(course) && this.level.equals(level) && this.mission.equals(mission)) {
			return true;
		}
		return false;
	}
}
