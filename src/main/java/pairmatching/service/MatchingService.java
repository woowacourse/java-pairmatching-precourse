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

    private MatchingService() {}

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
            isSuccessMatching = isPossibleMatching(level, shuffleCrews, isEvenNumber);
            if (isSuccessMatching) {
                if (isEvenNumber) {
                    recordHistories(matchingResults, shuffleCrews.size(), shuffleCrews, level);
                    return matchingResults;
                } else if (!isEvenNumber) {
                    recordHistories(matchingResults, shuffleCrews.size() - 3, shuffleCrews, level);
                    recordRestHistories(matchingResults, shuffleCrews, level);
                    return matchingResults;
                }
            } else {
                limitCount--;
            }
        } while (!isSuccessMatching && limitCount != 0);
        return matchingResults.append(SystemErrorMessage.NOT_MATCHING.getMessage());
    }

    private boolean isPossibleMatching(Level level, List<Crew> shuffleCrews, boolean isEvenNumber) {
        if (isEvenNumber) {
            return isPromisingEvenSizeMatching(shuffleCrews, level);
        }
        return isPromisingOddSizeMatching(shuffleCrews, level);
    }

    private boolean isPromisingOddSizeMatching(List<Crew> crews, Level level) {
        for (int i = 0; i < crews.size() - 3; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            if (isIncludeCrew(crewA, crewB, level)) {
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
            Crew crewA = restCrews.get(i);
            for (int j = i + 1; j < restCrews.size(); j++) {
                Crew crewB = restCrews.get(j);
                if (isIncludeCrew(crewA, crewB, level)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPromisingEvenSizeMatching(List<Crew> crews, Level level) {
        for (int i = 0; i < crews.size() - 1; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            if (isIncludeCrew(crewA, crewB, level)) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder recordHistories(StringBuilder matchingResults, int lastIndex, List<Crew> crews, Level level) {
        for (int i = DEFAULT_START_INDEX; i < lastIndex - 1; i += 2) {
            Crew crewA = crews.get(i);
            Crew crewB = crews.get(i + 1);
            crewA.addHistory(crewB, level);
            crewB.addHistory(crewA, level);
            matchingResults.append(crewA.toString()).append(" : ").append(crewB.toString()).append("\n");
        }
        return matchingResults;
    }

    private StringBuilder recordRestHistories(StringBuilder matchingResults, List<Crew> crews, Level level) {
        List<Crew> restCrews = getRestCrews(matchingResults, crews);
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

    private List<Crew> getRestCrews(StringBuilder matchingResults, List<Crew> crews) {
        List<Crew> restCrews = new ArrayList<>();
        Crew crewA = crews.get(crews.size() - 3);
        Crew crewB = crews.get(crews.size() - 2);
        Crew crewC = crews.get(crews.size() - 1);
        restCrews.add(crewA);
        restCrews.add(crewB);
        restCrews.add(crewC);
        matchingResults.append(crewA.toString()).append(" : ");
        matchingResults.append(crewB.toString()).append(" : ");
        matchingResults.append(crewC.toString()).append("\n");
        return restCrews;
    }

    private boolean isIncludeCrew(Crew crewA, Crew crewB, Level level) {
        if (crewA.isContainCrew(level, crewB) || crewB.isContainCrew(level, crewA)) {
            return true;
        }
        return false;
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
