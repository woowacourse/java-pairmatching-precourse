package pairmatching.domain;

public enum NameList {
    FRONTEND_NAMELIST(Course.FRONTEND, "src/main/resources/frontend-crew.md"),
    BACKEND_NAMELIST(Course.BACKEND, "src/main/resources/backend-crew.md");

    private Course course;
    private String filePath;

    NameList(Course course, String filePath) {
        this.course = course;
        this.filePath = filePath;
    }

    public Course getCourse() {
        return course;
    }

    public String getFilePath() {
        return filePath;
    }
}
