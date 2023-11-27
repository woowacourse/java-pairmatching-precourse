package pairmatching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static int countDuplicateElements(List<String> list1, List<String> list2) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String str : list1) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        int duplicateCount = 0;

        for (String str : list2) {
            if (countMap.containsKey(str) && countMap.get(str) > 0) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }
}
