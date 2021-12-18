package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewRepository {
	public static void add(ArrayList<Crew> crews, Crew crew) {
		crews.add(crew);
	}

	public static List<Crew> getRandomOrder(ArrayList<Crew> crews) {
		return Randoms.shuffle(crews);
	}
}
