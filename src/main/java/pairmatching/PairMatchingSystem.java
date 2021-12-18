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
        UI.printPairMatchingChoice();

        String[] courseLevelMission = UI.insertPairMatchingChoice().split(",");
        Validation.validatePairMatchingLength(courseLevelMission);
        Validation.validateCourse(courseLevelMission);
        Validation.validateLevel(courseLevelMission);
        Validation.validateMission(courseLevelMission);
    }

    public void pairSelect(){

    }

    public void pairReset(){

    }

    public void pairQuit(){

    }
}
