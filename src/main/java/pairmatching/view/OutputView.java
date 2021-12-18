package pairmatching.view;

public class OutputView {
	private static final String LINE = "#############################################";
	private static final String MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final String RESET_PAIR = "\n초기화 되었습니다. ";

	public static void printProcessAndMission(String process, String Misison) {
		System.out.println();
		System.out.println(LINE);
		System.out.println("과정: " + process);
		System.out.print("미션:");
		System.out.println(Misison);
		System.out.println(LINE);
	}

	public static void printCombination(String combination) {
		System.out.println();
		System.out.println(MATCHING_RESULT);
		System.out.println(combination);
	}

	public static void printResetPair() {
		System.out.println(RESET_PAIR);
	}
}
