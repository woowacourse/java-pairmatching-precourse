package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SELECT_FUNCTION = "기능을 선택하세요.";
    
    public static String selectOption() {
        System.out.println(SELECT_FUNCTION);
        return Console.readLine();
    }
    
}
