package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.Validation.*;

public class PairMatchingSystem {
    static int NO = 1;
    static int YES = 0;
    static int SUCCESS = 2;

    private String featureNum;
    private Crew crew;
    private int matchingCount = 0;

    public String getFeatureNum() {
        return featureNum;
    }

    public int getMatchingCount() {
        return matchingCount;
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
    }

    public void crewShuffle(String[] courseLevelMission){
        int status = YES;
        while(status == YES){
            try{
                List<Crew> crewList = loadCrew(courseLevelMission);
                shuffleLogic(Randoms.shuffle(crewList));
                UI.printPairMatchingResult(crewList);
                status = SUCCESS;
                break;
            }catch (Exception e){
                UI.printMatchedBefore();
                status = yesOrNo();
            }
        }
        if(status == NO){
            throw new IllegalArgumentException();
        }
    }

    public int yesOrNo(){
        if(Validation.insertYesOrNo(UI.insertYesOrNo())){
            return NO;
        }
        return YES;
    }

    public void shuffleLogic(List<Crew> shuffleCrewList){
        for(int i = 0; i < shuffleCrewList.size()-1; i+=2){
            if(Validation.validateMeetList(shuffleCrewList.get(i).getMeet(), shuffleCrewList.get(i+1).getName())){
                throw new IllegalArgumentException();
            }
            shuffleCrewList.get(i).addMeetList(shuffleCrewList.get(i+1).getName());
            shuffleCrewList.get(i+1).addMeetList(shuffleCrewList.get(i).getName());
        }
    }

    public void pairSelect(List<Crew> crewList){

    }

    public void pairReset(){

    }

    public void pairQuit(){

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
