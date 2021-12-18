package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.validation.Text;

public class Init {
    private List<String> backendCrewName;
    private List<String> frontendCrewName;
    private List<Mission> missionList;

    public Init(){
        backendCrewName = new ArrayList<>();
        frontendCrewName = new ArrayList<>();
        missionList = new ArrayList<>();
    }

    private void readCrewName() throws IOException {
        BufferedReader backendReader = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
        BufferedReader frontendReader = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
        String name;

        while ((name = backendReader.readLine()) != null) {
            backendCrewName.add(name);
        }

        while ((name = frontendReader.readLine()) != null) {
            backendCrewName.add(name);
        }

    }

    private void initMissionInformation() {

        for (int i = 0; i < Text.MISSION_NAME.length; i++) {

            for (int j = 0; j < Text.MISSION_NAME[i].length; j++) {
                missionList.add(new Mission(Level.valueOf("LEVEL" + (i + 1)), Text.MISSION_NAME[i][j]));
            }

        }

    }

    public void start() throws IOException {
        readCrewName();
        initMissionInformation();
    }

    public List<Mission> getMissionInformation() {
        return missionList;
    }

    public List<String> getCrewNames(String course) {
        if(course.equals(Text.BACKEND)) {
            return backendCrewName;
        }

        if(course.equals(Text.FRONTEND)) {
            return frontendCrewName;
        }

        return null;
    }

}
