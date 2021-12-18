package pairmatching.controller;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import pairmatching.view.InputView;

public class PairmatchingController {

	public void run() {
		String input = "";
		do {
			input = InputView.chooseEntryMenu();
		} while (!input.equals(QUIT));
	}
}
