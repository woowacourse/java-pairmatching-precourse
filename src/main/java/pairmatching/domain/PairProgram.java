package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.exception.OverMatchingException;

public class PairProgram {

    private final Crews crews;
    private final LevelMission levelMission;

    public PairProgram(Crews crews, LevelMission levelMission) {
        this.crews = crews;
        this.levelMission = levelMission;
    }

    public void addMissions(Level level, List<String> missionNames) {
        levelMission.addMission(level, missionNames);
    }

    public boolean isMatched(Level level, Mission mission) {
        levelMission.checkExistMission(level, mission);
        return levelMission.isMatched(level, mission);
    }

    public List<Match> matching(Level level, Mission mission) {
        levelMission.checkExistMission(level, mission);
        Mission originMission = levelMission.getMission(level, mission);
        for (int i = 1; i <= 3; i++) {
            List<Match> matches = createMatch(crews.crews(mission.course()), mission.course());
            if (!levelMission.isAlreadyMatchCrew(level, matches)) {
                levelMission.updateMatch(level, mission, matches);
                return matches;
            }
        }
        throw new OverMatchingException();
    }

    public List<Match> createMatch(List<Crew> crews, Course course) {
        List<String> crewNames = crews.stream()
            .map(Crew::name)
            .collect(Collectors.toList());
        crewNames = Randoms.shuffle(crewNames);
        return createMatch(course, crewNames);
    }

    private List<Match> createMatch(Course course, List<String> crewNames) {
        if (crewNames.size() % 2 == 0) {
            return createEvenMatch(course, crewNames);
        }
        return createOddMatch(course, crewNames);
    }

    private List<Match> createEvenMatch(Course course, List<String> crewNames) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < crewNames.size(); i += 2) {
            String firstName = crewNames.get(i);
            String secondName = crewNames.get(i + 1);
            matches.add(new Match(this.crews.findCrew(firstName, course), this.crews.findCrew(secondName, course)));
        }
        return matches;
    }

    private List<Match> createOddMatch(Course course, List<String> crewNames) {
        List<Match> matches = new ArrayList<>();
        int i = 0;
        for (; i < crewNames.size() - 3; i += 2) {
            String firstName = crewNames.get(i);
            String secondName = crewNames.get(i + 1);
            matches.add(new Match(this.crews.findCrew(firstName, course), this.crews.findCrew(secondName, course)));
        }
        String firstName = crewNames.get(i);
        String secondName = crewNames.get(i + 1);
        String thirdName = crewNames.get(i + 2);
        matches.add(new OddMatch(this.crews.findCrew(firstName, course), this.crews.findCrew(secondName, course),
            this.crews.findCrew(thirdName, course)));
        return matches;
    }
}
