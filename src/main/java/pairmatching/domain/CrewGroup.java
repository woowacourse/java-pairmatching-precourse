package pairmatching.domain;

import java.util.LinkedList;
import java.util.List;

import pairmatching.view.InputView;

public class CrewGroup {

	private static final String backEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	private static final String frontEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

	private final List<Crew> Crews = new LinkedList<>();

	public CrewGroup() {
		bringCrews();
	}

	private void bringCrews() {
		bringBackEndCrews();
		bringFrontEndCrews();
	}

	private void bringFrontEndCrews() {
		for (String name : InputView.getCrew(frontEndCrewDirPath)) {
			Crews.add(new Crew(Course.FRONTEND, name));
		}
	}

	private void bringBackEndCrews() {
		for (String name : InputView.getCrew(backEndCrewDirPath)) {
			Crews.add(new Crew(Course.BACKEND, name));
		}
	}
}
