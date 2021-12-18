package pairmatching.domains.crew;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domains.mission.Course;

public class BackendCrews extends Crews{
	private static final String BACKEND_DATA_PATH = "resources/backend-crew.md";
	List<Crew> backendCrews = new ArrayList<>();

	public void setBackendCrews() {
		super.loadCrews(BACKEND_DATA_PATH, Course.BACKEND, backendCrews);
	}
}
