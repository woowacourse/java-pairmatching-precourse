package pairmatching.matching;

import pairmatching.crew.Course;
import pairmatching.crew.Level;

import java.util.List;
import java.util.concurrent.Callable;

public class MatchingController {

    private final String BACKEND = "백엔드";
    private final String FRONTEND = "프론트엔드";

    private final MatchingService matchingService;

    private MatchingController() {
        matchingService = MatchingService.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final MatchingController instance = new MatchingController();
    }

    public static MatchingController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public List<Pair> getPairMatching(List<String> menuData) {
        String course = menuData.get(0);
        Level level = Level.getLevelName(menuData.get(1));

        if(BACKEND.equals(course)) {
            return matchingService.createBackEndPair(level, menuData.get(2));
        }

        if(FRONTEND.equals(course)) {
            return matchingService.createFrontEndPair(level, menuData.get(2));
        }
        return null;
    }

    public void printPairMatching(List<String> menuData) {
        Course course = Course.getCourseName(menuData.get(0));
        Level level = Level.getLevelName(menuData.get(1));

        List<Pair> pairs = matchingService.getPair(course, level, menuData.get(2));
        for(Pair pair : pairs) {
            List<String> names = pair.getAllCrewName();
            for(int i = 0; i < names.size(); ++i) {
                System.out.print(names.get(i));
                if(i != names.size() - 1)
                    System.out.print(":");
            }
        }
    }
}
