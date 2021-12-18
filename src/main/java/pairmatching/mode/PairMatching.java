package pairmatching.mode;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.Check;
import pairmatching.Course;
import pairmatching.Crew;
import pairmatching.CrewRepository;
import pairmatching.Level;
import pairmatching.Mission;
import pairmatching.MissionRepository;
import pairmatching.Pair;

public class PairMatching implements PairMatchingService {
    private static final String INPUT_DELIMITER = ",";

    @Override
    public void run() {
        while (true) {
            try {
                progressMatching();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void progressMatching() {
        System.out.println(GuidanceMessage.GUIDE);
        String[] split = Console.readLine().split(INPUT_DELIMITER);

        List<String> findCrewsName = CrewRepository.findAllByCourse(Course.findByCourse(getCourse(split)));
        List<String> shuffleNames = Randoms.shuffle(findCrewsName);
        Mission mission = MissionRepository.findByMission(getMission(split));
        if (isExistedPairs(split, shuffleNames, mission)) {
            return;
        }
        mission.addPairs(CrewRepository.matchingCrews(shuffleNames, Level.findByLevel(getLevel(split))));
        printPair();
        return;
    }

    private boolean isExistedPairs(String[] split, List<String> shuffleNames, Mission mission) {
        if (MissionRepository.existPair(mission.getName())) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
                + "네 | 아니오");
            if (Check.isYes(Console.readLine())) {
                mission.addPairs(CrewRepository.matchingCrews(shuffleNames, Level.findByLevel(getLevel(split))));
                printPair();
                return true;
            }
        }
        return false;
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

    private void printPair() {
        System.out.println("페어 매칭 결과입니다.");
        for (Mission mission : MissionRepository.getMissions()) {
            for (Pair pair : mission.getPairs()) {
                List<String> pairNames = pair.getCrews().stream().map(Crew::getName).collect(Collectors.toList());
                System.out.println(String.join(" : ", pairNames));
            }
        }
    }
}
