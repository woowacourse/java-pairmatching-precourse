package pairmatching.domain.course;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프런트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
