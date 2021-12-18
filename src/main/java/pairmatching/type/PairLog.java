package pairmatching.type;

import java.util.ArrayList;
import java.util.List;

public class PairLog {
	Course course;
	Level level;
	String mission;

	List<List<Crew>> pairResult;

	public PairLog(Course course, Level level, String mission, List<List<Crew>> pairResult) {
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

	public boolean isSameLevel(Course course, Level level) {
		return this.course.equals(course) && this.level.equals(level);
	}

	public boolean checkDuplicatePairExist(List<List<Crew>> pairList) {
		for(List<Crew> pair: pairList) {
			if(isDuplicatePair(pair)) {
				return true;
			}
		}
		return false;
	}

	private boolean isDuplicatePair(List<Crew> pair) {
		for(List<Crew> pairLog: pairResult) {
			List<Crew> copyPairLog = copyCrewList(pairLog);
			copyPairLog.retainAll(pair);
			if(!checkRetainCrewList(copyPairLog)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkRetainCrewList(List<Crew> crewList) {
		return crewList.size() <= 1;
	}

	private List<Crew> copyCrewList(List<Crew> crewList) {
		List<Crew> results = new ArrayList<Crew>();
		for(Crew crew:crewList) {
			results.add(crew);
		}
		return results;
	}

	public List<List<Crew>> getPairResult() {
		return pairResult;
	}
}
