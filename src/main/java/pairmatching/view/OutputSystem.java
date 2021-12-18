package pairmatching.view;

public class OutputSystem {

    private OutputSystem() {}

    private static class LazyHolder {
        public static final OutputSystem INSTANCE = new OutputSystem();
    }

    public static OutputSystem getInstance() {
        return OutputSystem.LazyHolder.INSTANCE;
    }

    public void printConsoleMessage(String message) {
        System.out.println(message);
    }
}
