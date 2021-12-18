package pairmatching;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.common.Course;
import pairmatching.common.MainCategory;
import pairmatching.controller.MatchingController;
import pairmatching.domain.Backends;
import pairmatching.domain.Frontends;
import pairmatching.domain.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatching {
	private static final OutputView outputView = new OutputView();
	private static final InputView inputView = new InputView();
	private static final MatchingController matchingController = new MatchingController(inputView, outputView);
	private static final String MATCH = "1";
	private static final String EXIT = "Q";

	public PairMatching () throws IOException {
		initializeCrewList();
	}

	public void run() {
		outputView.printMenus();
		while (true) {
			try {
				String option = askOptionChoice();
				if (option.equals(MATCH)) {
					matchingController.run();
				}
				if (option.equals(EXIT)){
					break;
				}
			} catch (IllegalArgumentException e) {
				outputView.printError(e.getMessage());
			}
		}
	}

	private String askOptionChoice() {
		List<MainCategory> mainCategoryList = Arrays.stream(MainCategory.values()).collect(Collectors.toList());
		return inputView.selectMainCategory(mainCategoryList);
	}

	public void initializeCrewList() throws IOException {
		Backends.initialize(Course.BACKEND);
		Frontends.initialize(Course.BACKEND);
	}
}
