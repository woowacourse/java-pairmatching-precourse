package pairmatching.controller;

import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FunctionController {

	MatchingService matchingService = new MatchingService();

	public void choiceFunction(String functionNumber) {
		if ("1".equals(functionNumber)) {
			//TODO: 페어 매칭 함수 구현
			// return ~
			pairMatching();
		}
		if ("2".equals(functionNumber)) {
			//TODO: 페어 조회 함수 구현
			// return ~
		}
		if ("3".equals(functionNumber)) {
			//TODO: 페어 초기화 함수 구현
			// return ~
		}
		if ("Q".equals(functionNumber)) {
			//TODO: 실행 종료 함수 구현
			// return ~
		}
		return;
	}

	private void pairMatching() {
		OutputView.printAdvanceInformation();
		InputView.InputCourseAndLevelAndMission();

		matchingService.generateRandomMatching();
	}
}
