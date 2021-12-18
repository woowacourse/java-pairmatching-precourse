package pairmatching;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        MatchService matchService = new MatchService();
        int option = inputService.inputFunction();
        System.out.println(option);
        if (option == 0) {
            String input = inputService.inputMission();
        }
    }
}
