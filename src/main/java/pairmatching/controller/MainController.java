package pairmatching.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Menu;
import pairmatching.domain.PairMatching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

public class MainController {


    public void run() throws IOException {
        PairMatching.initCrews();
        while (true) {
            String mainMenu = Menu.processOfSelectMenu();
            if (mainMenu.equals(Menu.MENU_PAIR_MATCHING)) {
                processOfPairMatching();
            } else if (mainMenu.equals(Menu.MENU_PAIR_LOOK_UP)) {

            } else if (mainMenu.equals(Menu.MENU_PAIR_INIT)) {

            } else if (mainMenu.equals(Menu.MENU_EXIT)) {
                break;
            }
        }

    }

    private void processOfPairMatching() {
        String courseLevelMission = Menu.processOfPairMatchingSelectMenu();

        while (true) {
            if (PairMatching.existPairMatching(courseLevelMission)) {
                String yesOrNo = Menu.processOfPairMatchingDuplicationMenu();
                if (yesOrNo.equals("네")) {
                    break;
                } else if (yesOrNo.equals("아니오")) {
                    courseLevelMission = Menu.processOfPairMatchingReSelectMenu();
                }
            } else if (!PairMatching.existPairMatching(courseLevelMission)) {
                break;
            }
        }
        String course = courseLevelMission.split(",")[0].trim();
        String level = courseLevelMission.split(",")[1].trim();
        String mission = courseLevelMission.split(",")[2].trim();
        List<Crew> crews = getCrews(course);
        List<String> crewNames = getCrewsName(crews);
        List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록
        List<String> pairCrews = makePairCrews(shuffledCrew, course, level);
        if (pairCrews != null) {
            PairMatching.addPairMatching(courseLevelMission, pairCrews);
        }
        OutputView.printMatchingResult(pairCrews);
    }

    private List<Crew> getCrews(String course) {
        List<Crew> crews = new ArrayList<>();
        if (course.equals("프론트엔드")) {
            crews = PairMatching.frontendCrews();
        } else if (course.equals("백엔드")) {
            crews = PairMatching.backendCrews();
        }
        return crews;
    }

    private List<String> getCrewsName(List<Crew> crews) {
        List<String> crewNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewNames.add(crew.getName());
        }
        return crewNames;
    }

    private List<String> makePairCrews(List<String> crewNames, String course, String level) {
        List<String> pariCrews = new ArrayList<>();
        if (crewNames.size() % 2 == 0) {
            for (int i = 0; i < crewNames.size() - 1; i+=2) {
                pariCrews = makeEvenPairCrews(crewNames, course, level);
            }
        } else if (crewNames.size() % 2 == 1) {
            pariCrews = makeOddPairCrews(crewNames, course, level);
        }
        return pariCrews;
    }

    private List<String> makeEvenPairCrews(List<String> crewNames, String course, String level) {
        List<String> pariCrews = new ArrayList<>();
        List<Crew> crews = getCrews(course);
        for (int i = 0; i < crewNames.size() - 1; i+=2) {
            Crew crew1 = getCrewByName(crews, crewNames.get(i));
            Crew crew2 = getCrewByName(crews, crewNames.get(i+1));
            if (!checkEnablePairCrew(crew1, crew2, level)) {
                return null;
            }
            pariCrews.add(crew1.getName() + " : " + crew2.getName());
        }
        return pariCrews;
    }

    private List<String> makeOddPairCrews(List<String> crewNames, String course, String level) {
        List<String> pariCrews = new ArrayList<>();
        List<Crew> crews = getCrews(course);
        for (int i = 0; i < crewNames.size() - 2; i+=2) {
            Crew crew1 = getCrewByName(crews, crewNames.get(i));
            Crew crew2 = getCrewByName(crews, crewNames.get(i+1));
            if (!checkEnablePairCrew(crew1, crew2, level)) {
                return null;
            }
            pariCrews.add(crew1.getName() + " : " + crew2.getName());
        }
        Crew crew1 = getCrewByName(crews, crewNames.get(crewNames.size()-3));
        Crew crew2 = getCrewByName(crews, crewNames.get(crewNames.size()-2));
        Crew crew3 = getCrewByName(crews, crewNames.get(crewNames.size()-1));
        if (!checkEnablePairCrew(crew1, crew2, level)) {
            return null;
        } else if (!checkEnablePairCrew(crew1, crew3, level)) {
            return null;
        } else if (!checkEnablePairCrew(crew2, crew3, level)) {
            return null;
        }
        pariCrews.add(crew1.getName() + " : " + crew2.getName() + " : " + crew3.getName());
        return pariCrews;
    }

    private Crew getCrewByName(List<Crew> crews, String name) {
        for (Crew crew: crews) {
            if (crew.getName().equals(name)) {
                return crew;
            }
        }
        return null;
    }

    private boolean checkEnablePairCrew(Crew crew1, Crew crew2, String level) {
        if (crew1.hasMatcingCrew(crew2.getName(), level)) {
            return false;
        }
        return true;
    }
}