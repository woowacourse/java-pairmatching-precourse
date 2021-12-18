package pairmatching.model.information;

public enum Courses {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
