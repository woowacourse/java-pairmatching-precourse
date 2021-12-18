package pairmatching;

public class Application {
    public static void main(String[] args) {
        InputView.printChooseOperation();
        PairMatcher matcher = new PairMatcher();
        chooseOperation(matcher);
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
            matcher.end();
        }
    }
}
