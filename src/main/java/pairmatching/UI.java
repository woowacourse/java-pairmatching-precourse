package pairmatching;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {

    public static void printChoiceFeature(){
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    public static String insertChoiceFeature(){
        return Console.readLine();
    }

    public static void printPairMatchingChoice(){
        System.out.println("################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("- 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("- 레벨3:");
        System.out.println("- 레벨4: 성능개선 | 배포");
        System.out.println("- 레벨5:");
        System.out.println("################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public static String insertPairMatchingChoice(){
        return Console.readLine();
    }

    public static void printPairMatchingResult(List<String> matchedPairList){
        System.out.println("페어 매칭 결과입니다.");
        // 리스트 반복문
    }

    public static void printMatchedBefore(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }

    public static String insertYesOrNo(){
        return Console.readLine();
    }

    public static void printPairReset(){
        System.out.println("초기화 되었습니다.");
    }

    public static void printException(String msg){
        System.out.println(msg);
    }

}
