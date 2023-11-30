package pairmatching.view.constant;

public enum InputMessage {
    REQUEST_BUY_PRODUCT("구매할 상품명을 입력해 주세요.");
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
