package pairmatching.view;

import static pairmatching.utils.Constant.*;
import static pairmatching.view.ErrorMessage.*;
import static pairmatching.view.Message.*;

import java.util.List;

public class OutputView {
	public static void errorMessage(String errorMessage) {
		System.out.println(ERROR + errorMessage + NEXT_LINE);
	}

	public static void pairMatchingView() {
		System.out.println(PAIR_MATCHING);
	}

	public static void showMatchingCrews(List<String> crews) {
		for (int i = 0; i < crews.size(); i++) {
			if (isOdd(crews, i)) {
				printPairCrews(crews, i, SHOW_THREE);
				break;
			}
			printPairCrews(crews, i, SHOW_TWO);
		}
		System.out.println(NEXT_LINE);
	}

	private static boolean isOdd(List<String> crews, int i) {
		return crews.size() - i == SHOW_THREE;
	}

	private static void printPairCrews(List<String> crews, int start, int end) {
		String printCrews = String.join(" : ", crews.subList(start, start + end));
		System.out.println(printCrews);
	}

	public static void showResetSuccess() {
		System.out.println(RESET_SUCCESS);
	}
}
