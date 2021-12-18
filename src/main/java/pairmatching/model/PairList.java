package pairmatching.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.BackendCrew;
import pairmatching.util.FileScanner;

public class PairList {

	List<String> pairList;

	public PairList(PairInfo pairInfo) {
		List<String> crewNames = getCrewNames(pairInfo.getCourse());
		List<String> shuffledCrew = Randoms.shuffle(crewNames);
		pairList = shuffledCrew;
	}

	private List<String> getCrewNames(String course) {
		FileScanner fileScanner = new FileScanner();

		if (course.equals("백엔드")) {
			// return fileScanner.readFile("backend-crew.md");
			return BackendCrew.backendCrew;
		}

		if (course.equals("프론트엔드")) {
			return fileScanner.readFile("frontend-crew.md");
		}

		return null;
	}

}
