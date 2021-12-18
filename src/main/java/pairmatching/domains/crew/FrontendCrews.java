package pairmatching.domains.crew;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domains.mission.Course;

public class FrontendCrews extends Crews {
	private static final String FRONTEND_DATA_PATH = "src/main/resources/frontend-crew.md";

	List<Crew> frontendCrews = new ArrayList<>();

	public void setFrontendCrews() {
		super.loadCrews(FRONTEND_DATA_PATH, Course.FRONTEND, frontendCrews);
	}

	public List<Crew> getFrontendCrews() {
		return frontendCrews;
	}
}
