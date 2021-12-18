package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MissionRepository {
    private static final List<Mission> missions = new ArrayList<>();

    private MissionRepository() {
    }

    public static void init() {
        addMission("자동차경주", 1);
        addMission("로또", 1);
        addMission("숫자야구게임", 1);
        addMission("장바구니", 2);
        addMission("결제", 2);
        addMission("지하철노선도", 2);
        addMission("성능개선", 4);
        addMission("배포", 4);
    }

    public static void addMission(String missionName, int level) {
        missions.add(new Mission(missionName, level));
    }

    public static void print() {
        for (Mission m : missions) {
            System.out.println(m.toString());
        }
    }
}
