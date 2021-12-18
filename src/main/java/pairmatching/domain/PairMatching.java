package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.infomation.BackendCrewRepository;
import pairmatching.infomation.Crew;
import pairmatching.infomation.FrontendCrewRepository;
import pairmatching.view.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

public class PairMatching {
    static ArrayList<String> pair = new ArrayList<>();
    private static final String BACKEND = "백엔드";
    private static final int COURSE_IDX = 0;
    private static final int LEVEL_IDX = 1;
    private static final int MISSION_IDX = 2;

    public static void matching(String[] information) throws IOException {
        OutputView outputView = new OutputView();
        outputView.outputInformation();

        if (information[COURSE_IDX].equals(BACKEND)) {
            BackendCrewRepository.initBackCrew();
            ArrayList<Crew> crews = BackendCrewRepository.getBackendCrews();
            matching(crews, information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
            outputView.outputMatching(information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
            return;
        }
        ArrayList<Crew> crews = FrontendCrewRepository.getFrontendCrews();
        matching(crews, information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
        outputView.outputMatching(information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
    }

    private static void matching(ArrayList<Crew> crews, String course, String level, String mission) {
        List<String> crewsNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewsNames.add(crew.getName());
        }
        if (crews.size() % 2 == 0) {
            evenMatching(crewsNames, crews, course, level, mission);
        }
        if (crews.size() % 2 == 1) {
            oddMatching(crewsNames, crews, course, level, mission);
        }
    }

    private static void evenMatching(List<String> crewsNames,
                                     ArrayList<Crew> crews, String course, String level, String mission) {
        int shuffleCount = 0;
        while (true) {
            if (shuffleCount > 3) {
                System.out.println("[ERROR] 매칭 시도가 3회 이상을 넘어갔습니다.");
                break;
            }
            List<String> shuffleCrews = Randoms.shuffle(crewsNames);
            if (isPass(course, level, mission, shuffleCrews)) {
                break;
            }
            shuffleCount ++;
        }
    }

    private static void oddMatching(List<String> crewsNames,
                                    ArrayList<Crew> crews, String course, String level, String mission) {
    }

    private static boolean isPass(String course, String level, String mission, List<String> shuffleCrews) {
        ArrayList<Pair> pairRepositoryTemp= new ArrayList<>();

        for (int idx = 0; idx < shuffleCrews.size(); idx++) {
            if (!isPassPair(shuffleCrews, idx, mission, level)) {
                return false;
            }
            if (idx % 2 == 1) {
                pairRepositoryTemp.add(new Pair(course, level, mission, pair));
            }
        }
        storePair(pairRepositoryTemp);
        return true;
    }

    private static void storePair(ArrayList<Pair> pairRepositoryTemp) {
        for (Pair pair : pairRepositoryTemp) {
            PairRepository.addPair(new Pair(pair.getCourse(), pair.getLevel(), pair.getMission(), pair.getCrews()));
        }
    }

    private static boolean isPassPair(List<String> shuffleCrews, int idx, String mission, String level) {
        if (idx % 2 == 0) {
            pair = new ArrayList<>();
        }
        pair.add(shuffleCrews.get(idx));
        if (idx % 2 == 1) {
            if (!isPair(pair, level)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPair(ArrayList<String> pairNames, String level) {
        ArrayList<Pair> pairInformation = PairRepository.getPairInformation();
        for (Pair pair : pairInformation) {
            if (!isNotSamePairBefore(level, pairNames, pair)) {
                return false;
            }
        }
        return true;
    }

    private static int calcSame(ArrayList<String> pairNames, Pair pair) {
        int sameNameCount = 0;
        ArrayList<String> crewsNames = pair.getCrews();
        for (String name : pairNames) {
            if (crewsNames.contains(name)) {
                sameNameCount ++;
            }
        }
        return sameNameCount;
    }

    private static boolean isNotSamePairBefore(String level, ArrayList<String> pairNames, Pair pair) {
        if (pair.getLevel() != level) {
            return true;
        }
        int sameNameCount = calcSame(pairNames, pair);
        if (sameNameCount > 1) {
           return false;
       }
       return true;
    }
}
