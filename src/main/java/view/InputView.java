package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String SELECT_FUNCTION = "기능을 선택하세요.";
    private static final String SELECT_CURRICULUM= "과정, 레벨, 미션을 선택하세요.";
    private static final String EXAMPLE= "ex) 백엔드, 레벨1, 자동차경주";
    
    public static String selectOption() {
        System.out.println(SELECT_FUNCTION);
        return Console.readLine();
    }
    
    public static String selectCurriculum() {
        System.out.println(SELECT_CURRICULUM);
        System.out.println(EXAMPLE);
        return Console.readLine();
    }
    
    
}
