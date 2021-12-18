package pairmatching.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private Map<Level, List<Crew>> pairCrewLog;

	public Crew(Course course, String name) {
		this.name = name;
		this.course = course;
		initPairCrewLog();
	}

	public boolean checkAlreadyPair(Level level, Crew crew) {
		List<Crew> crewList = pairCrewLog.get(level);
		return crewList.contains(crew);
	}

	public void initPairCrewLog() {
		pairCrewLog = new HashMap<Level, List<Crew>>();
	}

	@Override
	public String toString() {
		return name;
	}
}