package pairmatching;

public class OutputView {
    public static void outputActions() {
        System.out.println("기능을 선택하세요.");
        for (Action action : Action.values()) {
            System.out.println(action.name());
        }
    }
}
