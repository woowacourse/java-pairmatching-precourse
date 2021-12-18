package pairmatching.constant;

public enum SystemMessage {
    printGetCourseMessage("과정, 레벨, 미션을 선택하세요.");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
