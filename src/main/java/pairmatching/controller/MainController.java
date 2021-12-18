package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    private static final String PRINT_Initialization = "\n초기화 되었습니다.";
    private static final String BASE_NO = "아니오";
    private static final String PAIR_RESULT = "\n페어 매칭 결과입니다.";


    Crews pairmatching;
    HashMap<String, List<String>> pairInfo;
    HashMap<String, List<List<String>>> duplicateCheck;

    public MainController() {
        pairmatching = new Crews();
        pairInfo = new HashMap<>();
        duplicateCheck = new HashMap<>();
        CrewInformationController.readCrews(pairmatching);
    }

    public void playGame() {
        while (true) {
            int inputChoice = chooseFunction();
            if (inputChoice == 0) {
                return;
            }
            if (inputChoice == 1) {
                pairStart();
            }
            if (inputChoice == 2) {
                pairInquiry();
            }
            if (inputChoice == 3) {
                pairInitialization();
            }
        }
    }

    private void pairInitialization() {
        System.out.println(PRINT_Initialization);
        pairInfo = new HashMap<>();
    }

    private void pairInquiry() {
        Output.printMissionAndProcess();
        Output.printMissionAndProcessSelect();
        String inputProcess = Input.inputProcess();
        if (pairInfo.containsKey(inputProcess)) {
            printPairResult(pairInfo.get(inputProcess));
            return;
        }
    }

    private void pairStart() {
        Output.printMissionAndProcess();
        String inputData = "";
        while (true) {
            try {
                Output.printMissionAndProcessSelect();
                String inputProcess = Input.inputProcess();
                ValidationController.inputProcessValidation(inputProcess);
                if (pairInfo.containsKey(inputProcess)) {
                    Output.printRematching();
                    inputData = Input.InputYesOrNo();
                    selectMatchingRestart(inputData, inputProcess);
                }
                if (!pairInfo.containsKey(inputProcess)) {
                    setPair(inputProcess);
                }
                if (!inputData.equals(BASE_NO)) {
                    printPairResult(pairInfo.get(inputProcess));
                    return;
                }
                if (inputData.equals(BASE_NO)) {
                    continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPairResult(List<String> result) {
        System.out.println(PAIR_RESULT);
        printMatchingList(result);
        System.out.println();
    }

    private void selectMatchingRestart(String inputData, String inputProcess) {
        if (inputData.equals(BASE_NO)) {
            return;
        }
        setPair(inputProcess);
    }

    private void setPair(String inputProcess) {
        String[] inputSplit = inputProcess.split(", ");
        List<List<String>> tempList = new ArrayList<>();
        if (duplicateCheck.containsKey(inputProcess)) {
            tempList.addAll(duplicateCheck.get(inputProcess));
        }

        if (inputSplit[0].equals(Course.BACKEND.getName())) {
            pairInfo.put(inputProcess, PairmatchingController.pairmatchingStart(pairmatching.getCrewBackendNames()));
            tempList.add(PairmatchingController.pairmatchingStart(pairmatching.getCrewBackendNames()));
            if (duplicateCheck.containsKey(inputProcess)) {
                duplicateCheck.replace(inputProcess, tempList);
            }
            if (!duplicateCheck.containsKey(inputProcess)) {
                duplicateCheck.put(inputProcess, tempList);
            }
            return;
        }
        pairInfo.put(inputProcess, PairmatchingController.pairmatchingStart(pairmatching.getCrewFrontendNames()));
        tempList.add(PairmatchingController.pairmatchingStart(pairmatching.getCrewFrontendNames()));
        if (duplicateCheck.containsKey(inputProcess)) {
            duplicateCheck.replace(inputProcess, tempList);
        }
        if (!duplicateCheck.containsKey(inputProcess)) {
            duplicateCheck.put(inputProcess, tempList);
        }
    }

    private int chooseFunction() {
        while (true) {
            Output.printFunctionSelection();
            String functionSelection = Input.inputFunctionSelection();
            try {
                if (ValidationController.checkSpellQValidation(functionSelection)) {
                    return 0;
                }
                ValidationController.chooseFunctionValidation(functionSelection);
                return Integer.parseInt(functionSelection);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
        for (int i = 0; i < matchingList.size() - 3; i++) {
            matchings.add(matchingList.get(i));
            count += 1;
            if (count == 2) {
                count = 0;
                System.out.println(String.join(" : ", matchings));
                matchings = new ArrayList<>();
            }
        }
        for (int i = matchingList.size() - 3; i < matchingList.size(); i++) {
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
            if (count == 2) {
                count = 0;
                System.out.println(String.join(" : ", matchings));
                matchings = new ArrayList<>();
            }
        }
    }
}
