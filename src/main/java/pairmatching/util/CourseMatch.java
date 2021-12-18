package pairmatching.util;

import pairmatching.Course;

public class CourseMatch {
    public static Course getCourse(String course) {
        Course[] all = Course.values();
        for (Course c : all) {
            if (c.getName().equals(course)) {
                return c;
            }
        }
        return null;
    }
}
