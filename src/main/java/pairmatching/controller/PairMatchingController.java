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
		OutputView.printMain();
		String option = retryInput(() -> InputView.inputOption("1", "2", "3", "Q"));

		if (option.equals("1")) {
			pairMatching();
		}
	}

	public String retryInput(Supplier<String> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return retryInput(supplier);
		}
	}

	private void pairMatching() {
		List<Mission> missions = MissionRepository.findAll();
		OutputView.printMissionInformation(Arrays.asList(Course.values()), Arrays.asList(Level.values()), missions);
		String information = retryInput(InputView::inputMatchingInformation);
		List<String> matchingResult = pairMatchingService.match(information);

	}
}
