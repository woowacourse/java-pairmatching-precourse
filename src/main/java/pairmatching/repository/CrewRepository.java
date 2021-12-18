package pairmatching.repository;

import static pairmatching.constant.Course.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mockito.internal.util.Supplier;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Match;
import pairmatching.util.FileInputUtils;

public class CrewRepository {
	private static List<Crew> crews = new ArrayList<>();

	private static Map<Course, Supplier<List<String>>> courseMap = new LinkedHashMap<>();

	static {
		courseMap.put(BACKEND, CrewRepository::getBackendCrewNames);
		courseMap.put(FRONTEND, CrewRepository::getFrontendCrewNames);
	}

	public static List<Crew> getShuffledCrews(Match match) {
		clearCrews();
		Course course = match.getCourse();
		List<String> crewNames = courseMap.get(course).get();
		List<String> shuffledCrewNames = Randoms.shuffle(crewNames);
		for (String name : shuffledCrewNames) {
			Crew crew = new Crew(course, name);
			crews.add(crew);
		}
		return crews;
	}

	private static void clearCrews() {
		crews = new ArrayList<>();
	}

	public static List<String> getBackendCrewNames() {
		return FileInputUtils.getBackendCrewsNames();
	}

	public static List<String> getFrontendCrewNames() {
		return FileInputUtils.getFrontendCrewsNames();
	}


}
