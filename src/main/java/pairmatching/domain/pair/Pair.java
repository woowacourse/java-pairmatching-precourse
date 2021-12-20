package pairmatching.domain.pair;

import java.util.HashSet;
import java.util.Set;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;

public class Pair {
    public final String PAIR_ERROR_MISMATCH_OF_COURSE = "해당 크루는 페어의 과정과 다릅니다.";
    public final String PAIR_ERROR_CREW_EXIST_ALREADY = "페어에 해당 크루가 이미 존재합니다.";
    public final String PAIR_ERROR_CREWS_ARE_FULL = "해당 페어에 크루를 더이상 추가할 수 없습니다.";
    public final int MIN_CREW_COUNT = 2;
    public final int MAX_CREW_COUNT = 3;

    private Set<Crew> crews = new HashSet<>();
    private Course course;

    public Pair(Course course, Crew crew1, Crew crew2) {
        this.course = course;
        addCrew(crew1);
        addCrew(crew2);
    }

    public void addCrew(Crew crew) {
        checkCrewAddable();
        checkCrewNameExist(crew);
        checkCourse(crew);
        crews.add(crew);
    }

    public boolean isAddable() {
        return crews.size() < MAX_CREW_COUNT;
    }

    private void checkCrewAddable() {
        if (!isAddable()) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIR_ERROR_CREWS_ARE_FULL));
        }
    }

    private void checkCrewNameExist(Crew crew) {
        for (Crew crewOfPair : crews) {
            if (crewOfPair.getName().equals(crew.getName())) {
                throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                    PAIR_ERROR_CREW_EXIST_ALREADY));
            }
        }
    }

    private void checkCourse(Crew crew) {
        if (!course.equals(crew.getCourse())) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIR_ERROR_MISMATCH_OF_COURSE));
        }
    }
}
