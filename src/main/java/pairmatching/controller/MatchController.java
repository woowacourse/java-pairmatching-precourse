package pairmatching.controller;

import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Init;
import pairmatching.domain.Mission;
import pairmatching.domain.validation.Text;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchController {
    private final Init init;

    public MatchController(Init init) {
        this.init = init;
    }

    public void start(String information) {
        matching(information);
    }

    public boolean existsMatching(String information) {
        StringTokenizer tokens = new StringTokenizer(information, Text.SEPARATOR);
        String course = tokens.nextToken();
        tokens.nextToken();
        String missionName = tokens.nextToken();

        for (Mission mission : init.getMissionInformation()) {

            if (mission.getName().equals(missionName) && mission.getPair(course) != null) {
                return true;
            }

        }
        return false;
    }

    public void matching(String information) {
        StringTokenizer tokens = new StringTokenizer(information, Text.SEPARATOR);
        String course = tokens.nextToken();
        tokens.nextToken();
        String missionName = tokens.nextToken();

        for (Mission mission : init.getMissionInformation()) {

            if (mission.getName().equals(missionName) && mission.getPair(course) == null) {
                mission.addCrewName(course, nameShuffle(course));
                OutputView.printPair(mission.getPair(course));
                return;
            }

        }
    }

    public List<String> nameShuffle(String course) {
        List<String> crewNames = init.getCrewNames(course);
        return Randoms.shuffle(crewNames);
    }
}
