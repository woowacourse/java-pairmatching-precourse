package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    Crews crews = new Crews();

    String input;

    public void start() {
        crews.readFrontend();
        crews.readBackend();
    }

    private void program() {

    }

    public void selectFunctions() {
        System.out.println(Message.INPUT_FUNCTIONS);
        boolean check = false;
        while (!check) {
            input();
            check = inputFunctions();
        }

    }

    private boolean inputFunctions() {
        try {
            boolean check = checkFunctions();
            if (!check) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_INPUT_FUNCTIONS);
            return false;
        }
        return true;
    }

    public void input() {
        input = Console.readLine();
    }

    private boolean checkFunctions(){
        if (input.length() == 1 && (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3' || input.charAt(0) == 'Q')) {
            return true;
        }
        return false;
    }


}
