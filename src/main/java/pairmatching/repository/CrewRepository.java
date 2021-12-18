package pairmatching.repository;

import static pairmatching.constant.Course.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mockito.internal.util.Supplier;

import pairmatching.constant.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Match;
import pairmatching.util.FileInputUtils;
import pairmatching.util.Voider;

public class CrewRepository {
	private static List<Crew> frontendCrews = new ArrayList<>();
	private static List<Crew> backendCrews = new ArrayList<>();

	private static Map<Course, Supplier<List<String>>> courseMap = new LinkedHashMap<>();

	static {
		courseMap.put(BACKEND, CrewRepository::getBackendCrewNames);
		courseMap.put(FRONTEND, CrewRepository::getFrontendCrewNames);
	}

	public static void getShuffledCrews(Match match) {
		Course course = match.getCourse();
		List<String> crewNames = courseMap.get(course).get();
		System.out.println("crewNames = " + crewNames);
	}

	public static List<String> getBackendCrewNames() {
		return FileInputUtils.getBackendCrewsNames();
	}

	public static List<String> getFrontendCrewNames() {
		return FileInputUtils.getFrontendCrewsNames();
	}


}
