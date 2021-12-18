package pairmatching.view;

public class OutputView {

	static final String ERROR_MSG = "[ERROR] ";

	public void reportException(String message) {
		System.out.println(ERROR_MSG + message);
	}
}
