package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.PairMatchingView;

public class Manager {
	private List<MatchInfo> matchInfos = new ArrayList<>();

	public boolean setDetail(String[] selections) {
		MatchInfo matchInfo = new MatchInfo(selections);
		matchInfos.add(matchInfo);
		return true;
	}

	public boolean isDuplication(String[] selections) {
		for (MatchInfo matchInfo : matchInfos) {
			if (matchInfo.isSameThing(selections[0], selections[1], selections[2])) {
				return true;
			}
		}
		return false;
	}

}
