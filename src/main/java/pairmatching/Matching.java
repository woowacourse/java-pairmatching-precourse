package pairmatching;

import static pairmatching.Constant.YES;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matching {

    private List<Mission> missions;
    private Announcer announcer;

    public Matching() {
        missions = new ArrayList<>();
        missions.add(new Mission(Level.LEVEL1, "자동차경주"));
        missions.add(new Mission(Level.LEVEL1, "로또"));
        missions.add(new Mission(Level.LEVEL1, "숫자야구게임"));
        missions.add(new Mission(Level.LEVEL2, "장바구니"));
        missions.add(new Mission(Level.LEVEL2, "결제"));
        missions.add(new Mission(Level.LEVEL2, "지하철노선도"));
        missions.add(new Mission(Level.LEVEL4, "성능개선"));
        missions.add(new Mission(Level.LEVEL4, "배포"));
        announcer = new Announcer();
    }

    public void startMatching(List<Crew> crews) {
        announcer.announcePairMatchingSystem(missions);
        String[] selectedMatching = Console.readLine().split(",");
        matchPairs(crews, announcer, selectedMatching);
    }

    public void printPairs() {
        announcer.announcePairMatchingSystem(missions);
        String[] selectedMatching = Console.readLine().split(",");
        Mission mission = findMissions(selectedMatching, missions);
        Course course = findCourse(selectedMatching);
        mission.printPairsByCourse(course);
    }

    public void removePairs() {

    }

    private void matchPairs(List<Crew> crews, Announcer announcer, String[] selectedMatching) {
        try {
            Mission mission = findMissions(selectedMatching, missions);
            Course course = findCourse(selectedMatching);
            if (mission.notExistPairMatching(course)) {
                mission.makeMatching(crews, course);
                return;
            }
            announcer.requestRematching();
            rematch(crews, mission, course);
        } catch (IllegalArgumentException e) {
            announcer.errorMessage(e.getMessage());
        }
    }

    private void rematch(List<Crew> crews, Mission mission, Course course) {
        String reMatch = Console.readLine();
        if (reMatch.equals(YES)) {
            mission.makeMatching(crews, course);
        }
    }

    private Course findCourse(String[] selectedMatching) {
        String requiredName = selectedMatching[0].trim();
        return Arrays.stream(Course.values()).filter(c -> c.checkCourse(requiredName)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

    private Mission findMissions(String[] selectedMatching, List<Mission> missions) {
        String wantedMission = selectedMatching[2].trim();
        return missions.stream().filter(mission -> mission.checkMission(wantedMission)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
