package pairmatching;


import static pairmatching.domain.Course.*;
import static pairmatching.domain.Level.*;

import java.util.List;

import org.assertj.core.util.Lists;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewInfoReader;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class Application {
    static Pair pair = new Pair();
    static Mission mission = new Mission();
    public static void main(String[] args) {

        // inputMissionByLevel();
        //
        // printChooseFunction();
        //
        // System.out.println("#############################################");
        // System.out.print(Course.toOutputString());
        // System.out.print(mission.toString());
        // System.out.println("#############################################");

        pairMatching(BACKEND);
        // pairMatching(FRONTEND);
    }

    private static void printChooseFunction() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    private static void inputMissionByLevel() {
        List<String> mission_1 = Lists.list("자동차경주", "로또", "숫자야구게임");
        List<String> mission_2 = Lists.list("장바구니", "결제", "지하철노선도");
        List<String> mission_4 = Lists.list("성능개선", "배포");
        mission_1.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_1, name));
        mission_2.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_2, name));
        mission_4.stream().forEach(name -> mission.insertMissionByLevel(LEVEL_4, name));
    }

    static void pairMatching(Course course){
        String fileName = "";
        if(course.equals(BACKEND)){
            fileName = "backend";
        }else if(course.equals(FRONTEND)){
            fileName = "frontend";
        }
        List<String> backendList = CrewInfoReader.readCrewListByType(fileName+"-crew");
        Crew crewList = new Crew(course, backendList);

        List<String> shuffle = crewList.shuffleCrewList(course);
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
