package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.course.Course;
import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.matching.MatchingCondition;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;

public class Crews {
    private Map<Course, List<Crew>> crews = new HashMap<>();

    public void add(CourseEnum courseEnum, List<Crew> crewList) {
        this.crews.put(new Course(courseEnum.getName()), crewList);
    }

    public Pairs match(MatchingCondition matchingCondition) {
        Pairs pairs = new Pairs();
        ArrayList<Crew> shuffledCrews = (ArrayList<Crew>)getShuffledCrews(matchingCondition);
        while (!shuffledCrews.isEmpty()) {
            if (shuffledCrews.size() <= 3) {
                Pair pair = new Pair(shuffledCrews);
                pairs.add(pair);
                break;
            }
            pairs.add(getTwoCrews(shuffledCrews));
        }
        return pairs;
    }

    private Pair getTwoCrews(ArrayList<Crew> shuffledCrews) {
        Pair pair = new Pair();
        for (int i = 0; i < 2; i++) {
            pair.addCrew(shuffledCrews.get(shuffledCrews.size() - 1));
            shuffledCrews.remove(shuffledCrews.size() - 1);
        }
        return pair;
    }

    private boolean isOdd(ArrayList<Crew> shuffledCrews) {
        return shuffledCrews.size() % 2 != 0;
    }

    private List<Crew> getShuffledCrews(MatchingCondition matchingCondition) {
        return Randoms.shuffle(getCrewsByCourse(matchingCondition));
    }

    private List<Crew> getCrewsByCourse(MatchingCondition matchingCondition) {
        return crews.get(matchingCondition.getCourse());
    }
}
