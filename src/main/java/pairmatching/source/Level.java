package pairmatching.source;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Level {
    private static final String LEVEL_MISSION_DELIMITER = ": ";
    private static final String MISSION_DELIMITER = " | ";

    private static final String REMATCH_REQUEST   = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오 ";


    private String name;
    private HashMap<String, Mission> missionsMap = new HashMap<>();
    private CrewDataBase crewDataBase;

    public Level(String name, List<String> missions) {
        this.name = name;
        createMissionHashMap(missions);
        crewDataBase = new CrewDataBase();
    }

    private void createMissionHashMap(List<String> missions){

        for(String missionName: missions){
            missionsMap.put(missionName, new Mission(missionName));
        }

    }

    public void matchMissionPair(Course course,String missionName){
        Mission mission = missionsMap.get(missionName);

        if(mission.getIsMatched()){
            if(!checkRematchMissionPair()){
                return;
            }
        }

        mission.matchingPair(ReadCrewFile.getCrewNamesByCourse(course), crewDataBase.getCrewMapByCourse(course));
    }

    private boolean checkRematchMissionPair(){
        System.out.println(REMATCH_REQUEST);

        if(Console.readLine() == "네"){
            return true;
        }

        return false;
    }

    public void isExistMission(String missionName) throws IllegalArgumentException{

        if(missionsMap.containsKey(missionName)){
            throw new IllegalArgumentException("[Error]: 존재하지 않는 미션입니다.");
        }

    }

    @Override
    public String toString(){
        StringBuilder missionsOfLevel = new StringBuilder(this.name + LEVEL_MISSION_DELIMITER);
        Iterator<String> keys = missionsMap.keySet().iterator();

        while (keys.hasNext()){
            missionsOfLevel.append(keys.next());

            if(keys.hasNext()){
                missionsOfLevel.append(MISSION_DELIMITER);
            }
        }

        return missionsOfLevel.toString();
    }

    // 추가 기능 구현
}
