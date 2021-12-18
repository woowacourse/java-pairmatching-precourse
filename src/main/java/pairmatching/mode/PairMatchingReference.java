package pairmatching.mode;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.Course;
import pairmatching.Crew;
import pairmatching.Level;
import pairmatching.Mission;
import pairmatching.MissionRepository;
import pairmatching.Pair;

public class PairMatchingReference implements PairMatchingService {
    private static final String INPUT_DELIMITER = ",";

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(GuidanceMessage.GUIDE);
                String[] split = Console.readLine().split(INPUT_DELIMITER);
                Course course = Course.findByCourse(getCourse(split));
                Level level = Level.findByLevel(getLevel(split));
                printPair(MissionRepository.getPairList(course, getMission(split), level));
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String getCourse(String[] split) {
        return split[0].trim();
    }

    private String getLevel(String[] split) {
        return split[1].trim();
    }

    private String getMission(String[] split) {
        return split[2].trim();
    }

    private void printPair(Mission mission) {
        for (Pair pair : mission.getPairs()) {
            List<String> pairNames = pair.getCrews().stream().map(Crew::getName).collect(Collectors.toList());
            System.out.println(String.join(" : ", pairNames));
        }
    }
}
