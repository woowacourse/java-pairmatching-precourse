package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.Objects;

import pairmatching.domain.mission.enums.MissionEnum;

public class Mission {
    public static final String NON_EXIST_MISSION_EXCEPTION = "[ERROR] 존재하지 않는 미션입니다.";
    private String name;

    public Mission(String name) {
        validateMission(name);
        this.name = name;
    }

    private void validateMission(String name) {
        if (!existMission(name)) {
            throw new IllegalArgumentException(NON_EXIST_MISSION_EXCEPTION);
        }
    }

    private boolean existMission(String name) {
        return Arrays.stream(MissionEnum.values()).anyMatch(mission -> mission.getName().equals(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mission mission = (Mission)o;
        return Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
