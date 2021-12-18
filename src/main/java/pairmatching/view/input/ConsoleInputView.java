package pairmatching.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInputView implements InputView {
    private static final String ERROR_SYMBOL = "[ERROR] ";
    private static final String FUNCTION_INFORMATION = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료\n";
    private static final String COURSE_AND_MISSION =
            "#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################\n"
            + "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    private static final String DELIMITER = ", ";

    @Override
    public void showErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    @Override
    public Function inputFunction() {
        System.out.println(FUNCTION_INFORMATION);
        return Function.of(readLine());
    }

    @Override
    public List<String> inputCourseAndMission() {
        System.out.println(COURSE_AND_MISSION);
        String userInput = readLine();
        return Arrays.stream(userInput.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
