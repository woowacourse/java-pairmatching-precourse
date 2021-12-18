package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class FrontendRepository {
    private static List<String> frontendCrews;
    
    public static void addCrewNames(){
        try {
            frontendCrews = Files.readAllLines(Paths.get("C:\\dev\fileSearch\\frontend-crew.md"));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    
    public static List<String> shuffleCrew() {
        return Randoms.shuffle(frontendCrews);
    }
    
    public static Set<String> generatePairs(List<String> list) {
        Set<String> pairs = new LinkedHashSet<>();
        for(int i = 0; i < list.size()-3; i+=2) {
            String pair = list.get(i)+list.get(i+1);
            String pairRev = list.get(i+1)+list.get(i);
            pairs.add(pair);
            pairs.add(pairRev);
        }
        
        for(String s : lastPairs(list.get(list.size()-3),list.get(list.size()-2),list.get(list.size()-1))) {
            pairs.add(s);
        }
        
        return pairs;
    }
    
    private static List<String> lastPairs(String s1, String s2, String s3) {
        List<String> lastPairs = new ArrayList<>();
        lastPairs.add(s1 + s2 + s3);
        lastPairs.add(s1 + s3 + s2);
        lastPairs.add(s2 + s1 + s3);
        lastPairs.add(s2 + s3 + s1);
        lastPairs.add(s3 + s1 + s2);
        lastPairs.add(s3 + s2 + s1);
        
        return lastPairs;
    }
}
