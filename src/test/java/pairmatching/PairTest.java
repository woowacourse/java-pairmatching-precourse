package pairmatching;

import org.junit.jupiter.api.Test;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.domain.pair.Pair;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    Crew c1;
    Crew c2;
    Crew c3;
    Crew c4;
    Pair pair;

    @Test
    void test_Pair_NormalUsage() {
        initCrewRepo();
        assertFalse(c1.equals(c2));
        Pair pair = new Pair(Course.BACKEND, c1, c2);
        pair.addCrew(c3);
    }

    @Test
    void test_Pair_exception_duplicatedCrew() {
        initCrewRepo();
        assertSimpleTest(() -> {
            String error = "";
            try {
                Pair duplicatedCrewPair = new Pair(Course.BACKEND, c1, c1);
            } catch (IllegalArgumentException exception) {
                error = exception.getMessage();
            }
            assertTrue(error.contains(pair.PAIR_ERROR_CREW_EXIST_ALREADY));
            try {
                Pair duplicatedCrewPair = new Pair(Course.BACKEND, c1, c2);
                duplicatedCrewPair.addCrew(c2);
            } catch (IllegalArgumentException exception) {
                error = exception.getMessage();
            }
            assertTrue(error.contains(pair.PAIR_ERROR_CREW_EXIST_ALREADY));
        });
    }

    @Test
    void test_Pair_exception_overAdd() {
        initCrewRepo();
        assertSimpleTest(() -> {
            String error = "";
            try {
                Pair overPair = new Pair(Course.BACKEND, c1, c2);
                assertTrue(overPair.isAddable());
                overPair.addCrew(c3);
                assertFalse(overPair.isAddable());
                overPair.addCrew(c4);
            } catch (IllegalArgumentException exception) {
                error = exception.getMessage();
            }
            assertTrue(error.contains(pair.PAIR_ERROR_CREWS_ARE_FULL));
        });
    }

    void initCrewRepo() {
        CrewRepository.initialize();
        c1 = CrewRepository.getCrewsOfCourse(Course.BACKEND).get(0);
        c2 = CrewRepository.getCrewsOfCourse(Course.BACKEND).get(1);
        c3 = CrewRepository.getCrewsOfCourse(Course.BACKEND).get(2);
        c4 = CrewRepository.getCrewsOfCourse(Course.BACKEND).get(3);
        pair = new Pair(Course.BACKEND, c1, c2);
    }
}
