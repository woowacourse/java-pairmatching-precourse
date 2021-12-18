package pairmatching.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import pairmatching.util.Constant;

public class OutputView {
    private static ArrayList<String> crewNames;
    private static List<String> shuffledCrew;


    public static void resultPairMatching(String[] pairMatchingInfo) throws IOException {
        System.out.println(Constant.PAIR_MATCHING_RESULT);
        pairMatchingList();
        System.out.println();
    }

    private static void pairMatchingList() throws IOException {
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
        pairList(shuffledCrew);
    }

    private static void pairList(List<String> shuffledCrew) {
        for (int i=0; i<shuffledCrew.size()/2; i++) {
            System.out.println(shuffledCrew.get(2 * i) + " : " + shuffledCrew.get(2 * i +1));
        }
    }

    public static void askFunction() {
        System.out.println(Constant.SELECT_FUNCTION);
    }

    public static void askPairMatching() {
        System.out.println(Constant.PAIR_MATCHING);
    }
}
