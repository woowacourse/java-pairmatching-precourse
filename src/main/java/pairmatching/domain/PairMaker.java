package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMaker {
	public static List<CrewPair> makeBackendCrewPair(List<Mission> missions) {
		List<CrewPair> crewPairs = new ArrayList<>();
		List<Crew> crews = CrewRepository.getBackEndCrews();
		for (int i = 0; i < crews.size() / 2; i++) {
			List<Crew> crewsOfPair = Arrays.asList(crews.get(i), crews.get(i+1));
			if(crews.size() % 2 != 0 && i == ((crews.size() / 2) -1)) {
				crewsOfPair.add(crews.get(i+2));
			}
			if(checkHasSameCrew(missions, crewsOfPair)) {
				crewPairs.clear();
				break;
			}
			crewPairs.add(CrewPair.from(crewsOfPair));
		}
		return crewPairs;
	}

	public static boolean checkHasSameCrew(List<Mission> missions, List<Crew> crews) {
		return true;
	}

}
