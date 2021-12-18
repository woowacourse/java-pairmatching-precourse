package pairmatching;

public class Application {
    public static void main(String[] args) {
        PairMatching pairMatching = new PairMatching();
        do {
            pairMatching.run();
        } while (!pairMatching.quit());
    }
}
