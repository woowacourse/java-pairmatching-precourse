package pairmatching.controller;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.dto.ResponsePairsDto;
import pairmatching.enums.FeatureEnum;
import pairmatching.service.PairMatchingService;

public class PairMatching {
	private static final boolean RESTART = true;
	private static final boolean END = false;
	private PairMatchingService pairMatchingService;

	public PairMatching() {
		pairMatchingService = new PairMatchingService();
	}

	public void executeFeature() {
		while (true) {
			try {
				String feature = inputExecuteFeature().getMessage();
				FeatureEnum.validateDomain(feature);
				if (execute(feature)) {
					return;
				}
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	private boolean execute(String feature) {
		if (FeatureEnum.PAIR_MATCHING.isSame(feature)) {
			outputCourseAndLevel();
			while (pairMatching()) {
				System.out.println();
			}
		}
		if (FeatureEnum.PAIR_SEARCH.isSame(feature)) {
			pairSearch();
		}
		if (FeatureEnum.PAIR_INITIALIZE.isSame(feature)) {
			pairInitialize();
		}
		if (FeatureEnum.EXIT.isSame(feature)) {
			return true;
		}
		return false;
	}

	private boolean pairMatching() {
		while (true) {
			try {
				RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
				pairMatchingService.validatePairs(requestCourseAndLevelAndMissionDto);
				if (pairMatchingService.hasPairs(requestCourseAndLevelAndMissionDto) && inputRematching()) {
					return RESTART;
				}
				matching(requestCourseAndLevelAndMissionDto);
				return END;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	private void matching(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		pairMatchingService.matching(requestCourseAndLevelAndMissionDto);
		ResponsePairsDto responsePairsDto = pairMatchingService.getPairs(requestCourseAndLevelAndMissionDto);
		outputPairsResult(responsePairsDto);
	}

	private void pairSearch() {
		outputCourseAndLevel();
		while (true) {
			try {
				RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto = inputCourseAndLevelAndMission();
				pairMatchingService.validatePairs(requestCourseAndLevelAndMissionDto);
				ResponsePairsDto responsePairsDto = pairMatchingService.getPairs(requestCourseAndLevelAndMissionDto);
				outputPairsResult(responsePairsDto);
				return;
			} catch (IllegalArgumentException e) {
				outputExceptionMessage(e);
			}
		}
	}

	private void pairInitialize() {
		pairMatchingService.init();
		outputInitPair();
	}
}
