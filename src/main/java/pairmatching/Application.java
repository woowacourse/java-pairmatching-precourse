package pairmatching;

import static pairmatching.domain.Level.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;

import pairmatching.domain.Course;
import pairmatching.domain.matching.MatchingType;
import pairmatching.domain.Mission;
import pairmatching.io.Input;

public class Application {
    static Mission mission = new Mission();
    public static void main(String[] args) {
        inputMissionByLevel();
        // System.out.println(getLevelNameList().stream().anyMatch(s -> s.equals("레벨1")));
        // System.out.println(getLevelNameList().stream().anyMatch(s -> s.equals("레벨2")));
        // System.out.println(getLevelNameList().stream().anyMatch(s -> s.equals("레벨3")));
        // System.out.println(getLevelNameList().stream().anyMatch(s -> s.equals("레벨4")));

        Set<MatchingType> matchingSet = new HashSet<>();
        Input inputProcessor = new Input(mission);

        String input;
        while(true) {
            input = inputProcessor.inputChooseFunction();
            if (input.equalsIgnoreCase("Q")) { //종료
                break;
            }
            printCourseAndMission();
            inputProcessor.inputPairing(Integer.parseInt(input), matchingSet);
        }
    }

    private static void printCourseAndMission() {
        System.out.println("\n#############################################");
        System.out.print(Course.toOutputString());
        System.out.print(mission.toString());
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주");
    }

    private static void inputMissionByLevel() {
        List<String> mission_1 = Lists.list("자동차경주", "로또", "숫자야구게임");
        List<String> mission_2 = Lists.list("장바구니", "결제", "지하철노선도");
        List<String> mission_4 = Lists.list("성능개선", "배포");
        mission_1.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_1, name));
        mission_2.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_2, name));
        mission_4.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_4, name));
    }






}
