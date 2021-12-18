package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;
import pairmatching.view.OutputView;

public class MatchingSystem {

	private List<Matching> matchingList;

	public MatchingSystem() {
		this.matchingList = new ArrayList<>();
	}

	public boolean saveMatchingResult(List<String> names, String course, String level, String mission) {
		Matching newMatching = new Matching(Course.mapToCourse(course), Level.mapToLevel(level), Mission.mapToLevel(mission), names);

		if (!matchingList.contains(newMatching)) {
			OutputView.printQueryMatchingInformation();
			if(Console.readLine().equals("아니요")) {
				return false;
			}

			return true;
		}

		matchingList.add(newMatching);
		return true;
	}

}
