package pairmatching.system.convertion;

import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.vo.PairMatchingInfo;

import java.util.List;

public class StringToPairMatchingInfoConverter {

    public static final String INVALID_MISSION_INPUT_MESSAGE = "입력한 값과 일치하는 미션이 없습니다.";

    public static PairMatchingInfo convert(String input, List<Mission> missions) {
        // TODO: 검증 필요하다.
        String[] splitedInput = input
                .replaceAll(" ", "")
                .split(",");
        return new PairMatchingInfo(
                getCourse(splitedInput),
                getMission(missions, splitedInput)
        );
    }

    private static Course getCourse(String[] splitedInput) {
        return Course.findByName(splitedInput[0]);
    }

    private static Mission getMission(List<Mission> missions, String[] splitedInput) {
        return missions.stream()
                .filter(mission ->
                        mission.getLevel().getName().equals(splitedInput[1]) &&
                                mission.getName().equals(splitedInput[2]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_INPUT_MESSAGE));
    }
}
