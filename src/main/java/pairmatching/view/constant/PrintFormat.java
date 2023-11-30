package pairmatching.view.constant;

public enum PrintFormat {
    RESPONSE_USER_COIN("투입 금액: %d원"),
    RESPONSE_CHARGE_COIN("%d원 - %d개");

    private final String format;

    PrintFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format + System.lineSeparator();
    }
}
