package pairmatching;

public class PairMatchingSystem {
    private String featureNum;
    private Crew crew;

    public String getFeatureNum() {
        return featureNum;
    }

    public void choiceFeature(){
        while(true) {
            try {
                UI.printChoiceFeature();
                featureNum = UI.insertChoiceFeature();
                Validation.validateChoiceFeature(featureNum);
                break;
            } catch (IllegalArgumentException e){
                UI.printException(e.getMessage());
            }
        }
    }

    public void pairMatching(){

    }

    public void pairSelect(){

    }

    public void pairReset(){

    }

    public void pairQuit(){

    }
}
