package pairmatching.controller;

import org.junit.jupiter.api.Test;
import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.MissionName;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingControllerTest {

    @Test
    void 미션_생성() {
        MatchingController.makeMission(Course.BACKEND,
                Level.LEVEL1,
                MissionName.RACING_CAR,
                Arrays.asList("대환","포비"));

        assertThat(MatchingController.hasMission(Level.LEVEL1, MissionName.RACING_CAR))
                .isTrue();
    }
}
