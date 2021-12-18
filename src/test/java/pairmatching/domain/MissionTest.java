package pairmatching.domain;

import org.junit.jupiter.api.Test;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.MissionName;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MissionTest {
    @Test
    void 미션_생성() {
        Mission mission = Mission.of(Course.BACKEND, Level.LEVEL1, MissionName.RACING_CAR);
        assertThat(mission.isName("자동차경주")).isTrue();
    }

    @Test
    void 미션의_페어_생성() {
        Mission mission = Mission.of(Course.BACKEND, Level.LEVEL1, MissionName.RACING_CAR);
        mission.makePairSet(Arrays.asList("대환","포비"));

        assertThat(mission.existsPairByNames("대환","포비")).isTrue();
    }
}
