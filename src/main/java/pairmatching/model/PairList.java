package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.BackendCrew;
import pairmatching.constant.FrontendCrew;
import pairmatching.constant.Message;
import pairmatching.util.FileScanner;

public class PairList {

	List<String> pairList;

	public PairList(PairInfo pairInfo) {
		List<String> crewNames = getCrewNames(pairInfo.getCourse());
		List<String> shuffledCrew = Randoms.shuffle(crewNames);
		List<String> pairList = makePair(shuffledCrew);
		this.pairList = pairList;
	}

	private List<String> getCrewNames(String course) {
		FileScanner fileScanner = new FileScanner();

		if (course.equals("백엔드")) {
			// return fileScanner.readFile("backend-crew.md");
			return BackendCrew.backendCrew;
		}

		if (course.equals("프론트엔드")) {
			return FrontendCrew.frontEndCrew;
			// return fileScanner.readFile("frontend-crew.md");
		}

		return null;
	}

	public List<String> makePair(List<String> shuffledCrew) {
		List<String> pairList = new ArrayList<>();
		int size = shuffledCrew.size();

		if (size % 2 == 1) {
			size--;
		}

		for (int i = 0; i < size; i += 2) {
			List<String> pair = new ArrayList<>();
			pair.add(shuffledCrew.get(i));
			pair.add(shuffledCrew.get(i + 1));
			pairList.add(String.join(Message.COLON, pair));
		}

		if (shuffledCrew.size() % 2 == 1) {
			String lastPair = pairList.get(pairList.size() - 1);
			String lastName = shuffledCrew.get(shuffledCrew.size() - 1);
			lastPair += Message.COLON + lastName;
			pairList.set(pairList.size() - 1, lastPair);
		}
		return pairList;
	}

	public List<String> getPairList() {
		return pairList;
	}
}
