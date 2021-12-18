package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.Validation.*;

public class PairMatchingSystem {
    private String featureNum;
    private Crew crew;

    public String getFeatureNum() {
        return featureNum;
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
                Validation.validatePairMatchingLength(courseLevelMission);
                Validation.validateCourse(courseLevelMission);
                Validation.validateLevel(courseLevelMission);
                Validation.validateMission(courseLevelMission);
                break;
            } catch (Exception e){
                UI.printException(e.getMessage());
            }
        }
        loadCrew();
        //crewShuffle();
        //pairSelect();
    }

    public void crewShuffle(){
        Randoms.shuffle();
    }

    public void pairSelect(){

    }

    public void pairReset(){

    }

    public void pairQuit(){

    }

    public void loadCrew(String[] courseLevelMission){
        for(Level lv: Level.values()){
            if(lv.getName().equals(courseLevelMission[LEVEL_NAME]) && courseLevelMission[COURSE_NAME].equals("프론트엔드")){
                loadFrontEndCrew(courseLevelMission, lv);
            }
            if(lv.getName().equals(courseLevelMission[LEVEL_NAME]) && courseLevelMission[COURSE_NAME].equals("백엔드")){
                loadBackEndCrew(courseLevelMission, lv);
            }
        }
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
