package pairmatching.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {


    public static void printPairInfo(
        Map<String, Set<String>> pairInfo,
        List<String> shuffledCrew)
    {
        String pairInfoMessage = "";
        Map<String, Boolean> visit = new HashMap<>();
        // init
        for (String crew : shuffledCrew) {
            visit.put(crew, false);
        }

        for (String crew : shuffledCrew) {
            if (!visit.get(crew)) {
                visit.put(crew, true);

                pairInfoMessage += crew;
                for (String pair : pairInfo.get(crew)) {
                    pairInfoMessage += String.format(" : %s", pair);
                    visit.put(pair, true);
                }
                pairInfoMessage += String.format("%n");
                }

        }
        System.out.println(pairInfoMessage);

    }
}
