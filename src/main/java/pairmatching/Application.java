package pairmatching;


import static pairmatching.Level.*;
import static pairmatching.Type.*;

import java.util.List;

import org.assertj.core.util.Lists;

public class Application {
    static Pair pair = new Pair();
    static Mission mission = new Mission();
    public static void main(String[] args) {

        inputMissionByLevel();

        System.out.println("#############################################");
        System.out.print(mission.toString());
        System.out.println("#############################################");
        // pairMatching(BACKEND);
        // pairMatching(FRONTEND);
    }

    private static void inputMissionByLevel() {
        List<String> mission_1 = Lists.list("자동차경주", "로또", "숫자야구게임");
        List<String> mission_2 = Lists.list("장바구니", "결제", "지하철노선도");
        List<String> mission_4 = Lists.list("성능개선", "배포");
        mission_1.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_1, name));
        mission_2.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_2, name));
        mission_4.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_4, name));
    }

    static void pairMatching(Type type){
        String fileName = "";
        if(type.equals(BACKEND)){
            fileName = "backend";
        }else if(type.equals(FRONTEND)){
            fileName = "frontend";
        }
        List<String> backendList = CrewInfoReader.readCrewListByType(fileName+"-crew");
        Crew crewList = new Crew(type, backendList);

        List<String> shuffle = crewList.shuffleCrewList(type);
        randomMatching(shuffle);

        pair.printPair();

    }

    static void randomMatching(List<String> list){
        int size = list.size();
        int idx = 0;
        while(size > idx){
            if((size-idx)/2==1 && (size-idx)%2 == 1){
                pair.getPair(list.get(idx),list.get(idx+1), list.get(idx+2));
                idx+= 3;
            }else{
                pair.getPair(list.get(idx),list.get(idx+1));
                idx += 2;
            }
        }
    }
}
