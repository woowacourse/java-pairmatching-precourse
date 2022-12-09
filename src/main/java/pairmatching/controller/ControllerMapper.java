package pairmatching.controller;

import pairmatching.domain.Crews;

public class ControllerMapper {
    public static Controller executeByUserChoice(String choice, Crews crews){
        return MainControls
                .getMatchingControls(choice)
                .generatedController(crews);
    }
}
