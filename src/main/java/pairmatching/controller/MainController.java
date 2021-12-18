package pairmatching.controller;

import pairmatching.domain.Order;

public class MainController {

	private final ViewController viewController;

	public MainController() {
		this.viewController = new ViewController();
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
			// TODO: 2021/12/18 init
		}
	}

}
