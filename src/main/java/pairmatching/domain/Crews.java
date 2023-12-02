package pairmatching.domain;

import pairmatching.domain.constants.Course;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private List<String> backend;
    private List<String> frontend;

    public Crews() {
        this.backend = new ArrayList<>();
        this.frontend = new ArrayList<>();
    }

    public void add(Course course, List<String> names) {
        if (course.equals(Course.BACKEND)) {
            backend.addAll(names);
        }
        if (course.equals(Course.FRONTEND)) {
            frontend.addAll(names);
        }
    }

    public List<String> getCrews(Course course) {
        if (course.equals(Course.BACKEND)) {
            return backend;
        }
        if (course.equals(Course.FRONTEND)) {
            return frontend;
        }
        throw new IllegalStateException("적합하지 않은 과정 입력입니다.");
    }
}
