package pairmatching.view;

import java.util.List;

public class OutputView {

	static final String ERROR_MSG = "[ERROR] ";
	static final String REPORT_MATCHING_MSG = "\n페어 매칭 결과입니다.";
	static final String MATCHING_SIGNATURE = " : ";
	static final String INIT_MATCHING_MSG = "\n초기화 되었습니다.\n";

	public void reportException(String message) {
		System.out.println(ERROR_MSG + message);
	}

	public void reportMatch(List<String> pair) {
		System.out.print(REPORT_MATCHING_MSG);
		for (int i = 0; i < pair.size() - 1; i += 2) {
			System.out.print("\n" + pair.get(i) + MATCHING_SIGNATURE + pair.get(i + 1));
		}
		if (pair.size() % 2 == 1) {
			System.out.println(MATCHING_SIGNATURE + pair.get(pair.size() - 1));
		}
		if (pair.size() % 2 == 0) {
			System.out.println();
		}
	}

	public void reportInit() {
		System.out.println(INIT_MATCHING_MSG);
	}
}
