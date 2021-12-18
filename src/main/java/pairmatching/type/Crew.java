package pairmatching.type;

import java.util.ArrayList;
import java.util.List;

public class Crew {
	private Course course;
	private String name;
	private List<Crew> pairCrewLog;

	public Crew(Course course, String name) {
		this.name = name;
		this.course = course;
		initPairCrewLog();
	}

	public boolean checkAlreadyPair(Crew crew) {
		return pairCrewLog.contains(crew);
	}

	public void initPairCrewLog() {
		pairCrewLog = new ArrayList<Crew>();
	}

	@Override
	public String toString() {
		return name;
	}
}