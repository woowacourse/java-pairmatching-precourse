package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class Separator {
    private final static String separator = ",";

    public List<String> separateMatchData(String matchData) {
        String trimMatchData = matchData.replace(" ", "");
        return Arrays.asList(trimMatchData.split(separator));
    }
}
