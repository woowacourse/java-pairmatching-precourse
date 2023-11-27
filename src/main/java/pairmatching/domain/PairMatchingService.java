package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.option.Course;
import pairmatching.domain.option.Level;
import pairmatching.domain.option.Mission;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.PairOption;
import pairmatching.domain.pair.Pairs;
import pairmatching.message.ExceptionMessage;
import pairmatching.message.ProgramOption;

public class PairMatchingService {
    private static CrewRepository crewRepository = new CrewRepository();
    private static Map<PairOption, Pairs> history = new HashMap<>();

    public static void initCrews() {
        crewRepository = new CrewRepository();
        history = new HashMap<>();
        crewRepository.initBackend(ProgramOption.BACKEND_FILE_PATH);
        crewRepository.initFrontend(ProgramOption.FRONTEND_FILE_PATH);
    }

    public static String getValidateMenu(String input) {
        validateMenu(input);
        return input;
    }

    private static void validateMenu(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_INPUT);
        }
        if (!ProgramOption.MENU_INPUT_OPTIONS.contains(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_INPUT);
        }
    }
    public static Pairs createNewPairMatching(PairOption option) {
        Pairs pairs = createPairMatching(option);
        addPairsToHistory(option, pairs);
        return pairs;
    }

    public static Pairs createNoDuplicatePairMatching(PairOption option, List<Pairs> history) {
        for (int i = 0; i < 3; i++) {
            Pairs rematch = createPairMatching(option);
            if (hasSamePair(history, rematch)) {
                continue;
            }
            addPairsToHistory(option, rematch);
            return rematch;
        }
        throw new IllegalArgumentException(ExceptionMessage.REMATCHING_FAIL);
    }

    private static Pairs createPairMatching(PairOption option) {
        List<String> shuffleCrew = getShuffleCrew(option.getCourse());
        return Pairs.createByNameList(shuffleCrew);
    }

    public static void addPairsToHistory(PairOption option, Pairs pairs) {
        history.put(option, pairs);
    }

    private static List<String> getShuffleCrew(Course course) {
        List<String> crewNames = crewRepository.findByCourse(course);
        if (crewNames == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MENU_INPUT);
        }
        return Randoms.shuffle(crewNames);
    }

    public static boolean hasHistory(PairOption option) {
        return history.containsKey(option);
    }

    public static List<Pairs> getHistory(Course course, Level level) {
        List<Pairs> result = new ArrayList<>();
        Mission.findAll().forEach(mission -> {
            PairOption option = new PairOption(course, level, mission);
            if (hasHistory(option)) {
                result.add(history.get(option));
            }
        });
        return result;
    }

    public static String getValidateRematch(String input) {
        validateRematch(input);
        return input;
    }

    private static void validateRematch(String input) {
        if (!input.equals(ProgramOption.YES) && !input.equals(ProgramOption.NO)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_REMATCH_INPUT);
        }
    }

    public static boolean hasSamePair(List<Pairs> history, Pairs rematch) {
        for (Pairs pairs : history) {
            if (pairs.hasSamePair(rematch)) {
                return true;
            }
        }
        return false;
    }

    public static Pairs findHistory(PairOption option) {
        return history.get(option);
    }

    public static void reset() {
        history = new HashMap<>();
    }
}
