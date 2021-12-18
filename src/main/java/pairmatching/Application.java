package pairmatching;

public class Application {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        int input = inputService.inputFunction();
        System.out.println(input);
    }
}
