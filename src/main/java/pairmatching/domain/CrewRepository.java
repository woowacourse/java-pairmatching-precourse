package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewRepository {
	public static final List<Crew> backEndCrews = new ArrayList<>();
	public static final List<Crew> frontEndCrews = new ArrayList<>();

	public static void addBackEndCrew(Crew crew) {
		backEndCrews.add(crew);
	}

	public static void addFrontEndCrew(Crew crew) {
		frontEndCrews.add(crew);
	}

	public static List<Crew> getBackEndCrews() {
		List<String> names = backEndCrews.stream()
			.map(crew -> crew.getName())
			.collect(Collectors.toList());
		return Randoms.shuffle(names).stream()
			.map(name -> Crew.from(Course.BACKEND, name))
			.collect(Collectors.toList());
	}

	public static List<Crew> getFrontEndCrews() {
		List<String> names = frontEndCrews.stream()
			.map(crew -> crew.getName())
			.collect(Collectors.toList());
		return Randoms.shuffle(names).stream()
			.map(name -> Crew.from(Course.FRONTEND, name))
			.collect(Collectors.toList());
	}

}
