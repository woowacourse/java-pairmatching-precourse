package pairmatching.matching;

import pairmatching.crew.Level;

import java.util.List;

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
}
