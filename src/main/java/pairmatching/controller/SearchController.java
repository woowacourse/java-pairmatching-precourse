package pairmatching.controller;

import static pairmatching.view.OutputView.*;

import pairmatching.domain.Menu;
import pairmatching.domain.matcing.Matching;
import pairmatching.domain.matcing.MatchingRepository;

public class SearchController {

	private final MatchingRepository matchingRepository;
	private final ViewController viewController;

	public SearchController(MatchingRepository matchingRepository, ViewController viewController) {
		this.matchingRepository = matchingRepository;
		this.viewController = viewController;
	}

	public void search() {
		Menu menu = viewController.returnMenu();
		try {
			Matching matching = matchingRepository.findMatching(menu)
				.orElseThrow(() -> new IllegalArgumentException("매칭 이력이 없습니다."));
			printMatching(matching.getPairs());
		} catch (IllegalArgumentException exception) {
			printError(exception);
			search();
		}
	}

}
