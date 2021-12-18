package pairmatching.domain;

import java.util.*;

public class MissionList {
    private final List<String> levelOneMission= new ArrayList<>(Arrays.asList("자동차경주", "로또", "숫자야구게임")) ;
    private final List<String> levelTwoMission= new ArrayList<>(Arrays.asList("장바구니", "결제", "지하철노선도")) ;
    private final List<String> levelThreeMission= new ArrayList<>() ;
    private final List<String> levelFourMission= new ArrayList<>(Arrays.asList("성능개선", "배포")) ;
    private final List<String> levelFiveMission= new ArrayList<>() ;

    private List<Crew> crew;
    private Map<Level, List<Mission>> missonMap;

    public MissionList(List<Crew> crew) {
        this.crew = crew;
        this.missonMap = new HashMap<>();
        initmissionMap(crew.get(0).getCourse());
    }

    public Mission getMission(String level, String missionName) {
        for (Mission mission : missonMap.get(returnLevelByLevelName(level))) {
            if (mission.getMissonName().equals(missionName)){
                return mission;
            }
        }
        return null;
    }

    public List<Set<String>> getLevelPairs(Level level) {
        List<Set<String>> levelPairs = new ArrayList<>();
        for (Mission mission : this.missonMap.get(level)){
            levelPairs.addAll(mission.getPairs());
        }
        return null;

    }


    private Level returnLevelByLevelName(String levelName) {
        for (Level level : Level.values()) {
            System.out.println("level = " + level.getName());
            System.out.println("levelName = " + levelName);
            if (level.getName().equals(levelName)){
                return level;
            }
        }
        return null;
    }


    private void initmissionMap(Course course){
        for (Level level : Level.values()){
            Map<Level, List<Mission>> levelMissionMap = new TreeMap<>();
            createLevelMap(level, levelMissionMap);
            this.missonMap = levelMissionMap;

         }
    }

    private void createLevelMap(Level level, Map<Level, List<Mission>> levelMissionMap) {
        for (List<String> missionNameLists : getAllList()) {
            List<Mission> missionList = new ArrayList<>();
            for (String mission : missionNameLists) {
                missionList.add(new Mission(mission, getCrewName(this.crew)));
            }
            levelMissionMap.put(level, missionList);
        }
    }

    private List<String> getCrewName(List<Crew> crews) {
        List<String> crewNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewNames.add(crew.getName());
        }
        return crewNames;
    }

    private List<List<String>> getAllList() {
        List<List<String>> allMissionList = new ArrayList<>();
        allMissionList.add(levelOneMission);
        allMissionList.add(levelTwoMission);
        allMissionList.add(levelThreeMission);
        allMissionList.add(levelFourMission);
        allMissionList.add(levelFiveMission);
        return allMissionList;
    }

}
