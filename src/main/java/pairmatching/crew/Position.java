package pairmatching.crew;

public enum Position {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }
}
