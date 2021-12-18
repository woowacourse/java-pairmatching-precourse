package pairmatching.model.matching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.crew.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingHistoryTest {
    private Course course = Course.BACKEND;
    private Level level = Level.LEVEL1;
    private Mission mission = Mission.LOTTO;
    private CrewPair first = new CrewPair(Crew.of("a", "백엔드"), Crew.of("b", "백엔드"));
    private CrewPair second = new CrewPair(Crew.of("c", "백엔드"), Crew.of("d", "백엔드"));
    private CrewPair third = new CrewPair(Crew.of("e", "백엔드"), Crew.of("f", "백엔드"));
    private CrewPair fourth = new CrewPair(Crew.of("g", "백엔드"), Crew.of("h", "백엔드"));

    @Test
    @DisplayName("")
    void hasMatchedBeforeInSameLevel_True() {
        List<CrewPair> crewPairs = Arrays.asList(first, second);
        MatchingHistory matchingHistory = new MatchingHistory(course, level, mission, crewPairs);
        List<CrewPair> another = Arrays.asList(second, third);
        boolean actual = matchingHistory.hasMatchedBeforeInSameLevel(another, level);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("")
    void hasMatchedBeforeInSameLevel_False() {
        List<CrewPair> crewPairs = Arrays.asList(first, second);
        MatchingHistory matchingHistory = new MatchingHistory(course, level, mission, crewPairs);
        List<CrewPair> another = Arrays.asList(third, fourth);
        boolean actual = matchingHistory.hasMatchedBeforeInSameLevel(another, level);
        assertThat(actual).isFalse();
    }
}