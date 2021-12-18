package pairmatching.source;

import java.util.HashMap;
import java.util.List;

public class CrewDataBase {
    private HashMap<String, Crew> backEndCrewMap = new HashMap<>();
    private HashMap<String, Crew> frontEndCrewMap = new HashMap<>();

    public CrewDataBase(){
        BackEndInit();
        FrontEndInit();
    }

    private void BackEndInit(){
        List<String> crewNames = ReadCrewFile.getBackEndCrewNames();

        for(String name : crewNames){
            backEndCrewMap.put(name ,new Crew( Course.BACKEND, name));
        }
    }

    private void FrontEndInit(){
        List<String> crewNames = ReadCrewFile.getFrontEndCrewNames();

        for(String name : crewNames){
            frontEndCrewMap.put(name ,new Crew( Course.FRONTEND, name));
        }
    }

    public HashMap<String, Crew> getCrewMapByCourse(Course course){

        if(course == Course.BACKEND){
            return backEndCrewMap;
        }

        return frontEndCrewMap;
    }
}
