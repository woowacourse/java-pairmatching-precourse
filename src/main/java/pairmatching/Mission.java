package pairmatching;

import static pairmatching.Constant.LAST_INDEX;
import static pairmatching.Constant.DIVIDE_EVEN_NUMBER_TWO;
import static pairmatching.Constant.DIVIDE_EVEN_NUMBER_ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mission {

    private Level level;
    private String name;
    private Map<Course, List<Partner>> crewMatching;
    Announcer announcer;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
        crewMatching = new LinkedHashMap<>();
        announcer = new Announcer();
    }

    public boolean checkLevel(Level requestedLevel) {
        return this.level.equals(requestedLevel);
    }

    public String getName() {
        return name;
    }

    public boolean checkMission(String mission) {
        return this.name.equals(mission);
    }

    public void makeMatching(List<Crew> crews, Course course) {
        List<String> crewNames = getCrewNamesByCourse(crews, course);
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<Partner> partners = new ArrayList<>();
        matchPairs(shuffledCrew, partners);
        if (crewMatching.containsKey(course)) {
            crewMatching.replace(course, partners);
            announcer.announcePairMatchingResult(partners);
            return;
        }
        crewMatching.put(course, partners);
        announcer.announcePairMatchingResult(partners);
    }

    public boolean notExistPairMatching(Course course) {
        return !this.crewMatching.containsKey(course);
    }

    public void printPairsByCourse(Course course) {
        if (crewMatching.containsKey(course)) {
            announcer.announcePairMatchingResult(crewMatching.get(course));
        }
    }

    private List<String> getCrewNamesByCourse(List<Crew> crews, Course course) {
        return crews.stream().filter(crew -> crew.checkCourse(course)).map(Crew::getName).collect(Collectors.toList());
    }

    private void matchPairs(List<String> shuffledCrew, List<Partner> partners) {
        Partner partner = new Partner();
        for (int i = 0; i < shuffledCrew.size(); i++) {
            String crewName = shuffledCrew.get(i);
            if (checkOddNumber(i)) {
                partner.addName(crewName);
                partners.add(partner);
                continue;
            }
            partner = new Partner();
            partner.addName(crewName);
        }
        makeOddPair(shuffledCrew, partners);
    }

    private boolean checkOddNumber(int i) {
        return i % DIVIDE_EVEN_NUMBER_TWO != DIVIDE_EVEN_NUMBER_ZERO;
    }

    private void makeOddPair(List<String> shuffledCrew, List<Partner> partners) {
        if (checkOddNumber(shuffledCrew.size())) {
            Partner lastPartner = partners.get(lastIndex(partners.size()));
            String lastCrewName = shuffledCrew.get(lastIndex(shuffledCrew.size()));
            lastPartner.addName(lastCrewName);
        }
    }

    private int lastIndex(int size) {
        return size + LAST_INDEX;
    }

    public void resetPairs() {
        this.crewMatching = new LinkedHashMap<>();
    }
}
