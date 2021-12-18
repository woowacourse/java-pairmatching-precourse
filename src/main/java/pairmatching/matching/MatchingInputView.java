package pairmatching.matching;

import camp.nextstep.edu.missionutils.Console;

public class MatchingInputView {
    public static String duplicateMatchingResult() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        return Console.readLine();
    }
}
