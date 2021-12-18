package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static ArrayList<String> splitString(String inputString) {
        return new ArrayList<String>(Arrays.asList(inputString.split(",")));
    }
}
