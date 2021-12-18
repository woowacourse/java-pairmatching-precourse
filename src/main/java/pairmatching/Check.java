package pairmatching;

public enum Check {
    YES("네");

    private String name;

    Check(String name) {
        this.name = name;
    }

    public static final boolean isYes(String input) {
        return YES.name.equals(input);
    }
}
