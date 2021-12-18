package pairmatching.model;

import static pairmatching.constants.Constants.*;

import java.util.LinkedList;
import java.util.List;

import pairmatching.util.FileUtils;

public class PairMatching {
	private MatchingHistory matchingHistory;
	private MatchingInfo matchingInfo;
	private List<Crew> crews = new LinkedList<>();

	public PairMatching() {
		setCrews();
		crews.forEach(crew -> System.out.println("crew = " + crew));
	}

	private void setCrews() {
		List<String> backendCrew = FileUtils.readFile(BACKEND_CREW_FILE);
		backendCrew.forEach(name -> crews.add(new Crew(Course.BACKEND, name)));

		List<String> frontendCrew = FileUtils.readFile(FRONTEND_CREW_FILE);
		frontendCrew.forEach(name -> crews.add(new Crew(Course.FRONTEND, name)));
	}
}
