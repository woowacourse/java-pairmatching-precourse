package pairmatching.status;

public enum Answer {
    YES("네"),
    NO("아니오"),
    EXIT("Q");

    private String name;

    Answer(String name) {
        this.name = name;
    }

    public static final boolean isYes(String input) {
        return YES.name.equals(input);
    }

    public static final boolean isNo(String input) {
        return YES.name.equals(input);
    }

    public static final boolean isExit(String input) {
        return EXIT.name.equals(input);
    }
}
