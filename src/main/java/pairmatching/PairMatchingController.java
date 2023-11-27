package pairmatching;

import java.util.List;

public class PairMatchingController {
    static CrewRepository crewRepository = new CrewRepository();

    public static void run() {
        crewRepository.initBackend("src/main/resources/backend-crew.md");
        crewRepository.initFrontend("src/main/resources/frontend-crew.md");

        List<String> backend = crewRepository.getBackend();
        List<String> frontend = crewRepository.getFrontend();

        System.out.println("frontend = " + frontend);
        System.out.println("backend = " + backend);
    }
}
