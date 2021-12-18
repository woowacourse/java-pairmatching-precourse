package pairmatching.enums;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private String name;
    private String path;

    Course(String name, String path) {
        this.name = name;
        this.path = path;
    }

    // 추가 기능 구현
    public String getName() {
       return this.name;
    }

    public String getPath() {
        return this.path;
    }
}