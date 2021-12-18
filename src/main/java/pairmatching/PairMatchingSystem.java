package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static pairmatching.Validation.*;

public class PairMatchingSystem {
    static int NO = 1;
    static int YES = 0;
    static int SUCCESS = 2;

    private String featureNum;
    private List<Crew> crewList;
    private HashMap<String, List<Crew>> crewListMap;
    private int matchingCount = 0;

    public String getFeatureNum() {
        return featureNum;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public HashMap<String, List<Crew>> getCrewListMap() {
        return crewListMap;
    }

    public void setCrewListMap(String course, List<Crew> crewList) {
        this.crewListMap.put(course, crewList);
    }

    public void choiceFeature(){
        while(true) {
            try {
                UI.printChoiceFeature();
                featureNum = UI.insertChoiceFeature();
                Validation.validateChoiceFeature(featureNum);
                break;
            } catch (IllegalArgumentException e){
                UI.printException(e.getMessage());
            }
        }
    }

    public void pairMatching(){
        while(true) {
            try {
                UI.printPairMatchingChoice();
                String[] courseLevelMission = UI.insertPairMatchingChoice().split(",");
                courseLevelMission = Validation.trimString(courseLevelMission);
                Validation.validateCourseAndLevel(courseLevelMission);
                Validation.validateMission(courseLevelMission);
                crewShuffle(courseLevelMission);
                break;
            } catch (Exception e){
                UI.printException(e.getMessage());
            }
        }
        UI.printPairMatchingResult(crewList);
    }

    public void crewShuffle(String[] courseLevelMission){
        int status = NO;
        while(status == NO){
            try{
                crewList = loadCrew(courseLevelMission);
                crewList = Randoms.shuffle(crewList);
                shuffleLogic(crewList);
                status = SUCCESS;
                setCrewListMap(courseLevelMission[COURSE_NAME], crewList);
                break;
            }catch (Exception e){
                //UI.printMatchedBefore();
            }
        }
        if(status == YES){
            throw new IllegalArgumentException();
        }
    }
/*
    public int yesOrNo(){
        if(Validation.insertYesOrNo(UI.insertYesOrNo())){
            return YES;
        }
        return NO;
    }
*/
    public void shuffleLogic(List<Crew> shuffleCrewList){
        for(int i = 0; i < shuffleCrewList.size()-1; i+=2){
            if(Validation.validateMeetList(shuffleCrewList.get(i).getMeet(), shuffleCrewList.get(i+1).getName())){
                throw new IllegalArgumentException();
            }
            shuffleCrewList.get(i).addMeetList(shuffleCrewList.get(i+1).getName());
            shuffleCrewList.get(i+1).addMeetList(shuffleCrewList.get(i).getName());
        }
    }

    public void pairSelect(){
        while(true){
            try{
                UI.printPairMatchingChoice();
                String[] courseLevelMission = UI.insertPairMatchingChoice().split(",");
                courseLevelMission = Validation.trimString(courseLevelMission);
                Validation.validateCourseAndLevel(courseLevelMission);
                Validation.validateMission(courseLevelMission);
                UI.printPairMatchingResult(this.crewListMap.get(courseLevelMission[COURSE_NAME]));
            }catch (Exception e){
                UI.printException("[ERROR] 해당 과정의 크루가 없습니다.");
            }
        }
    }

    public void pairReset(){
        this.crewListMap = new HashMap<>();
    }

    public ArrayList<Crew> loadCrew(String[] courseLevelMission){
        ArrayList<Crew> crewList = null;
        for(Level lv: Level.values()){
            if(lv.getName().equals(courseLevelMission[LEVEL_NAME]) && courseLevelMission[COURSE_NAME].equals("프론트엔드")){
                crewList = loadFrontEndCrew(courseLevelMission, lv);
            }
            if(lv.getName().equals(courseLevelMission[LEVEL_NAME]) && courseLevelMission[COURSE_NAME].equals("백엔드")){
                crewList = loadBackEndCrew(courseLevelMission, lv);
            }
        }
        return crewList;
    }

    public ArrayList<Crew> loadFrontEndCrew(String[] courseLevelMission, Level level){
        ArrayList<Crew> crewList = new ArrayList<>();
        try {
            BufferedReader reader = null;
            String nextName;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/frontend-crew.md"), "UTF-8" ));
            while((nextName = reader.readLine()) != null){
                level.setMission(courseLevelMission[MISSION_NAME]);
                crewList.add(new Crew(Course.FRONTEND, level,  nextName));
            }
        } catch (Exception e){
            UI.printException("[ERROR]" + e.getMessage());
        }
        return crewList;
    }

    public ArrayList<Crew> loadBackEndCrew(String[] courseLevelMission, Level level){
        ArrayList<Crew> crewList = new ArrayList<>();
        try {
            BufferedReader reader = null;
            String nextName;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/backend-crew.md"), "UTF-8" ));
            while((nextName = reader.readLine()) != null){
                level.setMission(courseLevelMission[MISSION_NAME]);
                crewList.add(new Crew(Course.BACKEND, level,  nextName));
            }
        } catch (Exception e){
            UI.printException("[ERROR]" + e.getMessage());
        }
        return crewList;
    }
}
