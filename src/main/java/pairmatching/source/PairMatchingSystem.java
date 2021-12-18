package pairmatching.source;

import pairmatching.constants.StringConstant;
import pairmatching.utils.FunctionInputChecker;
import pairmatching.utils.PairingInputChecker;

import java.util.HashMap;

public class PairMatchingSystem {
    private static final String DRAW_LINE = "#############################################";

    private static final int CONTENT_COURSE_INDEX =  0;
    private static final int CONTENT_LEVEL_INDEX =  1;
    private static final int CONTENT_MISSION_INDEX =  2;

    private static final String CONTENT_SPLIT_REGEX =  ",";
    private static final String COURSE_TITLE =  "과정: ";
    private static final String COURSE_DELIMITER = " | ";
    private static final String Mission_TITLE =  "미션: ";

    private HashMap<String, Level> levelMap = new HashMap<>();

    public PairMatchingSystem(){
        systemInit();
    }

    private void systemInit(){
        Level[] levels = Level.values();

        for(Level currentLevel : levels){
            levelMap.put(currentLevel.getName(), currentLevel);
        }

    }

    public void runStart(){
        String functionSymbol;

        do{
            functionSymbol = FunctionInputChecker.getFunctionInput();
            runFunction(functionSymbol);
        }while(!functionSymbol.equals(StringConstant.FUNCTION_END));
    }

    private void runFunction(String functionSymbol){
        if(functionSymbol.equals(StringConstant.FUNCTION_MATCHING)){
            matchingFunction();
            return;
        }

        if(functionSymbol.equals(StringConstant.FUNCTION_SEARCHING)){
            searchingFunction();
            return;
        }
    }

    private void searchingFunction(){
        String contentsInput = getRightContentsInput();

        contentsInput = contentsInput.replaceAll("\\s", "");
        String[] contents = contentsInput.split(CONTENT_SPLIT_REGEX);

        Level level = levelMap.get(contents[CONTENT_LEVEL_INDEX]);
        Mission mission = level.getMissionByName(contents[CONTENT_MISSION_INDEX]);

        mission.printMatchedPairs();
    }

    private String getRightContentsInput(){
        printAllSystemData();
        String pairingInput;
        do{
            pairingInput = PairingInputChecker.getPairingInput();
            pairingInput = pairingInput.replaceAll("\\s", "");
        }while(!checkExistContents(pairingInput.split(CONTENT_SPLIT_REGEX)));

        return pairingInput;
    }

    private void matchingFunction(){
        String pairingInput =getRightContentsInput();

        pairingInput = pairingInput.replaceAll("\\s", "");
        String[] contents = pairingInput.split(CONTENT_SPLIT_REGEX);

        Level level = levelMap.get(contents[CONTENT_LEVEL_INDEX]);
        level.matchMissionPair(Course.getCourseByName(contents[CONTENT_COURSE_INDEX]),contents[CONTENT_MISSION_INDEX]);
    }

    private boolean checkExistContents(String[] contents){

        try {
            Course.checkExistCourse(contents[CONTENT_COURSE_INDEX]);
            Level.checkExistLevel(contents[CONTENT_LEVEL_INDEX]);
            checkExistMission(contents[CONTENT_LEVEL_INDEX], contents[CONTENT_MISSION_INDEX]);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    private void checkExistMission(String levelName, String missionName) throws IllegalArgumentException{
        Level level = levelMap.get(levelName);
        level.isExistMission(missionName);
    }

    private void printAllSystemData(){
        System.out.println('\n'+DRAW_LINE);
        printAllCourse();
        printAllLevelData();
        System.out.println(DRAW_LINE);
    }

    private void printAllCourse(){
        Course[] courses = Course.values();
        StringBuilder allCourseNames = new StringBuilder(COURSE_TITLE);

        for(int i=0 ; i<courses.length ; ++i){
            allCourseNames.append(courses[i].getName());

            if(i != courses.length -1){
                allCourseNames.append(COURSE_DELIMITER);
            }
        }

        System.out.println(allCourseNames);
    }

    private void printAllLevelData(){
        Level[] levels = Level.values();
        System.out.println(Mission_TITLE);

        for(Level currentLevel : levels){
            System.out.println(currentLevel);
        }
    }

}
