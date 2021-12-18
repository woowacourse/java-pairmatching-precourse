package pairmatching.controller;

import static pairmatching.view.InputView.*;

import pairmatching.enums.FeatureEnum;
import pairmatching.service.PairMatchingService;

public class PairMatching {
	private PairMatchingService pairMatchingService;

	public PairMatching() {
		pairMatchingService = new PairMatchingService();
	}

	public void executeFeature() {
		String feature = inputExecuteFeature().getMessage();
		if (FeatureEnum.PAIR_MATCHING.isSame(feature)) {
			pairMatching();
		}
		if (FeatureEnum.PAIR_SEARCH.isSame(feature)) {
			pairSearch();
		}
		if (FeatureEnum.PAIR_INITIALIZE.isSame(feature)) {
			pairInitialize();
		}
		if (FeatureEnum.EXIT.isSame(feature)) {
			return;
		}
	}

	private void pairMatching() {
	}

	private void pairSearch() {
	}

	private void pairInitialize() {
	}
}
