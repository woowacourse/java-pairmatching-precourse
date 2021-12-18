package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class GeneralInputView {
    public static String inputCourseByClient() {
        GeneralOutputView.preCourseInfoPrint();
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return Console.readLine();
    }
}
