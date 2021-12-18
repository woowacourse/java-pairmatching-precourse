package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseFromInput(String input) {
        Course course = Course.findBy(input);

        if (course == null) {
            throw new IllegalArgumentException("[ERROR] 잘못된 과정을 입력하셨습니다.");
        }

        return course;
    }

    private static Course findBy(String arg) {
        for (Course course : values()) {
            if (course.name().equals(arg)) {
                return course;
            }
        }

        return null;
    }

    public static void printCourse() {
        System.out.println(BACKEND.name + " | " + FRONTEND.name);
    }
}
