package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class MatchService {
    private CrewService crewService = new CrewService();
    private ArrayList<HashMap>[] matchedMission = new ArrayList[5];
    private HashMap<String, String> matchedPair = new HashMap<>();
    private List<String> backend = new ArrayList<>();
    private List<String> frontend = new ArrayList<>();
    private List<String> targetCrews;

    public void startMatch(String[] input) {
        try {
            init();
            int level = Integer.parseInt(input[1].substring(input[1].length() - 1)) - 1;
            setTargetCrews(input[0]);
            matchPairs();
            matchedMission[level].add(matchedPair);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTargetCrews(String s) {
        if(s.equals("백엔드")) {
            targetCrews = backend;
            return;
        }
        targetCrews = frontend;
    }

    private void init() throws IOException {
        for (ArrayList<HashMap> list : matchedMission) {
            list = new ArrayList<>();
        }
        backend = Randoms.shuffle(crewService.readBackendCrews());
        frontend = Randoms.shuffle(crewService.readFrontendCrews());
    }

    private void matchPairs() {
        for (int i = 0; i < targetCrews.size() - 1; i += 2) {
            String crew1 = targetCrews.get(i);
            String crew2 = targetCrews.get(i + 1);
            matchedPair.put(crew1, crew2);
        }
        if (targetCrews.size() % 2 != 0) {
            getRemainPair();
            return;
        }
        matchedPair.put(backend.get(backend.size() - 1), frontend.get(frontend.size() - 1));
    }
    private void getRemainPair() {
        String backCrew = "";
        String frontCrew = targetCrews.get(targetCrews.size() - 3);
        frontCrew = targetCrews.get(targetCrews.size() - 2) + " : "
                + targetCrews.get(targetCrews.size() - 1);

        matchedPair.put(frontCrew, backCrew);
    }
}
