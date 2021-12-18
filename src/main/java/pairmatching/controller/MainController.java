package pairmatching.controller;

import pairmatching.domain.Crews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MainController {
    Crews pairmatching;
    HashMap<String, Object> pairInfo;

    public MainController() {
        pairmatching = new Crews();
        pairInfo = new HashMap<>();
    }

    public void playGame() {
//        Output.printFunctionSelection();
//        String functionSelection = Input.inputFunctionSelection();
//
//        Output.printMissionAndProcess();
//        String inputProcess = Input.inputProcess();

        CrewInformationController.readCrews(pairmatching);
        System.out.println(pairmatching.getCrewBackendNames());
        System.out.println(pairmatching.getCrewFrontendNames());

        List<String> matchingList = PairmatchingController.pairmatchingStart(pairmatching.getCrewFrontendNames());
        printMatchingList(matchingList);
    }

    private void printMatchingList(List<String> matchingList) {
        if (matchingList.size() % 2 == 0) {
            printEven(matchingList);
            return;
        }
        printOdd(matchingList);
    }

    private void printOdd(List<String> matchingList) {
        List<String> matchings = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < matchingList.size()-3; i++) {
            matchings.add(matchingList.get(i));
            count += 1;
            if (count == 2){
                count = 0;
                System.out.println(String.join(" : ", matchings));
                matchings = new ArrayList<>();
            }
        }
        for (int i = matchingList.size()-3; i < matchingList.size(); i++) {
                matchings.add(matchingList.get(i));
        }
        System.out.println(String.join(" : ", matchings));
    }

    private void printEven(List<String> matchingList) {
        List<String> matchings = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < matchingList.size(); i++) {
            matchings.add(matchingList.get(i));
            count += 1;
            if (count == 2){
                count = 0;
                System.out.println(String.join(" : ", matchings));
                matchings = new ArrayList<>();
            }
        }
    }
}
