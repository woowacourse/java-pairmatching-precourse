package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewRepository {
	public static void addCrew(ArrayList<Crew> crews, Crew crew) {
		crews.add(crew);
	}

	public static void addCrewToPair(Map<Crew, List<Crew>> pairs, Crew crew) {
		pairs.put(crew, new ArrayList<>());
	}

	public static List<Crew> getRandomOrder(ArrayList<Crew> crews) {
		return Randoms.shuffle(crews);
	}

	public static boolean haveMeet(Map<Crew, List<Crew>> pairs, Crew targetCrew, Set<Crew> crews) {
		for (Crew crew: crews) {
			if (pairs.get(targetCrew).contains(crew)) {
				return true;
			}
		}
		return false;
	}
}
