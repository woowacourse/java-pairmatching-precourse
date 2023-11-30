package pairmatching.view.constant;

public enum PrintFormat {
    RESPONSE_PAIR_RESULT("%s :  %s");

    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format + System.lineSeparator();
    }
}
