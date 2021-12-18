package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.OutputView;

public class MatchingSystem {
	private static final String NOT_FOUNT_ERROR =  "매칭 리스트에 없는 정보 입니다.";

	private List<Matching> matchingList;

	public MatchingSystem() {
		this.matchingList = new ArrayList<>();
	}

	public boolean save(Matching newMatching) {

		if (!matchingList.contains(newMatching)) {
			OutputView.printReMatchingQuery();

			if (Console.readLine().equals("아니요")) {
				return false;
			}
		}

		matchingList.add(newMatching);
		return true;
	}

	public List<String> read(Matching targetMatching) {
		List<String> names = null;

		if(!matchingList.contains(targetMatching)) {
			throw new IllegalArgumentException(NOT_FOUNT_ERROR);
		}

		for(Matching matching : matchingList) {
			if(matching.equals(targetMatching)) {
				names =  matching.getNames();
			}
		}

		if(names == null) {
			throw new IllegalArgumentException(NOT_FOUNT_ERROR);
		}

		return names;
	}

	public void remove(Matching targetMatching) {
		if(!matchingList.contains(targetMatching)) {
			throw new IllegalArgumentException(NOT_FOUNT_ERROR);
		}

		matchingList.remove(targetMatching);
	}
}