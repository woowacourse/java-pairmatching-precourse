package pairmatching.matching;

import pairmatching.crew.Course;
import pairmatching.crew.Crew;
import pairmatching.crew.CrewService;
import pairmatching.crew.Level;
import pairmatching.matching.backend.BackEndMatchingService;
import pairmatching.matching.frontend.FrontEndMatchingService;

import java.util.List;

public class MatchingService {

    private final String BACKEND = "백엔드";
    private final String FRONTEND = "프론트엔드";

    private final CrewService crewService;
    private final BackEndMatchingService backEndMatchingService;
    private final FrontEndMatchingService frontEndMatchingService;

    private MatchingService() {
        crewService = CrewService.getInstance();
        backEndMatchingService = BackEndMatchingService.getInstance();
        frontEndMatchingService = FrontEndMatchingService.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final MatchingService instance = new MatchingService();
    }

    public static MatchingService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public List<Pair> createBackEndPair(Level level, String mission) {
        List<Crew> crews = crewService.findAllBackEndCrew();
        return backEndMatchingService.getPair(crews, level, mission); // Null 도 리턴됨
    }

    public List<Pair> createFrontEndPair(Level level, String mission) {
        List<Crew> crews = crewService.findAllFrontEndCrew();
        return frontEndMatchingService.getPair(crews, level, mission);
    }

    public List<Pair> getPair(Course course, Level level, String mission) {
        if(isExistMatchingTitle(course, level, mission)){
            if(course.equals(Course.BACKEND))
                return backEndMatchingService.findPair(level, mission);

            if(course.equals(Course.FRONTEND))
                return frontEndMatchingService.findPair(level, mission);
        }
        return null;
    }

    public boolean isExistMatchingTitle(Course course, Level level, String mission) {
        if(course.equals(Course.BACKEND))
            return backEndMatchingService.isExistMatching(level, mission);

        if(course.equals(Course.FRONTEND))
            return frontEndMatchingService.isExistMatching(level, mission);

        return false;
    }
}
