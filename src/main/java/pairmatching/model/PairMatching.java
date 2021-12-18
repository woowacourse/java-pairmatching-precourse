package pairmatching.model;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.AdvanceInformationView;
import pairmatching.view.PairInfoView;
import pairmatching.view.PairListView;

public class PairMatching {

	private PairListMap pairListMap;
	private String option;

	public PairMatching() {
		pairListMap = new PairListMap();
		option = Option.PAIR_INITIALIZATION.getValue();
	}

	public void executeOption(String option) {
		this.option = option;

		if (option.equals(Option.PAIR_MATCHING.getValue())) {
			AdvanceInformationView advanceInformationView = new AdvanceInformationView();
			advanceInformationView.print();
			PairInfoView pairInfoView = new PairInfoView();
			PairInfo pairInfo = pairInfoView.getInput();
			checkDuplication(pairInfo);
		}

	}

	public void checkDuplication(PairInfo pairInfo) {
		if (pairListMap.contains(pairInfo)) {
			PairInfoView pairInfoView = new PairInfoView();
			pairInfoView.printDuplicationNotice();
			String userChoice = Console.readLine();
			System.out.println();

			if (userChoice.equals("아니오")) {
				return;
			}
		}

		matchPair(pairInfo);
	}

	public void matchPair(PairInfo pairInfo) {
		PairList pairList = new PairList(pairInfo);
		PairListView pairListView = new PairListView();
		pairListView.print(pairList);
		pairListMap.save(pairInfo, pairList);
	}

	public boolean isFinish() {
		return option.equals(Option.QUIT.getValue());
	}
}
