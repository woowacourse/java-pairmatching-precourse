package pairmatching;

public enum ChoiceView {
	PAIR_MATCHING("1", "페어 매칭"),
	PAIR_LOOKUP("2", "페어 조회"),
	PAIR_RESET("3", "페어 초기화"),
	EXIT("Q", "종료");

	private static final String CHOICE_VIEW_PRINT_FORMAT = "%s. %s\n";

	private final String index;
	private final String message;

	ChoiceView(String index, String message) {
		this.index = index;
		this.message = message;
	}

	//public abstract void run();

	public static void print() {
		for (ChoiceView choice : ChoiceView.values()) {
			System.out.printf(CHOICE_VIEW_PRINT_FORMAT, choice.index, choice.message);
		}
	}
}
