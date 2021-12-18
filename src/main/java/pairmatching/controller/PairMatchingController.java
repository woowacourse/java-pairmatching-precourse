package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.application.PairMatchingService;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private PairMatchingService pairMatchingService = new PairMatchingService();

	public void service() {
		while (true) {
			OutputView.printMain();
			String option = retryInput(() -> InputView.inputOption("1", "2", "3", "Q"));

			if (option.equals("1")) {
				pairMatching();
			} else if(option.equals("Q")) {
				break;
			}
		}
	}

	private void pairMatching() {
		List<Mission> missions = MissionRepository.findAll();
		OutputView.printMissionInformation(Arrays.asList(Course.values()), Arrays.asList(Level.values()), missions);
		handlePairMatching();
	}

	private void handlePairMatching() {
		try {
			String information = retryInput(InputView::inputMatchingInformation);
			boolean wantToMatch = isWantToMatch(information);

			if (wantToMatch) {
				pairMatchingService.match(parseToCourse(information), parseToLevel(information),
					parseToMission(information));
			}

			OutputView.printMatchingResult(pairMatchingService.findByMissionName(parseToMission(information)));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			handlePairMatching();
		}
	}

	private boolean isWantToMatch(String information) {
		boolean wantToMatch = true;

		if (pairMatchingService.hasMatched(parseToMission(information))) {
			OutputView.printRematchingMessage();
			String value = retryInput(() -> InputView.inputOption("네", "아니오"));
			wantToMatch = parseToIsWantToMatch(value);
		}

		return wantToMatch;
	}

	private boolean parseToIsWantToMatch(String value) {
		if (value.equals("아니오")) {
			return false;
		}
		return true;
	}

	private String parseToCourse(String information) {
		return information.split(",")[0].trim();
	}

	private String parseToLevel(String information) {
		return information.split(",")[1].trim();
	}

	private String parseToMission(String information) {
		return information.split(",")[2].trim();
	}

	private String retryInput(Supplier<String> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return retryInput(supplier);
		}
	}
}
