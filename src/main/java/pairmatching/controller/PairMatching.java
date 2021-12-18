package pairmatching.controller;

import static pairmatching.enums.ErrorMessage.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.enums.FeatureEnum;
import pairmatching.service.PairMatchingService;

public class PairMatching {
	private PairMatchingService pairMatchingService;

	public PairMatching() {
		pairMatchingService = new PairMatchingService();
	}

	public void executeFeature() {
		while (true) {
			String feature = inputExecuteFeature().getMessage();
			FeatureEnum.validateDomain(feature);
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
	}

	private void pairMatching() {
		outputCourseAndLevel();
		RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
		pairMatchingService.matching(requestCourseAndLevelAndMissionDto);
	}

	private void pairSearch() {
		outputCourseAndLevel();
		RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
	}

	private void pairInitialize() {
	}
}
