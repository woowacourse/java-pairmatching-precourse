package pairmatching;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    ;

    private String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
