package pairmatching.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    RACING_CAR("자동차경주", "레벨1"),
    LOTTO("로또", "레벨1"),
    NUMBER_BASEBALL("숫자야구게임", "레벨1"),
    SHOPPING_BASKET("장바구니", "레벨2"),
    PAYMENT("결제", "레벨2"),
    SUBWAY_MAP("지하철노선도", "레벨2"),
    PERFORMANCE_IMPROVEMENT("성능개선", "레벨4"),
    DEPLOYMENT("배포", "레벨4");

    private String name;
    private String level;

    Mission(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static boolean isMatchMissionLevel(String name, String level) {
        System.out.println(findMission(level));
        for ( Mission missionName : findMission(level)) {
            System.out.println(missionName);
            if (missionName.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static List<Mission> findMission(String inputlevel) {
        return Arrays.asList(Mission.values()).stream().filter(levelNum -> levelNum.getLevel().equals(inputlevel)).collect(Collectors.toList());
    }

    public static List<String> getMissionList() {
        return Arrays.asList(Mission.values()).stream().map(mission -> mission.getName()).collect(Collectors.toList());
    }
}
