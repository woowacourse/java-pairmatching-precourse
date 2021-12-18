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

	public boolean save(Matching newMatching) {

		if (!matchingList.contains(newMatching)) {
			OutputView.printQueryMatchingInformation();

			if (Console.readLine().equals("아니요")) {
				return false;
			}
		}

		matchingList.add(newMatching);
		return true;
	}

	public void remove(Matching targetMatching) {
		if(!matchingList.contains(targetMatching)) {
			throw new IllegalArgumentException();
		}

		matchingList.remove(targetMatching);
	}
}