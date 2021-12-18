package pairmatching.controller;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.FunctionMenu;
import pairmatching.domain.PairMachine;
import pairmatching.domain.Rematching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
	public void runPairMatching() {
		//메인로직
		PairMachine pairMachine = PairMachine.getInstance();
		pairMachine.init();

		//기능을 선택하세요.
		OutputView.printInputFunctionMenuInstruction();
		FunctionMenu SelectedMenu = FunctionMenu.findBySelectedMenu(InputView.getFunctionMenu());
		boolean canPairMaching = SelectedMenu != FunctionMenu.QUIT;

		while (canPairMaching) {
			if (SelectedMenu == FunctionMenu.PAIR_MATCHING) {
				// 페어매칭 시작
				//과정, 레벨, 미션을 선택하세요.
				OutputView.printInputMatchingInfoInstruction();

				// List<String> matchingInfo = InputView.getMatchingInfo();
				List<String> matchingInfo = Arrays.asList("프론트엔드, 레벨1, 자동차경주".split(","));

				// 정보입력 전, 직전정보와 비교한다.

				boolean isAlreadyExistMatching = pairMachine.insertMatchingInfoAndResult(matchingInfo);
				if (isAlreadyExistMatching) {
					OutputView.printExistOfMatchingInstruction();
					Rematching selectedMenu = Rematching.findBySelectedMenu(InputView.getRematching());
					if (selectedMenu == Rematching.YES) {
						OutputView.printResultOfMatch(pairMachine.match());
					}
				}
				if (!isAlreadyExistMatching) {
					OutputView.printResultOfMatch(pairMachine.match());
				}

			}
			if (SelectedMenu == FunctionMenu.PAIR_FIND) {
				// 페어조회 시작
				OutputView.printInputMatchingInfoInstruction();
				List<String> matchingInfo = InputView.getMatchingInfo();
				String findResult = pairMachine.findPair(matchingInfo);
				// System.out.println("[로그] 참고용 findResult :" + findResult); // TODO 삭제
				if (findResult != null) {
					OutputView.printResultOfMatch(findResult);
				}
				if (findResult == null) {
					OutputView.printNoHistory();
				}

			}
			if (SelectedMenu == FunctionMenu.PAIR_INIT) {
				// 페어초기화
				pairMachine.init();
				OutputView.printInitInstruction();
			}

			OutputView.printInputFunctionMenuInstruction();
			SelectedMenu = FunctionMenu.findBySelectedMenu(InputView.getFunctionMenu());
			canPairMaching = SelectedMenu != FunctionMenu.QUIT;

		}

	}
}
