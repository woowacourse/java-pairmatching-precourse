package vo;

public enum FeatureCommand {
    MATCHING("1", "페어 매칭"),
    FIND("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String command;
    private final String description;

    FeatureCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
