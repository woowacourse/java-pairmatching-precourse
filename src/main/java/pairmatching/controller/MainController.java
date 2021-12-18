package pairmatching.controller;

import pairmatching.domain.Order;
import pairmatching.domain.matcing.MatchingRepository;
import pairmatching.view.OutputView;

public class MainController {

	private final ViewController viewController;
	private final MatchingRepository matchingRepository;

	public MainController() {
		this.viewController = new ViewController();
		this.matchingRepository = new MatchingRepository();
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
			// TODO: 2021/12/18 matching
		}

		if (order.isSearch()) {
			// TODO: 2021/12/18 search
		}

		if (order.isInit()) {
			matchingRepository.init();
			OutputView.printInitMessage();
		}
	}

}
