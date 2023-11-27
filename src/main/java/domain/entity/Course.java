package domain.entity;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String filePath;

    Course(final String name, final String filePath) {
        this.name = name;
        this.filePath = filePath;
    }


    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }
}