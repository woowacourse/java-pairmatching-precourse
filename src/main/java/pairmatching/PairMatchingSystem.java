package pairmatching;

public class PairMatchingSystem {
    private String featureNum;
    private Crew crew;

    public String getFeatureNum() {
        return featureNum;
    }

    public void choiceFeature(){
        UI.printChoiceFeature();
        featureNum = UI.insertChoiceFeature();
        Validation.validateChoiceFeature(featureNum);
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
