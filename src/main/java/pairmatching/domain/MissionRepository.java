package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissionRepository {

    private static final List<Mission> missions = new ArrayList<>();

    public static List<Mission> getMissionsByLevel(Level level) {
        List<Mission> missionList = new ArrayList<>();
        for (Mission mission : missions) {
           if (!mission.getLevel().equals(level)) continue;
           missionList.add(mission);
        }
        return missionList;
    }

    public static Mission getMissionByName(String name) {
        for (Mission mission : missions) {
            if(!mission.getName().equals(name)) continue;
            return mission;
        }
        return null;
    }

    public static void addMission(Mission mission) {
            missions.add(mission);
        }

    public static void initMissionDatabase() {
        for (String missionName : Stream.of("자동차경주", "로또", "숫자야구게임").collect(Collectors.toList())) {
            addMission(new Mission(Level.LEVEL1, missionName));
        }

        for (String missionName : Stream.of("장바구니", "결제", "지하철노선도").collect(Collectors.toList())) {
            addMission(new Mission(Level.LEVEL2, missionName));
        }

        for (String missionName : Stream.of("성능개선", "배포").collect(Collectors.toList())) {
            addMission(new Mission(Level.LEVEL4, missionName));
        }
    }
}
