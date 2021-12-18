package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

public class BackendRepository {
    private static List<String> backendCrews;
    
    public static void addCrewNames() {
        try {
            backendCrews = Arrays.asList("백호","태웅","치수","태섭","대만","준호","대협","덕규","태산","경태","수겸","현준","준섭","한나","소연","호열","대남","용팔","구식","달재");
        } catch (Exception e) {
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
