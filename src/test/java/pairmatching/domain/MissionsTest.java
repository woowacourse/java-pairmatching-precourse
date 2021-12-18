package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MissionsTest {

    @Test
    @DisplayName("동일한 이름의 미션이 저장될 경우 exception이 발생해야 한다.")
    void addDuplicateMissionTest() {
        // given
        Missions missions = Missions.init();
        Mission mission = Mission.createEmptyMission("mission", Course.BACKEND);
        missions.addMission(mission);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> missions.addMission(mission))
            .withMessage("[ERROR] 동일한 이름의 미션이 저장될 수 없습니다.");
    }
}