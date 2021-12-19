package pairmatching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewReader;
import pairmatching.domain.matcher.PairHistory;

public class GrammerTest {
    @Test
    void test_read_md() throws IOException {
        CrewReader crewReader = new CrewReader();
        List<Crew> crews = crewReader.readBECrewFromMd();
        for (Crew crew : crews) {
            System.out.println(crew.getName() + "+" + crew.getCourse());
        }
    }

    @Test
    void test_shuffle() {
        CrewReader crewReader = new CrewReader();
        List<Crew> crews = crewReader.readBECrewFromMd();
        List<Crew> crews2 = crewReader.readBECrewFromMd();

        crews2 = Randoms.shuffle(crews2);
        for (int i = 0; i < crews.size(); i++) {
            System.out.println(crews.get(i).getName() +"==" + crews2.get(i).getName());
        }
    }

    @Test
    void test_history() {
        CrewReader crewReader = new CrewReader();
        List<Crew> crews = crewReader.readFECrewFromMd();
        PairHistory pairHistory = new PairHistory(crews);

        System.out.println(pairHistory.isCrewAndCrewMeet(crews.get(0), crews.get(1)));
        pairHistory.setCrewAndCrewMet(crews.get(0), crews.get(1));
        System.out.println(pairHistory.isCrewAndCrewMeet(crews.get(0), crews.get(1)));
        pairHistory.setCrewAndCrewMet(crews.get(0), crews.get(1));
        System.out.println(pairHistory.isCrewAndCrewMeet(crews.get(0), crews.get(1)));

    }

    @Test
    void test_array() {
        int[][] bool = new int[10][10];
        for(int i =0 ; i< bool.length ; i++){
            System.out.println(Arrays.toString(bool));
        }
    }
}
