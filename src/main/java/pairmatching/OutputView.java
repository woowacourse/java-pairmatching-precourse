package pairmatching;

public class OutputView {
    public static String DASH_LINE = "#############################################";
    public static void outputActions() {
        System.out.println("기능을 선택하세요.");
        for (Action action : Action.values()) {
            System.out.println(action.getName());
        }
    }

    public static void outputCourse() {
        System.out.println(DASH_LINE);
        System.out.println("과정 : " + Course.BACKEND.getName() + "|" + Course.FRONTEND.getName());
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.print("- " + level.getName() + ":");
            System.out.println(Level.getMissionsByLevel(level.getMissionNumber()));
        }
        System.out.println(DASH_LINE);
    }
}
