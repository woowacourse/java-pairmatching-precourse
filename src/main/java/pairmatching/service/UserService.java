package pairmatching.service;

import static pairmatching.utils.Constant.*;

import pairmatching.utils.Parser;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private final PairMatchingService pairMatchingService = new PairMatchingService();

	public String getUserMode() {
		try {
			String mode = InputView.inputPairMode();
			Validator.validateMode(mode);

			return mode;
		} catch (IllegalArgumentException e) {
			OutputView.errorMessage(e.getMessage());
		}

		return AGAIN;
	}

	public List<String> getUserPairMatchingCourseLevelMission() {
		try {
			String pairMatchingInfos = InputView.inputPairMatchingInfo();
			List<String> infos = Parser.parsePairMatchingInfo(pairMatchingInfos);
			if (pairMatchingService.checkInList(infos)) {
				return infos;
			}
		} catch (IllegalArgumentException e) {
			OutputView.errorMessage(e.getMessage());
		}
		return NOT_EXISTED;
	}
}
