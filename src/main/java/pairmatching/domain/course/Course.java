package pairmatching.domain.course;

public enum Course {
    BACKEND("백엔드","./src/main/resources/backend-crew.md" ),
    FRONTEND("프론트엔드", "./src/main/resources/frontend-crew.md");

    private String name;
    private String sourceFileName;

    Course(String name, String sourceFileName) {
        this.name = name;
        this.sourceFileName = sourceFileName;
    }

    // 추가 기능 구현
    public String toString() {
        return name;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }
}