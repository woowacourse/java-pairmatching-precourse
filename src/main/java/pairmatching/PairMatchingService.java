package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingService {
    private static CrewRepository crewRepository = new CrewRepository();
    private static Map<String, List<Pair>> history = new HashMap<>();

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

    public static List<Pair> pairMatching(Course course, Level level, Mission mission) {
        List<String> crewNames = crewRepository.findByCourse(course);
        if (crewNames == null) {
            throw new IllegalArgumentException("존재하지 않는 코스입니다.");
        }
        List<String> shuffleCrew = Randoms.shuffle(crewNames);
        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < shuffleCrew.size(); i += 2) {
            if (i + 1 == shuffleCrew.size()) {
                Pair lastPair = result.get(result.size() - 1);
                lastPair.addCrew(shuffleCrew.get(i));
                break;
            }
            Pair pair = new Pair(shuffleCrew.get(i), shuffleCrew.get(i + 1));
            result.add(pair);
        }
        history.put(course.name() + level.name() + mission.name(), result);
        return result;
    }

    public static boolean hasHistory(Course course, Level level, Mission mission) {
        return history.containsKey(course.name() + level.name() + mission.name());
    }

    public static List<List<Pair>> getHistory(Course course, Level level) {
        List<List<Pair>> result = new ArrayList<>();
        Mission.findAll().forEach(mission -> {
            if (hasHistory(course, level, mission)) {
                result.add(history.get(course.name() + level.name() + mission.name()));
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

    public static boolean hasSamePair(List<List<Pair>> history, List<Pair> rematch) {
        for (List<Pair> pairs : history) {
            for (Pair pair : pairs) {
                for (Pair rematchPair : rematch) {
                    if (pair.hasSamePair(rematchPair)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<Pair> findHistory(Course course, Level level, Mission mission) {
        return history.get(course.name() + level.name() + mission.name());
    }

    public static void reset() {
        history = new HashMap<>();
    }
}
