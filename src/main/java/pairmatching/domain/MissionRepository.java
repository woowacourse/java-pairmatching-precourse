package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static String print() {
        StringBuilder infos = new StringBuilder();
        for (Level l : Level.values()) {
            infos.append("\n");
            infos.append(l.toString());
            infos.append(getMissionsByLevel(l));
        }
        return infos.toString();
    }

    private static String getMissionsByLevel(Level l) {
        List<String> names = missions.stream().filter(m -> m.level == l).map(m -> m.getName()).collect(Collectors.toList());
        return String.join(" | ", names);
    }

    public static Mission getMissionByName(String name) {
        return missions.stream().filter(m -> m.isSameName(name)).findFirst().orElse(null);
    }
}
