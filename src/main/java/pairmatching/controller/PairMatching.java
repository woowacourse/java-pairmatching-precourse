package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.dto.ResponsePairsDto;
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
		while (true) {
			RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
			if (pairMatchingService.hasPairs(requestCourseAndLevelAndMissionDto)) {
				if (inputRematching()) {
					continue;
				}
			}
			matching(requestCourseAndLevelAndMissionDto);
			return;
		}
	}

	private void matching(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		pairMatchingService.matching(requestCourseAndLevelAndMissionDto);
		ResponsePairsDto responsePairsDto = pairMatchingService.getPairs(requestCourseAndLevelAndMissionDto);
		outputPairsResult(responsePairsDto);
	}

	private void pairSearch() {
		outputCourseAndLevel();
		RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
		ResponsePairsDto responsePairsDto = pairMatchingService.getPairs(requestCourseAndLevelAndMissionDto);
		outputPairsResult(responsePairsDto);
	}

	private void pairInitialize() {
	}
}
