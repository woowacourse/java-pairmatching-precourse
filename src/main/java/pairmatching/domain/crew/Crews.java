package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.course.Course;
import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.matching.MatchingCondition;

public class Crews {
    private Map<Course, List<Crew>> crews = new HashMap<>();

    public void add(CourseEnum courseEnum, List<Crew> crewList) {
        this.crews.put(new Course(courseEnum.getName()), crewList);
    }

    public void match(MatchingCondition matchingCondition) {
        List<Crew> shuffledCrews = Randoms.shuffle(getCrewsByCourse(matchingCondition));
        for (Crew shuffledCrew : shuffledCrews) {
            System.out.println(shuffledCrew);
        }
    }

    private List<Crew> getCrewsByCourse(MatchingCondition matchingCondition) {
        return crews.get(matchingCondition.getCourse());
    }
}
