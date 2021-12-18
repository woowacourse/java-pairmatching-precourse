package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMaker {
	public static List<CrewPair> makeBackendCrewPair(List<Mission> missions) {
		List<CrewPair> crewPairs = new ArrayList<>();
		List<Crew> crews = CrewRepository.getBackEndCrews();
		for (int i = 0; i < crews.size() - 2; i = i + 2) {
			List<Crew> crewsOfPair = new ArrayList<>();
			crewsOfPair.add(crews.get(i));
			crewsOfPair.add(crews.get(i + 1));
			if (crews.size() % 2 != 0 && (i == (crews.size()) - 3)) {
				crewsOfPair.add(crews.get(i + 2));
			}
			if (checkHasSameCrew(missions, crewsOfPair)) {
				crewPairs.clear();
				break;
			}
			crewPairs.add(CrewPair.from(crewsOfPair));
		}
		return crewPairs;
	}

	public static List<CrewPair> makeFrontendCrewPair(List<Mission> missions) {
			List<CrewPair> crewPairs = new ArrayList<>();
			List<Crew> crews = CrewRepository.getFrontEndCrews();
			for (int i = 0; i < crews.size() - 2; i = i + 2) {
				List<Crew> crewsOfPair = new ArrayList<>();
				crewsOfPair.add(crews.get(i));
				crewsOfPair.add(crews.get(i + 1));
				if (crews.size() % 2 != 0 && (i == (crews.size()) - 3)) {
					crewsOfPair.add(crews.get(i + 2));
				}
				if (checkHasSameCrew(missions, crewsOfPair)) {
					crewPairs.clear();
					break;
				}
				crewPairs.add(CrewPair.from(crewsOfPair));
			}
			return crewPairs;
		}

	public static boolean checkHasSameCrew(List<Mission> missions, List<Crew> crews) {
		for (Mission mission : missions) {
			if (mission.hasSameCrewPair(crews)) {
				return false;
			}
		}
		return true;
	}

}
