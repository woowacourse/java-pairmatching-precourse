package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean isBackend(String course) {
        return BACKEND.name.equals(course);
    }

    @Override
    public String toString() {
        return name;
    }
}
