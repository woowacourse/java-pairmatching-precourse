package pairmatching.domain.pair;

import java.util.ArrayList;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;

public class PairList {
    public static final String PAIRLIST_ERROR_NO_SAME_COURSE = "페어리스트의 과정과 페어의 과정이 다릅니다.";
    public static final String PAIRLIST_ERROR_NO_COURSE_SETTED = "페어리스트의 과정이 아직 존재하지 않습니다.";

    private final ArrayList<Pair> pairList = new ArrayList<>();
    private Course course;

    public PairList() {
        deleteAll();
    }

    public void deleteAll() {
        pairList.clear();
    }

    public void addPair(Pair pair) {
        if (isEmpty()) {
            this.course = pair.getCourse();
        }
        checkSameCourse(pair);
        pairList.add(pair);
    }

    public boolean isEmpty() {
        return pairList.isEmpty();
    }

    public Course getCourse() {
        checkMyCourseNotNull();
        return course;
    }

    private void checkMyCourseNotNull() {
        if (course == null) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIRLIST_ERROR_NO_COURSE_SETTED));
        }
    }

    private void checkSameCourse(Pair pair) {
        if (!this.course.equals(pair.getCourse())) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIRLIST_ERROR_NO_SAME_COURSE));
        }
    }
}


