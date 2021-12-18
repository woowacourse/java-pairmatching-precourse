package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MatchService {
    private CrewService crewService = new CrewService();
    private HashSet<String> pairSet = new HashSet();
    private ArrayList<String> backend = new ArrayList<>();
    private ArrayList<String> frontend = new ArrayList<>();

    public void startMatch(String input) {
        try {
            backend = crewService.readBackendCrews();
            frontend = crewService.readFrontendCrews();

            crewService.isUniqueCrews(backend, frontend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
