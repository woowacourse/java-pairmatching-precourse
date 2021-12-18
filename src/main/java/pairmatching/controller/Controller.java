package pairmatching.controller;

import java.util.List;

import pairmatching.domain.FunctionMenu;
import pairmatching.domain.PairMachine;
import pairmatching.domain.Rematching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
	public void runPairMatching() {
		PairMachine pairMachine = PairMachine.getInstance();
		pairMachine.init();

		OutputView.printInputFunctionMenuInstruction();
		FunctionMenu SelectedMenu = FunctionMenu.findBySelectedMenu(InputView.getFunctionMenu());
		boolean canPairMaching = SelectedMenu != FunctionMenu.QUIT;

		while (canPairMaching) {
			if (isPairMaching(SelectedMenu)) {
				OutputView.printInputMatchingInfoInstruction();

				List<String> matchingInfo = InputView.getMatchingInfo();

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
			if (isPairFind(SelectedMenu)) {
				OutputView.printInputMatchingInfoInstruction();
				List<String> matchingInfo = InputView.getMatchingInfo();
				String findResult = pairMachine.findPair(matchingInfo);
				if (findResult != null) {
					OutputView.printResultOfMatch(findResult);
				}
				if (findResult == null) {
					OutputView.printNoHistory();
				}

			}
			if (SelectedMenu == FunctionMenu.PAIR_INIT) {
				pairMachine.init();
				OutputView.printInitInstruction();
			}

			OutputView.printInputFunctionMenuInstruction();
			SelectedMenu = FunctionMenu.findBySelectedMenu(InputView.getFunctionMenu());
			canPairMaching = SelectedMenu != FunctionMenu.QUIT;

		}

	}

	private boolean isPairFind(FunctionMenu selectedMenu) {
		return selectedMenu == FunctionMenu.PAIR_FIND;
	}

	private boolean isPairMaching(FunctionMenu selectedMenu) {
		return selectedMenu == FunctionMenu.PAIR_MATCHING;
	}
}
