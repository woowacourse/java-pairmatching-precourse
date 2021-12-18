package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static ArrayList<String> splitString(String inputString) {
        return new ArrayList<String>(Arrays.asList(inputString.split(",")));
    }

    public static List<String> makeFileToList(String path) {
        List<String> crewList = new ArrayList<String>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                crewList.add(line);
            }
            bufReader.close();
        } catch (Exception e) {
            new IllegalArgumentException("[ERROR]");
        }
        return crewList;
    }

    public static ArrayList<String> shuffleCrewList(ArrayList<String> crewList) {
        return (ArrayList<String>) Randoms.shuffle(crewList);
    }
}
