package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.InputMessage;

public class InputView {

    public static void askCaegory(){
        System.out.println(InputMessage.CHOOSE_CATEGORY);
    }

    public static String getCaegory(){
        String category = Console.readLine();
        return category;
    }

    public static void askDetail(){
        System.out.println(InputMessage.CHOOSE_DETAIL);
    }

    public static String getDetail(){
        String category = Console.readLine();
        return category;
    }
}
