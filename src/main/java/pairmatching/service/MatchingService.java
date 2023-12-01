package pairmatching.service;

import static pairmatching.constants.ErrorMessage.MATCHING_ERROR;
import static pairmatching.constants.FilePath.BACK_FILE_PATH;
import static pairmatching.constants.FilePath.FRONT_FILE_PATH;
import static pairmatching.domain.constants.Position.BACKEND;
import static pairmatching.domain.constants.Position.FRONTEND;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.Pair;
import pairmatching.domain.constants.Position;
import pairmatching.repository.BackendRepository;
import pairmatching.repository.FrontendRepository;
import pairmatching.repository.MatchingHistoryRepository;
import pairmatching.utils.Reader;

public class MatchingService {
    private static final int ZERO = 0;
    private static final int MAX_MATCHING_COUNT = 3;
    private static final int MIN_PAIR_COUNT = 2;
    private static final int MAX_PAIR_COUNT = 3;
    private final FrontendRepository frontendRepository;
    private final BackendRepository backendRepository;
    private final MatchingHistoryRepository matchingHistoryRepository;


    public MatchingService() {
        this.frontendRepository = new FrontendRepository();
        this.backendRepository = new BackendRepository();
        this.matchingHistoryRepository = new MatchingHistoryRepository();
    }

    public void initPeople() {
        List<String> Frontend = Reader.readFile(FRONT_FILE_PATH.getPath());
        frontendRepository.save(Frontend);
        List<String> Backend = Reader.readFile(BACK_FILE_PATH.getPath());
        backendRepository.save(Backend);
    }

    public boolean findMatchingHistoryByCourse(Course course) {
        MatchingHistory matchingHistoryByCourse = matchingHistoryRepository.findMatchingHistoryByCourse(course);
        if (matchingHistoryByCourse == null) {
            return false;
        }
        return true;
    }

    public void pairMatching(Course course) {
        Position position = course.getPosition();
        if (position.equals(FRONTEND)) {
            frontendMatching(course);
        }
        if (position.equals(BACKEND)) {
            backendMatching(course);
        }
    }

    private void frontendMatching(Course course) {
        List<Pair> pairs = new ArrayList<>();
        int count = ZERO;
        do {
            if ((count++) == MAX_MATCHING_COUNT) {
                throw new IllegalArgumentException(MATCHING_ERROR.getMessage());
            }
            pairs.clear();
            List<String> frontend = frontendRepository.getFrontend();
            pairs = matching(frontend);
        } while (isMatched(course, pairs));
        matchingHistoryRepository.save(new MatchingHistory(course, pairs));
    }

    private void backendMatching(Course course) {
        List<Pair> pairs = new ArrayList<>();
        int count = ZERO;
        do {
            if ((count++) == MAX_MATCHING_COUNT) {
                throw new IllegalArgumentException(MATCHING_ERROR.getMessage());
            }
            pairs.clear();
            List<String> backend = backendRepository.getBackend();
            pairs = matching(backend);
        } while (isMatched(course, pairs));
        matchingHistoryRepository.save(new MatchingHistory(course, pairs));
    }

    private List<Pair> matching(List<String> pairByPosition) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < pairByPosition.size() - 1; i += 2) {
            Pair pair = new Pair(pairByPosition.get(i), pairByPosition.get(i + 1));
            pairs.add(pair);
        }
        if (pairByPosition.size() % 2 == 1) {
            int lastIndex = pairs.size() - 1;
            pairs.get(lastIndex).addCrew(pairByPosition.get(pairByPosition.size() - 1));
        }
        return pairs;
    }


    private boolean isMatched(Course course, List<Pair> pairs) {
        List<MatchingHistory> matchingHistoryByLevel = matchingHistoryRepository.findMatchingHistoryByLevel(
                course.getLevel());
        for (MatchingHistory matchingHistory : matchingHistoryByLevel) {
            List<Pair> pairHistory = matchingHistory.getPair();
            if (isSamePair(pairs, pairHistory)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSamePair(List<Pair> pairs, List<Pair> pairHistory) {
        return pairHistory.stream()
                .anyMatch(storedPair -> pairs.stream()
                        .anyMatch(pair -> isSameCrews(storedPair.getCrews(), pair.getCrews())));
    }

    private boolean isSameCrews(List<String> crewsHistory, List<String> crews) {
        long count = crewsHistory.stream()
                .filter(crews::contains)
                .count();

        return count == MIN_PAIR_COUNT || count == MAX_PAIR_COUNT;
    }


    public List<Pair> pairMatchingResult(Course course) {
        MatchingHistory matchingHistoryByCourse = matchingHistoryRepository.findMatchingHistoryByCourse(course);
        return matchingHistoryByCourse.getPair();
    }

    public void updatePairMatching(Course course) {
        matchingHistoryRepository.deleteMatchingHistory(course);
        pairMatching(course);
    }

    public void clearMatchingHistory() {
        matchingHistoryRepository.clearMatchingHistory();
    }
}
