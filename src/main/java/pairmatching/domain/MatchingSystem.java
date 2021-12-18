package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.OutputView;

public class MatchingSystem {
	private static final String NOT_FOUNT_ERROR =  "매칭 이력이 없습니다.";

	private List<Matching> matchingList = new ArrayList<>();

	public MatchingSystem() {
		if(matchingList.size() == 0) {
			this.matchingList = new ArrayList<>();
		}
	}

	public boolean save(Matching newMatching) {

		if (matchingList.contains(newMatching)) {
			OutputView.printReMatchingQuery();

			if (Console.readLine().equals("아니오")) {
				return false;
			}
		}

		//TODO:  같은 레벨에서 이미 페어로 만난적 있는 크루끼리 다시 페어로 매청 된다면
			// 다시 매칭 시도 -> 3회 매칭 후 실패하면 error

		OutputView.printMatchingResult(newMatching.getNames());
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