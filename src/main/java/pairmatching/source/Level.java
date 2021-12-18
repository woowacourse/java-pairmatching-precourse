package pairmatching.source;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.StringConstant;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", new String[] {"자동차경주", "로또","숫자야구게임"}),
    LEVEL2("레벨2", new String[] {"장바구니", "결제","지하철노선도"}),
    LEVEL3("레벨3",  new String[]{}),
    LEVEL4("레벨4",  new String[] {"성능개선", "배포"}),
    LEVEL5("레벨5",   new String[]{});

    private static final String LEVEL_MISSION_DELIMITER = ": ";
    private static final String MISSION_DELIMITER = " | ";

    private static final String REMATCH_REQUEST   = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오 ";
    private static final String NOT_FOUND_ERROR= "존재하지 않는 레벨입니다.";

    private String name;
    private HashMap<String, Mission> missionsMap = new HashMap<>();
    private CrewDataBase crewDataBase;

    Level(String name, String[] missions) {
        this.name = name;
        createMissionHashMap(missions);
        crewDataBase = new CrewDataBase();
    }

    private void createMissionHashMap(String[] missions){

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

    public String getName(){
        return name;
    }

    public static void checkExistLevel(String name) throws IllegalArgumentException{
        Level[] levels = Level.values();

        for(Level level : levels){
            if(level.name == name){
                return;
            }
        }

        throw new IllegalArgumentException(StringConstant.ERROR_MESSAGE_PREFIX +NOT_FOUND_ERROR);
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

}
