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
    private List<Mission> missionInformation;

    public Init() throws IOException {
        backendCrewName = new ArrayList<>();
        frontendCrewName = new ArrayList<>();
        missionInformation = new ArrayList<>();
    }

    private void readCrewName() throws IOException {
        BufferedReader backendReader = new BufferedReader(new FileReader("resources\\backend-crew.md"));
        BufferedReader frontendReader = new BufferedReader(new FileReader("resources\\frontend-crew.md"));
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
                missionInformation.add(new Mission(Level.valueOf("레벨" + (i + 1)), Text.MISSION_NAME[i][j]));
            }

        }

    }

    public List<Mission> getMissionInformation() {
        return missionInformation;
    }

    public List<String> getBackendCrewName() {
        return backendCrewName;
    }

    public List<String> getFrontendCrewName() {
        return frontendCrewName;
    }
}
