package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class BackendRepository {
    private static List<String> backendCrews;
    
    public static void addCrewNames() {
        try {
            backendCrews = Files.readAllLines(Paths.get("c:\\backend-crew.md"));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public static List<String> shuffleCrew() {
        return Randoms.shuffle(backendCrews);
    }
    
    public static Set<String> generatePairs(List<String> list) {
        Set<String> pairs = new LinkedHashSet<>();
        for(int i = 0; i < list.size()-1; i+=2) {
            String pair = list.get(i)+list.get(i+1);
            String pairRev = list.get(i+1)+list.get(i);
            pairs.add(pair);
            pairs.add(pairRev);
        }
        return pairs;
    }
}
