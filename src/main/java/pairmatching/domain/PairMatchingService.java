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

public class PairMatchingService {
    private static CrewRepository crewRepository = new CrewRepository();
    private static Map<PairOption, Pairs> history = new HashMap<>();

    public static void initCrews() {
        crewRepository = new CrewRepository();
        history = new HashMap<>();
        crewRepository.initBackend("src/main/resources/backend-crew.md");
        crewRepository.initFrontend("src/main/resources/frontend-crew.md");
    }

    public static String getValidateMenu(String input) {
        validateMenu(input);
        return input;
    }

    private static void validateMenu(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("메뉴에 없는 기능입니다.");
        }
        if (!"123Q".contains(input)) {
            throw new IllegalArgumentException("메뉴에 없는 기능입니다.");
        }
    }

    public static Pairs pairMatching(PairOption option) {
        List<String> shuffleCrew = getShuffleCrew(option.getCourse());
        Pairs pairs = Pairs.createByNameList(shuffleCrew);
        history.put(option, pairs);
        return pairs;
    }

    private static List<String> getShuffleCrew(Course course) {
        List<String> crewNames = crewRepository.findByCourse(course);
        if (crewNames == null) {
            throw new IllegalArgumentException("존재하지 않는 코스입니다.");
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
        if (!input.equals("네") && !input.equals("아니오")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static boolean hasSamePair(List<Pairs> history, Pairs rematch) {
        for (Pairs pairs : history) {
            for (Pair pair : pairs.getPairs()) {
                for (Pair rematchPair : rematch.getPairs()) {
                    if (pair.hasSamePair(rematchPair)) {
                        return true;
                    }
                }
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
