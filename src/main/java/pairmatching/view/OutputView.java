package pairmatching.view;

public class OutputView {
	private static final String LINE = "#############################################";

	public static void printProcessAndMission(String process, String Misison) {
		System.out.println(LINE);
		System.out.println("과정: " + process);
		System.out.print("미션:");
		System.out.println(Misison);
		System.out.println(LINE);
		System.out.println("과정, 레벨, 미션을 선택하세요.");
	}
}
