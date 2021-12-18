package pairmatching;

import pairmatching.matching.MatchingController;
import pairmatching.matching.MatchingService;
import camp.nextstep.edu.missionutils.Console;
import pairmatching.matching.Pair;

import java.util.Arrays;
import java.util.List;

public class PairMatchingSystem {

    private static final String MATCHING_MENU_SPLIT_UNIT = ",";

    private final MatchingController matchingController;

    private PairMatchingSystem() {
        matchingController = MatchingController.getInstance();
    }

    public void operate() {
        while(true) {
            Integer menu = inputMenu();
            if(menu.equals(-1))
                break;

            if(menu.equals(1)) {
                printMatchingMenu();
                createMatching();
            }
            if(menu.equals(2)) {
                printMatchingMenu();
                printMatching();
            }
            if(menu.equals(3)) {
                initializeMatching();
            }
        }
    }

    private void createMatching() {
        String inputMatchingMenu = Console.readLine();
        //TODO: 데이터 검증
        List<String> data = separatedData(inputMatchingMenu);
        List<Pair> pairs = matchingController.getPairMatching(data);
        printPair(pairs);
    }

    private void printMatching() {
        String inputMatchingMenu = Console.readLine();
        //TODO: 데이터 검증
        List<String> data = separatedData(inputMatchingMenu);
    }

    private void initializeMatching() {}

    private Integer inputMenu() {
        printInputMenu();
        String menu = Console.readLine();
        if(menu.equals("Q")){
            return -1;
        }
        return Integer.parseInt(Console.readLine());
    }

    private void printInputMenu() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    private void printMatchingMenu() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3:");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5:");
        System.out.println("############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    private List<String> separatedData(String data) {
        return Arrays.asList(data.split(MATCHING_MENU_SPLIT_UNIT));
    }

    private void printPair(List<Pair> pairs) {
        for(Pair pair : pairs) {
            List<String> names = pair.getAllCrewName();
            for(int i = 0; i < names.size(); ++i) {
                System.out.print(names.get(i));
                if(i != names.size() - 1)
                    System.out.print(":");
            }
        }
    }
}
