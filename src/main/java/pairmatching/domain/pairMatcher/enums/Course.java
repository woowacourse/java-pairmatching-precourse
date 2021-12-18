package pairmatching.domain.pairMatcher.enums;

public enum Course {
    BACKEND("백엔드", "backend"),
    FRONTEND("프론트엔드", "frontend");

    private String name;
    private String path;

    Course(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
