package pairmatching.controller;

import java.util.Optional;

import pairmatching.domain.Menu;
import pairmatching.domain.Order;
import pairmatching.domain.ReMatching;
import pairmatching.domain.matcing.Matching;
import pairmatching.domain.matcing.MatchingRepository;
import pairmatching.view.OutputView;

public class MainController {

	private final ViewController viewController;
	private final MatchingRepository matchingRepository;
	private final SearchController searchController;
	private final MatchingController matchingController;

	public MainController() {
		this.viewController = new ViewController();
		this.matchingRepository = new MatchingRepository();
		this.searchController = new SearchController(matchingRepository, viewController);
		this.matchingController = new MatchingController(matchingRepository);
	}

	public void run() {
		while (true) {
			Order order = viewController.returnOrder();
			if (order.isFinish()) {
				break;
			}

			executeOrder(order);
		}
	}

	private void executeOrder(Order order) {
		if (order.isMatching()) {
			OutputView.printMenu();
			matching();
		}

		if (order.isSearch()) {
			OutputView.printMenu();
			searchController.search();
		}

		if (order.isInit()) {
			matchingRepository.init();
			OutputView.printInitMessage();
		}
	}

	private void matching() {
		Menu menu = viewController.returnMenu();
		Optional<Matching> matching = matchingRepository.findMatching(menu);
		if (matching.isPresent()) {
			ReMatching reMatching = viewController.returnReMatching();
			if (reMatching.isNoWantReMatch()) {
				matching();
				return;
			}

			matchingRepository.deleteMatching(matching.get());
		}

		matchingController.matching(menu);
	}

}
