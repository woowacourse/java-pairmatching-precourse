package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.init.BackendCrewRepository;
import pairmatching.init.Crew;
import pairmatching.init.FrontendCrewRepository;
import pairmatching.view.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

public class PairMatching {
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";
    private static final String LIMIT_ERROR_SHUFFLE_MESSAGE = "[ERROR] 매칭 시도가 3회 이상을 넘어갔습니다.";
    private static final int COURSE_IDX = 0;
    private static final int LEVEL_IDX = 1;
    private static final int MISSION_IDX = 2;
    private static final int MAX_SHUFFLE = 3;

    static ArrayList<String> evenPair = new ArrayList<>();
    static ArrayList<String> oddPair = new ArrayList<>();

    public static void matching(String[] information) throws IOException {
        OutputView outputView = new OutputView();
        outputView.outputInformation();

        if (information[COURSE_IDX].equals(BACKEND)) {
            matchingBackend(outputView, information);
            return;
        }
        if (information[COURSE_IDX].equals(FRONTEND)) {
            matchingFrontend(outputView, information);
            return;
        }
    }

    private static void matchingFrontend(OutputView outputView, String[] information) throws IOException {
        FrontendCrewRepository.initFrontCrew();
        ArrayList<Crew> crews = FrontendCrewRepository.getFrontendCrews();
        matching(crews, information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
        outputView.outputMatching(information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
    }

    private static void matchingBackend(OutputView outputView, String[] information) throws IOException {
        BackendCrewRepository.initBackCrew();
        ArrayList<Crew> crews = BackendCrewRepository.getBackendCrews();
        matching(crews, information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
        outputView.outputMatching(information[COURSE_IDX], information[LEVEL_IDX], information[MISSION_IDX]);
    }

    private static void matching(ArrayList<Crew> crews, String course, String level, String mission) {
        List<String> crewsNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewsNames.add(crew.getName());
        }
        if (crews.size() % 2 == 0) {
            evenMatching(crewsNames, course, level, mission);
        }

        if (crews.size() % 2 == 1) {
            oddMatching(crewsNames, course, level, mission);
        }
    }

    private static void evenMatching(List<String> crewsNames, String course, String level, String mission) {
        int shuffleCount = 0;
        while (true) {
            if (shuffleCount > MAX_SHUFFLE) {
                System.out.println(LIMIT_ERROR_SHUFFLE_MESSAGE);
                break;
            }
            List<String> shuffleCrews = Randoms.shuffle(crewsNames);
            if (isEvenPass(course, level, mission, shuffleCrews)) {
                break;
            }
            shuffleCount ++;
        }
    }

    private static void oddMatching(List<String> crewsNames, String course, String level, String mission) {
        int shuffleCount = 0;
        while (true) {
            if (shuffleCount > 3) {
                System.out.println(LIMIT_ERROR_SHUFFLE_MESSAGE);
                break;
            }
            List<String> shuffleCrews = Randoms.shuffle(crewsNames);
            if (isOddPass(course, level, mission, shuffleCrews)) {
                break;
            }
            shuffleCount ++;
        }
    }

    private static boolean isOddPass(String course, String level, String mission, List<String> shuffleCrews) {
        ArrayList<Pair> pairOddRepositoryTemp = new ArrayList<>();

        for (int idx = 0; idx < shuffleCrews.size()-1; idx++) {
            if (!isPassOddPair(shuffleCrews, idx, level)) {
                return false;
            }
            if (idx % 2 == 1) {
                pairOddRepositoryTemp.add(new Pair(course, level, mission, oddPair));
            }
        }
        storePair(pairOddRepositoryTemp);
        return true;
    }

    private static boolean isPassOddPair(List<String> shuffleCrews, int idx, String level) {
        if (idx == shuffleCrews.size()-2) {
            oddPair.add(shuffleCrews.get(idx));
            oddPair.add(shuffleCrews.get(shuffleCrews.size()-1));
            if (!isPair(oddPair, level)) {
                return false;
            }
            return true;
        }
        if (idx % 2 == 0) {
            oddPair = new ArrayList<>();
        }
        oddPair.add(shuffleCrews.get(idx));
        if (idx % 2 == 1) {
            if (!isPair(oddPair, level)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEvenPass(String course, String level, String mission, List<String> shuffleCrews) {
        ArrayList<Pair> pairRepositoryTemp= new ArrayList<>();

        for (int idx = 0; idx < shuffleCrews.size(); idx++) {
            if (!isPassEvenPair(shuffleCrews, idx, mission, level)) {
                return false;
            }
            if (idx % 2 == 1) {
                pairRepositoryTemp.add(new Pair(course, level, mission, evenPair));
            }
        }
        storePair(pairRepositoryTemp);
        return true;
    }

    private static boolean isPassEvenPair(List<String> shuffleCrews, int idx, String mission, String level) {
        if (idx % 2 == 0) {
            evenPair = new ArrayList<>();
        }
        evenPair.add(shuffleCrews.get(idx));
        if (idx % 2 == 1) {
            if (!isPair(evenPair, level)) {
                return false;
            }
        }
        return true;
    }

    private static void storePair(ArrayList<Pair> pairRepositoryTemp) {
        for (Pair pair : pairRepositoryTemp) {
            PairRepository.addPair(new Pair(pair.getCourse(), pair.getLevel(), pair.getMission(), pair.getCrews()));
        }
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
