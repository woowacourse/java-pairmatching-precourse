package pairmatching.domain;

import java.util.Collections;
import java.util.List;

public class Courses {
    List<Course> courses;

    public Courses() {
        Collections.addAll(courses, Course.values());

    }


}
