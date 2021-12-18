package pairmatching.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.constants.InputConstants;
import pairmatching.domain.LevelMissonRepository;
import pairmatching.domain.Section;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class InputView {
    public static String getFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println(InputConstants.PAIR_MATCHING + ". 페어 매칭");
        System.out.println(InputConstants.PAIR_SEARCHING + ". 페어 조회");
        System.out.println(InputConstants.PAIR_CLEAR + ". 페어 초기화");
        System.out.println(InputConstants.PAIR_QUIT + ". 종료");

        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if(!InputConstants.INPUT.contains(input)) {
            throw new IllegalArgumentException("[ERROR] : 해당하는 기능이 없습니다.");
        }
    }

    public static Section getSection() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        return convertSection(input);
    }

    private static Section convertSection(String input) {
        String [] splits = input.split(", ");
        if(splits.length != 3) {
            throw new IllegalArgumentException("[ERROR] : 과정, 레벨, 미션을 모두 입력해주세요.");
        }
        Course course = Course.findByName(splits[0]);
        Level level = Level.findByName(splits[1]);
        String misson = splits[2];
        validateMisson(level, misson);
        return new Section(course, level, misson);
    }

    private static void validateMisson(Level level, String misson) {
        List<String> missons = LevelMissonRepository.findMissonByLevel(level);
        if(!missons.contains(misson)) {
            throw new IllegalArgumentException("[ERROR] : 해당 레벨에 존재하는 미션이 아닙니다.");
        }
    }

    public static String getRematch() {
        System.out.println("\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println(InputConstants.REMATCH_YES + " | " + InputConstants.REMATCH_NO);
        String input = Console.readLine();
        validateRematch(input);
        return input;
    }

    private static void validateRematch(String input) {
        if(!input.equals(InputConstants.REMATCH_YES) && !input.equals(InputConstants.REMATCH_NO)) {
            throw new IllegalArgumentException("[ERROR] 네, 아니오 중에서 답해주세요.");
        }
    }
}
