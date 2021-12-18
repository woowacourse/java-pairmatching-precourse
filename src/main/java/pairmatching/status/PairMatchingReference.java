package pairmatching.status;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.crew.Course;
import pairmatching.crew.Crew;
import pairmatching.crew.Level;
import pairmatching.crew.Mission;
import pairmatching.crew.MissionRepository;
import pairmatching.crew.Pair;

public class PairMatchingReference implements PairMatchingApplicationStatus {
    private static final String INPUT_DELIMITER = ",";

    @Override
    public void execute() {
        Course course;
        String mission;
        Level level;

        while (true) {
            try {
                System.out.println(GuidanceMessage.GUIDE);
                String[] split = Console.readLine().split(INPUT_DELIMITER);
                course = Course.findByCourse(getCourse(split));
                mission = getMission(split);
                level = Level.findByLevel(getLevel(split));
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        printPair(MissionRepository.getPairList(course, mission, level));
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
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : mission.getPairs()) {
            List<String> pairNames = pair.getCrews().stream().map(Crew::getName).collect(Collectors.toList());
            System.out.println(String.join(" : ", pairNames));
        }
    }
}
