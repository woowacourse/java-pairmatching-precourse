package pairmatching.view;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import pairmatching.game.RunGame;
import pairmatching.util.Constant;

public class OutputView {
    private static ArrayList<String[]> resultList = new ArrayList<String[]>();
    private static ArrayList<String> crewNames;
    private static List<String> shuffledCrew;

    public static void setInitialize() {
        resultList = new ArrayList<String[]>();
        System.out.println(Constant.PAIR_INITIALIZATION);
        System.out.println();
    }

    public static void resultPairLookUp(String input) {
        System.out.println(Constant.PAIR_MATCHING_RESULT);
        for (String[] strings : resultList) {
            if (strings[0].equals(input)) {
                String inputString = strings[1].replace("]","");
                inputString = inputString.replace("[","");
                inputString = inputString.replace(" ","");
                String[] lookUpList = inputString.split(",");
                pairListLookUp(Arrays.asList(lookUpList));
            }
        }
        System.out.println();
    }

    private static void pairListLookUp(List<String> shuffledCrew) {
        ArrayList<String[]> resultCrew = new ArrayList<String[]>();
        for (int i=0; i<shuffledCrew.size()/2; i++) {
            if (shuffledCrew.size()%2 == 1 && i == (shuffledCrew.size()/2 - 1)) {
                resultCrew.add(new String[]{shuffledCrew.get(2 * i),shuffledCrew.get(2 * i + 1),shuffledCrew.get(shuffledCrew.size()-1)});
                break;
            }
            resultCrew.add(new String[]{shuffledCrew.get(2 * i),shuffledCrew.get(2 * i + 1)});
        }
        for (String[] strings : resultCrew) {
            System.out.println(String.join(" : ",strings));
        }

    }

    public static void resultPairMatching(String input) throws IOException {
        for (String[] strings : resultList) {
            if (input.equals(strings[0])) {
                System.out.println(Constant.REMATCHING);
                String input1 = Console.readLine();
                System.out.println();
                resultRematching(input1, input);
            }
        }
        System.out.println(Constant.PAIR_MATCHING_RESULT);
        pairMatchingList(input);
        System.out.println();
    }
    private static void resultRematching(String input1, String input) {
        if (input1.equals("네")) {
            removeList(input);
        }
        if (input1.equals("아니오")) {
            RunGame.pairMatching();
        }
    }

    private static void removeList(String input) {
        resultList.removeIf(strings1 -> strings1[0].equals(input));
    }

    private static void pairMatchingList(String input) throws IOException {
        String[] splitStrings = input.split(",");
        if (splitStrings[0].equals("백엔드")) {
            backendMatching(input);
        }
        if (splitStrings[0].equals("프론트엔드")) {
            frontendMatching(input);
        }
    }

    private static void backendMatching(String input) throws IOException {
        File aText = new File("src/main/resources/backend-crew.md");
        FileReader aReader = new FileReader(aText);
        BufferedReader aBufReader = new BufferedReader(aReader);
        crewNames = new ArrayList<String>();
        String aLine = "";
        while((aLine = aBufReader.readLine()) != null) {
            crewNames.add(aLine);
        }
        aBufReader.close();
        shuffledCrew = Randoms.shuffle(crewNames);
        pairList(shuffledCrew, input);
    }

    private static void frontendMatching(String input) throws IOException {
        File aText = new File("src/main/resources/frontend-crew.md");
        FileReader aReader = new FileReader(aText);
        BufferedReader aBufReader = new BufferedReader(aReader);
        crewNames = new ArrayList<String>();
        String aLine = "";
        while((aLine = aBufReader.readLine()) != null) {
            crewNames.add(aLine);
        }
        aBufReader.close();
        shuffledCrew = Randoms.shuffle(crewNames);
        pairList(shuffledCrew, input);
    }

    private static void pairList(List<String> shuffledCrew, String input) {
        ArrayList<String[]> resultCrew = new ArrayList<String[]>();
        for (int i=0; i<shuffledCrew.size()/2; i++) {
            if (shuffledCrew.size()%2 == 1 && i == (shuffledCrew.size()/2 - 1)) {
                resultCrew.add(new String[]{shuffledCrew.get(2 * i),shuffledCrew.get(2 * i + 1),shuffledCrew.get(shuffledCrew.size()-1)});
                break;
            }
            resultCrew.add(new String[]{shuffledCrew.get(2 * i),shuffledCrew.get(2 * i + 1)});
        }
        for (String[] strings : resultCrew) {
            System.out.println(String.join(" : ",strings));
        }
        resultList.add(new String[] {input, String.valueOf(shuffledCrew)});
    }

    public static void askFunction() {
        System.out.println(Constant.SELECT_FUNCTION);
    }

    public static void askPairMatching() {
        System.out.println(Constant.PAIR_MATCHING);
    }

    public static void askPairLookUp() {
        System.out.println(Constant.PAIR_LOOKUP);
    }
}
