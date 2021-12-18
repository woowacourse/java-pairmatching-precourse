package pairmatching.repository;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;

public class MissionRepository {
    private static final List<Mission> missions = new ArrayList<>();

    public static void addMission(Mission mission){
        missions.add(mission);
    }
    public static Mission findMissionByInfo(Course course, Level level, String name){

        Mission findMission = missions.stream()
                .filter(mission -> mission.isEqual(course,level,name))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 미션입니다."));
        return findMission;
    }
}
