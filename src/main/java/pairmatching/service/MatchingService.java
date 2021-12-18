package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.System.SystemErrorMessage;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.dto.PropertyDto;

import camp.nextstep.edu.missionutils.Randoms;

public class MatchingService {

    private static final int LIMIT_SHUFFLE_COUNT = 3;
    private static final int DEFAULT_START_INDEX = 0;

    private MatchingService() {
    }

    public static MatchingService getInstance() {
        return MatchingService.LazyHolder.INSTANCE;
    }

    public StringBuilder matchTheCrews(List<Crew> crews, PropertyDto propertyDto) {
        boolean isSuccessMatching = false;
        int limitCount = LIMIT_SHUFFLE_COUNT;
        Level level = returnLevel(propertyDto.getLevel());
        boolean isEvenNumber = isEven(crews.size());
        StringBuilder matchingResults = new StringBuilder();
        do {
            List<Crew> shuffleCrews = Randoms.shuffle(crews);
            if (isEvenNumber) {
                isSuccessMatching = callEvenSizeMatching(shuffleCrews, level);
            } else if (!isEvenNumber) {
                isSuccessMatching = callOddSizeMatching(shuffleCrews, level);
            }
            if (isSuccessMatching) {
                if (isEvenNumber) {
                    recordHistories(matchingResults, DEFAULT_START_INDEX, shuffleCrews.size(), shuffleCrews, level);
                    return matchingResults;
                } else if (!isEvenNumber) {
                    recordHistories(matchingResults, DEFAULT_START_INDEX, shuffleCrews.size() - 3, shuffleCrews, level);
                    recordRestHistories(matchingResults, shuffleCrews, level);
                    return matchingResults;
                }
            } else {
                limitCount--;
            }
        } while (!isSuccessMatching && limitCount != 0);
        return matchingResults.append(SystemErrorMessage.NOT_MATCHING.getMessage());
    }

    private boolean callOddSizeMatching(List<Crew> crews, Level level) {
        for (int i = 0; i < crews.size() - 3; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            if (isIncludeCrew(crewA, crewB, level) || isIncludeCrew(crewB, crewA, level)) {
                return false;
            }
        }
        return isPossibleRestThreeCrewCheck(crews, level);
    }

    private boolean isPossibleRestThreeCrewCheck(List<Crew> crews, Level level) {
        List<Crew> restCrews = new ArrayList<>();
        restCrews.add(crews.get(crews.size() - 3));
        restCrews.add(crews.get(crews.size() - 2));
        restCrews.add(crews.get(crews.size() - 1));
        for (int i = 0; i < restCrews.size(); i++) {
            Crew principal = restCrews.get(i);
            for (int j = i + 1; j < restCrews.size(); j++) {
                Crew comparison = restCrews.get(j);
                if (isIncludeCrew(principal, comparison, level) || isIncludeCrew(comparison, principal, level)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean callEvenSizeMatching(List<Crew> crews, Level level) {
        for (int i = 0; i < crews.size() - 1; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            if (isIncludeCrew(crewA, crewB, level) || isIncludeCrew(crewB, crewA, level)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder recordHistories(StringBuilder matchingResults, int startIndex, int lastIndex, List<Crew> crews, Level level) {
        for (int i = startIndex; i < lastIndex - 1; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            crewA.addHistory(crewB, level);
            crewB.addHistory(crewA, level);
            matchingResults.append(crewA.getName()).append(" : ").append(crewB.getName()).append("\n");
        }
        return matchingResults;
    }

    // 1 2 3 4 5
    private StringBuilder recordRestHistories(StringBuilder matchingResults, List<Crew> crews, Level level) {
        List<Crew> restCrews = new ArrayList<>();
        Crew crewA = crews.get(crews.size() - 3);
        Crew crewB = crews.get(crews.size() - 2);
        Crew crewC = crews.get(crews.size() - 1);
        restCrews.add(crewA);
        matchingResults.append(crewA.getName()).append(" : ");
        restCrews.add(crewB);
        matchingResults.append(crewB.getName()).append(" : ");
        restCrews.add(crewC);
        matchingResults.append(crewC.getName()).append("\n");

        for (int i = 0; i < restCrews.size(); i++) {
            Crew principal = restCrews.get(i);
            for (int j = i + 1; j < restCrews.size(); j++) {
                Crew comparison = restCrews.get(j);
                principal.addHistory(comparison, level);
                comparison.addHistory(principal, level);
            }
        }
        return matchingResults;
    }

    private boolean isIncludeCrew(Crew principal, Crew comparison, Level level) {
        return principal.getMatchingHistory().get(level).contains(comparison);
    }

    private Level returnLevel(String inputLevel) {
        for (Level level : Level.values()) {
            if (level.getLevel().equals(inputLevel)) {
                return level;
            }
        }
        return null;
    }

    private boolean isEven(int crewTotalNumber) {
        return crewTotalNumber % 2 == 0;
    }

    private static class LazyHolder {
        public static final MatchingService INSTANCE = new MatchingService();
    }
}
