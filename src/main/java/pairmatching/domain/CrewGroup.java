package pairmatching.domain;

import java.util.List;

public class CrewGroup {

	private static final String backEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	private static final String frontEndCrewDirPath =
		"C:\\Users\\LG\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

	private List<String> backEndCrews;
	private List<String> frontEndCrews;

	public CrewGroup() {
		bringCrews();
	}

	private void bringCrews() {
		bringBackEndCrews();
		bringFrontEndCrews();
	}


}
