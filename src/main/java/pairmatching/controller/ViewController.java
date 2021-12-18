package pairmatching.controller;

import pairmatching.validator.OrderValidator;
import pairmatching.view.InputView;

public class ViewController {

	public String returnOrder() {
		String order = InputView.getOrder();
		OrderValidator.checkOrder(order);
		return order;
	}

}
