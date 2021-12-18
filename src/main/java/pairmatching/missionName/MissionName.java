package pairmatching.missionName;

import pairmatching.Course;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MissionName {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),

    SHOPPING_BAG("장바구니"),
    PAY("결제"),
    METRO("지하철노선도"),

    IMPROVE_PERFORMANCE("성능개선"),
    DEPLOY("배포"),
    ;

    private String missionName;

    MissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionName() {
        return this.missionName;
    }

    public static final List<String> MissionNameList = Arrays.stream(MissionName.values())
            .map(MissionName::getMissionName)
            .collect(Collectors.toList());

    public static final Map<String, String> COURSE_NAME_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(MissionName::getMissionName, MissionName::name))
    );

    public static MissionName of(final String courseName) {
        if (!MissionNameList.contains(courseName)) {
            throw new IllegalArgumentException("해당 이름의 코스가 없습니다.");
        }

        return MissionName.valueOf(COURSE_NAME_MAP.get(courseName));
    }
}
