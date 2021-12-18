package pairmatching.view;

import static pairmatching.constants.ErrorMessage.*;

public class ErrorView {
	public static void printError(String msg) {
		System.out.println(ERROR_PREFIX + msg);
	}

}
