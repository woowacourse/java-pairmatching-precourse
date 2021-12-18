package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final Validator validator = new Validator();

    public String inputChooseFunction() {
        String input = Console.readLine();
        validator.validateFunctionInput(input);

        return input;
    }

    public String inputCourseLevelMission() {
        String input = Console.readLine();
        validator.validateCourseLevelMission(input);

        return input;
    }

    public String inputRematching() {
        String input = Console.readLine();
        validator.validateRematchingInput(input);

        return input;
    }
}
