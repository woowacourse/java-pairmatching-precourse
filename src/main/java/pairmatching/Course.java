package pairmatching;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course setName(String end) {
        for (Course course : Course.values()) {
            if (course.name.equals(end)) {
                return course;
            }
        }
        return null;
    }

    public static Boolean JudgeCourse(String end) {
        for (Course course : Course.values()) {
            if (course.name.equals(end)) {
                return true;
            }
        }
        return false;
    }


}