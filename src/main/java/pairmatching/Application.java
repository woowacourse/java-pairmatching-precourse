package pairmatching;

public class Application {
    public static void main(String[] args) {
        PairMatchingSystem pairMatchingSystem = new PairMatchingSystem();
        while(true) {
            pairMatchingSystem.choiceFeature();
            if (pairMatchingSystem.getFeatureNum().equals("1")) {
                pairMatchingSystem.pairMatching();
            }
            else if (pairMatchingSystem.getFeatureNum().equals("2")) {
                pairMatchingSystem.pairSelect();
            }
            else if (pairMatchingSystem.getFeatureNum().equals("3")) {
                pairMatchingSystem.pairReset();
            }
            else if (pairMatchingSystem.getFeatureNum().equals("Q")) {
                break;
            }
        }
    }
}
