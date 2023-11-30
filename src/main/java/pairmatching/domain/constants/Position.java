package pairmatching.domain.constants;

public enum Position {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
