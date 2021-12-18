package pairmatching;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return name;
    }

    public boolean checkCourse(String requiredName) {
        return this.name.equals(requiredName);
    }
}
