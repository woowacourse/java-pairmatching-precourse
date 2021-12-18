package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    List<String> crewBackendNames = new ArrayList<>();
    List<String> crewFrontendNames = new ArrayList<>();

    public void inputBackendCrew(String crewName) {
        crewBackendNames.add(crewName);
    }

    public void inputFrontendCrew(String crewName) {
        crewFrontendNames.add(crewName);
    }

    public List<String> getCrewBackendNames() {
        return crewBackendNames;
    }

    public List<String> getCrewFrontendNames() {
        return crewFrontendNames;
    }
}
