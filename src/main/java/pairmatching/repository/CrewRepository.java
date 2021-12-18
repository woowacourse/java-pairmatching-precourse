package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;

public class CrewRepository {
	private static final CrewRepository crewRepository = new CrewRepository();

	List<Crew> backendCrews = new ArrayList<>();
	List<Crew> frontendCrews = new ArrayList<>();

	private CrewRepository() {
	}

	public static CrewRepository getInstance() {
		return crewRepository;
	}

	public void addBackendCrews(Crew crew) {
		backendCrews.add(crew);
	}

	public void addFrontCrews(Crew crew) {
		frontendCrews.add(crew);
	}

	public List<Crew> getBackendCrews() {
		return backendCrews;
	}

	public List<Crew> getFrontendCrews() {
		return frontendCrews;
	}
}
