package pairmatching.crew;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewController {
    private List<Crew> backEndCrewList;
    private List<Crew> frontEndEndCrewList;
    private CrewsModel crewsModel;

    public CrewController() {
        backEndCrewList = new ArrayList<>();
        frontEndEndCrewList = new ArrayList<>();
        crewsModel = new CrewsModel();
    }

    public void storeCrew() throws IOException {
        backEndCrewList = crewsModel.readBackEndCrew();
        frontEndEndCrewList = crewsModel.readFrontEndCrew();
    }
}
