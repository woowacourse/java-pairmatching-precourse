package pairmatching.utils;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class OptionInputUtils {

    public static Course courseNameToDomain(String name) {
        for (Course course : Course.values()) {
            if (!course.getName().equals(name)) continue;
            return course;
        }
        return null;
    }

    public static Level levelNameToDomain(String name) {
        for (Level level : Level.values()) {
            if (!level.getName().equals(name)) continue;
            return level;
        }
        return null;
    }
}
