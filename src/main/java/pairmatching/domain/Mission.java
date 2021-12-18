package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.domain.Level.*;

public enum Mission {

    CAR_RACING("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    BASEBALL("숫자야구게임", LEVEL1),
    SHOPPING_BASKET("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY_MAP("지하철노선도", LEVEL2),
    PERFORMANCE("성능개선", LEVEL4),
    DISTRIBUTE("배포", LEVEL4);


    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static void printMissionByLevel(Level level) {
        List<Mission> missions = getMissionByLevel(level);

        for (int i = 0; i < missions.size(); i++) {
            System.out.println(missions.get(i).name);

            if (i != missions.size() - 1) {
                System.out.println(" | ");
            }
        }
    }

    public static List<Mission> getMissionByLevel(Level level) {
        List<Mission> missionList = new ArrayList<>();

        Mission[] missions = Mission.values();

        for (Mission mission : missions) {
            if (mission.level == level) {
                missionList.add(mission);
            }
        }

        return missionList;
    }
}
