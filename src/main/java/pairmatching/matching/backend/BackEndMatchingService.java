package pairmatching.matching.backend;

import pairmatching.crew.Course;
import pairmatching.crew.Crew;
import pairmatching.crew.Level;
import pairmatching.matching.CourseMatchingService;
import pairmatching.matching.MatchingService;
import pairmatching.matching.Pair;
import pairmatching.matching.mathcingtitle.MatchingTitle;

import java.util.ArrayList;
import java.util.List;

public class BackEndMatchingService implements CourseMatchingService {

    private final BackEndMatchingTitleRepository backEndMatchingTitleRepository;
    private final BackEndPairRepository backEndPairRepository;

    private BackEndMatchingService() {
        backEndMatchingTitleRepository = BackEndMatchingTitleRepository.getInstance();
        backEndPairRepository = BackEndPairRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final BackEndMatchingService instance = new BackEndMatchingService();
    }

    public static BackEndMatchingService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public List<Pair> getPair(List<Crew> crews, Level level, String mission) {
        for(int i = 0; i < 3; ++i) {
            List<Pair> pairs = createPair(crews, level, mission);
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
        MatchingTitle matchingTitle = MatchingTitle.fromCourseAndLevelAndMission(Course.BACKEND, level, mission);
        backEndMatchingTitleRepository.add(matchingTitle);
    }

    @Override
    public void savePair(List<Pair> pairs) {
        for(Pair pair : pairs) {
            backEndPairRepository.add(pair);
        }
    }

    private boolean isNotDuplicateSameLevel(List<Pair> pairs, Level level) {
        List<Pair> sameLevelPairs = backEndPairRepository.findAllByLevel(level);
        for(Pair comparePair : pairs) {
            if(isExistSameLevelPair(sameLevelPairs, comparePair)){
                return false;
            }
        }
        return true;
    }

    public boolean isExistMatching(Level level, String mission) {
        List<MatchingTitle> titles = backEndMatchingTitleRepository.findAll();
        for(MatchingTitle title : titles) {
            if(title.isSame(level, mission))
                return true;
        }
        return false;
    }

    public List<Pair> findPair(Level level, String mission) {
        return backEndPairRepository.findAllByLevelAndMission(level, mission);
    }
}
