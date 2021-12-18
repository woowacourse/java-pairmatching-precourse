package pairmatching.crew;

import pairmatching.crew.backend.BackEndCrewService;
import pairmatching.crew.frontend.FrontEndCrewService;

public class CrewService {

    private final String BACKEND_CREW_NAME_FILE_PATH = "/Users/nayoung/IdeaProjects/java-pairmatching-precourse/src/main/resources/backend-crew.md";
    private final String FRONTEND_CREW_NAME_FILE_PATH = "/Users/nayoung/IdeaProjects/java-pairmatching-precourse/src/main/resources/frontend-crew.md";

    private BackEndCrewService backEndCrewService;
    private FrontEndCrewService frontEndCrewService;

    private CrewService() {
        backEndCrewService = BackEndCrewService.getInstance();
        frontEndCrewService = FrontEndCrewService.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CrewService instance = new CrewService();
    }

    public static CrewService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void initializeCrew() {
        initializeBackEndCrew();
        initializeFrontEndCrew();
    }

    private void initializeBackEndCrew() {
        backEndCrewService.initialCrew(BACKEND_CREW_NAME_FILE_PATH);
    }

    private void initializeFrontEndCrew() {
        frontEndCrewService.initialCrew(FRONTEND_CREW_NAME_FILE_PATH);
    }
}
