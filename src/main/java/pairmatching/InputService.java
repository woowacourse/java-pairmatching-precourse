package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private PrintService printService = new PrintService();
    private ValidateService validateService = new ValidateService();
    private FunctionService functionService = new FunctionService();

    public int inputFunction() {
        printService.printWithMessage(functionService.toString());
        while (true) {
            String input = Console.readLine();
            if (validateService.isValidOption(input)) {
                return functionService.getSelectedOption();
            }
        }
    }
    
    public String inputMission() {
        printService.printCourse();
        printService.printMission();
        while (true) {
            String input = Console.readLine();
            if (validateService.isValidateMission(input)) {
                return input;
            }
        }
    }
}
