package pairmatching.repository;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.system.exception.SamePairMatchedAtSameLevelException;
import pairmatching.vo.PairMatchingInfo;

import java.util.*;
import java.util.stream.Collectors;

public class PairMatchingRepository {
    public static final int PAIR_DEFAULT_SIZE = 2;
    private static final Map<PairMatchingInfo, List<List<String>>> pairMatchings = new HashMap<>();

    public static boolean existingWith(Course course, Mission mission) {
        return pairMatchings.containsKey(PairMatchingInfo.of(course, mission));
    }

    public static void save(PairMatchingInfo pairMatchingInfo, List<String> crewNames) {
        ArrayList<String> crewNamesArray = new ArrayList<>(crewNames);
        List<List<String>> pairedCrews = makePair(crewNamesArray);
        Validator.checkIfPairAlreadyMatched(pairMatchingInfo, pairedCrews);

        pairMatchings.put(pairMatchingInfo, pairedCrews);
    }

    private static List<List<String>> makePair(ArrayList<String> crewNamesArray) {
        List<List<String>> pairedCrews = new ArrayList<>();
        while (PAIR_DEFAULT_SIZE <= crewNamesArray.size()) {
            List<String> crewPair = new ArrayList<>(List.of(getCrewName(crewNamesArray), getCrewName(crewNamesArray)));
            handleOddCrew(crewNamesArray, crewPair);
            pairedCrews.add(crewPair);
        }
        return pairedCrews;
    }

    private static void handleOddCrew(ArrayList<String> crewNamesArray, List<String> crewPair) {
        if (crewNamesArray.size() == 1) {
            crewPair.add(getCrewName(crewNamesArray));
        }
    }

    private static String getCrewName(ArrayList<String> crewNamesArray) {
        return crewNamesArray.remove(0);
    }

    public static List<List<String>> findAllPairsBy(PairMatchingInfo pairMatchingInfo) {
        return pairMatchings.get(pairMatchingInfo);
    }

    public static void reset(PairMatchingInfo pairMatchingInfo) {
        pairMatchings.remove(pairMatchingInfo);
    }

    private static class Validator {
        private static void checkIfPairAlreadyMatched(PairMatchingInfo pairMatchingInfo, List<List<String>> pairedCrews) {
            List<List<String>> pairsAtSameLevelAndCourse
                    = findAllPairsByLevelAndCourse(pairMatchingInfo.getCourse(), pairMatchingInfo.getLevel());

            for (List<String> pair : pairedCrews) {
                if (pairsAtSameLevelAndCourse.contains(pair)) {
                    throw new SamePairMatchedAtSameLevelException();
                }
            }
        }

        private static List<List<String>> findAllPairsByLevelAndCourse(Course course, Level level) {
            List<List<String>> pairsAtSameLevel = new ArrayList<>();
            for (PairMatchingInfo pairMatchingInfo : getPairMatchingInfosAtSameLevelAndCourse(course, level)) {
                pairsAtSameLevel.addAll(pairMatchings.get(pairMatchingInfo));
            }
            pairsAtSameLevel.forEach(Collections::sort);
            return pairsAtSameLevel;
        }

        private static List<PairMatchingInfo> getPairMatchingInfosAtSameLevelAndCourse(Course course, Level level) {
            List<PairMatchingInfo> infosAtSameLevel = pairMatchings.keySet().stream()
                    .filter(pairMatchingInfo -> pairMatchingInfo.isLevel(level))
                    .filter(pairMatchingInfo -> pairMatchingInfo.isCourse(course))
                    .collect(Collectors.toList());
            return infosAtSameLevel;
        }
    }
}
