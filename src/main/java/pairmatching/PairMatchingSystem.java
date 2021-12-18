package pairmatching;

import pairmatching.matching.MatchingService;
import camp.nextstep.edu.missionutils.Console;

public class PairMatchingSystem {

    private final MatchingService matchingService;

    private PairMatchingSystem() {
        matchingService = MatchingService.getInstance();
    }

    public void operate() {
        while(true) {
            Integer menu = inputMenu();
            if(menu.equals(-1))
                break;

        }
    }

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
}
