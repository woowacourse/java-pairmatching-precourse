package pairmatching.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.view.InputView;

public class CrewGroup {

	private static final String backEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	private static final String frontEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

	private final List<Crew> crews = new LinkedList<>();

	public CrewGroup() {
		bringCrews();
	}

	private void bringCrews() {
		bringBackEndCrews();
		bringFrontEndCrews();
	}

	private void bringFrontEndCrews() {
		for (String name : InputView.getCrew(frontEndCrewDirPath)) {
			crews.add(new Crew(Course.FRONTEND, name));
		}
	}

	private void bringBackEndCrews() {
		for (String name : InputView.getCrew(backEndCrewDirPath)) {
			crews.add(new Crew(Course.BACKEND, name));
		}
	}

	public List<String> getShuffledCrews() {
		List<String> crewNames = crews.stream()
			.map(Crew::getName)
			.collect(Collectors.toList());
		return shuffle(crewNames);
	}
}
