package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.common.MainCategory;
import pairmatching.controller.MatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatching {
	private static final OutputView outputView = new OutputView();
	private static final InputView inputView = new InputView();
	private static final MatchingController matchingController = new MatchingController(inputView, outputView);
	private static final String MATCH = "1";

	public void run() {
		outputView.printMenus();
		while (true) {
			try {
				String option = askOptionChoice();
				if (option.equals(MATCH)) {
					matchingController.run();
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
}
