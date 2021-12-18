package pairmatching;


import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.domain.Course.*;
import static pairmatching.domain.Level.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewInfoReader;
import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingFactory;
import pairmatching.domain.MatchingType;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class Application {
    static Pair pair = new Pair();
    static Mission mission = new Mission();
    static String input;
    public static void main(String[] args) {

        inputMissionByLevel();

        Set<MatchingType> matchingSet = new HashSet<>();
        while(true) {
            printChooseFunction();
            input = readLine();

            if (input.equalsIgnoreCase("Q")) { //종료
                System.out.println("종료");
                break;
            }

            printCourseAndMission();


            int op = Integer.parseInt(input);
            if (op == 1) { // 페어 매칭
                input = readLine(); // 프론트엔드, 레벨1, 자동차경주
                String[] data = input.split(", ");
                String courseName = data[0];
                String level = data[1];
                String mission = data[2];
                MatchingType matchingType = new MatchingType(Course.findByName(courseName), Level.findByName(level), mission);
                System.out.println(courseName + ", " + level + ", " + mission);

                // 매칭 정보가 이미 있을 경우
                if (!matchingSet.add(matchingType)) {
                    System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"+
                        "네 | 아니오");
                    input =  readLine();
                    if(input.equalsIgnoreCase("아니오")){
                        continue;
                    }
                }

                // 없을 경우
                if (courseName.equalsIgnoreCase(BACKEND.getName())) {

                    // matching.insertMatchingList(BACKEND);
                } else if (courseName.equalsIgnoreCase(FRONTEND.getName())) {
                    MatchingFactory.insertMatchingList(matchingType, FRONTEND);
                    // matching.insertMatchingList(FRONTEND);
                }

                System.out.println(MatchingFactory.getMatching(matchingType));

            } else if (op == 2) { // 페어 조회
                input = readLine(); // 프론트엔드, 레벨1, 자동차경주
                String[] data = input.split(", ");
                String courseName = data[0];
                String level = data[1];
                String mission = data[2];
                MatchingType matchingType = new MatchingType(Course.findByName(courseName), Level.findByName(level), mission);
                System.out.println(courseName + ", " + level + ", " + mission);

                // 매칭 결과가 있을 경우
                if(matchingSet.contains(matchingType)){
                    System.out.println(MatchingFactory.getMatching(matchingType));
                    continue;
                }
                System.out.println("매칭 결과가 없습니다.");
            } else if (op == 3) { // 페어 초기
                matchingSet.clear();
            }
        }
    }

    private static void printCourseAndMission() {
        System.out.println("#############################################");
        System.out.print(Course.toOutputString());
        System.out.print(mission.toString());
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주");
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




}
