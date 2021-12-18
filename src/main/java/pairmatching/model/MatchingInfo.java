package pairmatching.model;

import static pairmatching.constants.Constants.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import pairmatching.util.FileUtils;

public class MatchingInfo {
	private Map<String, List<Pair>> matchingInfo = new LinkedHashMap<>();
	private List<Crew> crews = new LinkedList<>();

	public MatchingInfo() {
		setCrews();
		crews.forEach(crew -> System.out.println("crew.toString() = " + crew.toString()));
	}

	private void setCrews() {
		List<String> backendCrew = FileUtils.readFile(BACKEND_CREW_FILE);
		backendCrew.forEach(name -> crews.add(new Crew(Course.BACKEND, name)));

		List<String> frontendCrew = FileUtils.readFile(FRONTEND_CREW_FILE);
		frontendCrew.forEach(name -> crews.add(new Crew(Course.FRONTEND, name)));
	}
}
