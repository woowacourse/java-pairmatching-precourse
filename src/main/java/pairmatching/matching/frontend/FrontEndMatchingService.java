package pairmatching.matching.frontend;

import pairmatching.crew.Course;
import pairmatching.crew.Crew;
import pairmatching.crew.Level;
import pairmatching.matching.CourseMatchingService;
import pairmatching.matching.Pair;
import pairmatching.matching.mathcingtitle.MatchingTitle;
import java.util.List;

public class FrontEndMatchingService implements CourseMatchingService {

    private final FrontEndMatchingTitleRepository frontEndMatchingTitleRepository;
    private final FrontEndPairRepository frontEndPairRepository;

    private FrontEndMatchingService() {
        frontEndMatchingTitleRepository = FrontEndMatchingTitleRepository.getInstance();
        frontEndPairRepository = FrontEndPairRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final FrontEndMatchingService instance = new FrontEndMatchingService();
    }

    public static FrontEndMatchingService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public List<Pair> getPair(List<Crew> crews, Level level, String mission) {
        for(int i = 0; i < 3; ++i) {
            List<Pair> pairs = createPair(crews, level);
            if(isNotDuplicateSameLevel(pairs, level)){
                savePair(pairs);
                saveMatchingTitle(level, mission);
                return pairs;
            }
        }
        return null;
    }

    @Override
    public void saveMatchingTitle(Level level, String mission) {
        MatchingTitle matchingTitle = MatchingTitle.fromCourseAndLevelAndMission(Course.FRONTEND, level, mission);
        frontEndMatchingTitleRepository.add(matchingTitle);
    }

    @Override
    public void savePair(List<Pair> pairs) {
        for(Pair pair : pairs) {
            frontEndPairRepository.add(pair);
        }
    }

    private boolean isNotDuplicateSameLevel(List<Pair> pairs, Level level) {
        List<Pair> sameLevelPairs = frontEndPairRepository.findAllByLevel(level);
        for(Pair comparePair : pairs) {
            if(isExistSameLevelPair(sameLevelPairs, comparePair)){
                return false;
            }
        }
        return true;
    }
}
