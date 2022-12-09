package pairmatching;

public class ControllerMapper {
    public static Controller executeByUserChoice(String choice){
        return MainControls
                .getMatchingControls(choice)
                .generatedController();
    }
}
