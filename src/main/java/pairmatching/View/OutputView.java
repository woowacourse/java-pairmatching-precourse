package pairmatching.View;

import pairmatching.Model.Pair;

import java.util.List;

public class OutputView {
    private static final String MENU_DISPLAY = "\n기능을 선택하세요\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

    public void printMenu(){
        System.out.println(MENU_DISPLAY);
    }

    public void printErrorMessage(RuntimeException e) {
        System.out.printf("[ERROR] "+ e.getMessage());
    }

    public void printSelectionNotice(){
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("- 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("- 레벨3:");
        System.out.println("- 레벨4: 성능개선 | 배포");
        System.out.println("- 레벨5:");
        System.out.println("############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }
    public void printMatchingResult(List<Pair> matching){
        System.out.println("페어 매칭 결과입니다.");
        matching.stream()
                .forEach(pair->System.out.println(pair.toString()));
    }
    public void printAskRematching(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
    }
}
