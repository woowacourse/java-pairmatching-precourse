package pairmatching.view;

import java.util.List;

public class OutputView {

	static final String ERROR_MSG = "[ERROR] ";

	public void reportException(String message) {
		System.out.println(ERROR_MSG + message);
	}

	public void reportMatch(List<String> pair) {
		System.out.println(pair);
	}
}
