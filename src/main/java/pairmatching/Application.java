package pairmatching;

public class Application {
	private static boolean end = false;

	public static void main(String[] args) {
		while (!isEnd()) {
			try {
				InputView.printChooseOperation();
				PairMatcher matcher = new PairMatcher();
				chooseOperation(matcher);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static boolean isEnd() {
		return end;
	}

	public static void chooseOperation(PairMatcher matcher) {
		String input = InputView.getInputToOperate();
		if (input.equals("1")) {
			matcher.pairMatching();
		}
		if (input.equals("2")) {
			matcher.pairQuery();
		}
		if (input.equals("3")) {
			matcher.pairInitiate();
		}
		if (input.equals("Q")) {
			end = true;
		}
	}
}
