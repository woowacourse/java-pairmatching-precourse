package pairmatching.domain;

import java.util.Objects;
import pairmatching.exception.CrewNameEmptyException;

public class Crew {

    private static final String EMPTY_NAME = "";

    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        checkNameIsEmpty(name);
        this.course = course;
        this.name = name;
    }

    private static void checkNameIsEmpty(String name) {
        if (Objects.isNull(name) || name.trim().equals("")) {
            throw new CrewNameEmptyException();
        }
    }
}
