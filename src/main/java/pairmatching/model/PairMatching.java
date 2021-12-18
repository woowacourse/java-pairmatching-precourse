package pairmatching.model;

import pairmatching.view.AdvanceInformationView;
import pairmatching.view.PairInfoView;
import pairmatching.view.PairListView;

public class PairMatching {

	private PairListMap pairListMap;
	private String option;

	public PairMatching() {
		pairListMap = new PairListMap();
	}

	public void executeOption(String option) {
		this.option = option;

		if (option.equals(Option.PAIR_MATCHING.getValue())) {
			matchPair();
		}

	}

	public void matchPair() {
		AdvanceInformationView advanceInformationView = new AdvanceInformationView();
		advanceInformationView.print();
		PairInfoView pairInfoView = new PairInfoView();
		PairInfo pairInfo = pairInfoView.getInput();
		PairList pairList = new PairList(pairInfo);
		PairListView pairListView = new PairListView();
		pairListView.print(pairList);
		pairListMap.save(pairInfo, pairList);
	}
}
