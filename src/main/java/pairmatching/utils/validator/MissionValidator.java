package pairmatching.utils.validator;

import static pairmatching.utils.Error.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Mission;

public class MissionValidator {

    public static void validate(String mission) {
        List<String> missionList = Arrays.asList(Mission.values()).stream()
            .map(Mission::getName)
            .collect(Collectors.toList());
        if (!missionList.contains(mission)) {
            throw new IllegalArgumentException(MISSION_NOT_EXIST);
        }
    }
}
