package pairmatching.crew;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseName(String name) {
        for(Course course : Course.values()) {
            if(course.name.equals(name))
                return course;
        }
        return null;
    }
}
