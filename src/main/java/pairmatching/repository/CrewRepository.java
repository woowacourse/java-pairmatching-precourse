package pairmatching.repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.crew.Crew;
import pairmatching.util.IOUtils;

public class CrewRepository {
	private static List<Crew> backendCrews;
	private static List<Crew> frontendCrews;

	static {
		backendCrews = IOUtils.readBackendCrews().stream()
			.map(Crew::from)
			.collect(Collectors.toList());

		frontendCrews = IOUtils.readFrontendCrews().stream()
			.map(Crew::from)
			.collect(Collectors.toList());
	}

	public static List<Crew> getBackend() {
		return Collections.unmodifiableList(backendCrews);
	}

	public static List<Crew> getFrontend() {
		return Collections.unmodifiableList(backendCrews);
	}
}
