package pairmatching;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    public static String inputMenu() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return Console.readLine();
    }

    public static String selectCourse() {
        String result = "#############################################\n"
                + "과정: 백엔드 | 프론트엔드\n"
                + "미션:\n"
                + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
                + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
                + "  - 레벨3: \n"
                + "  - 레벨4: 성능개선 | 배포\n"
                + "  - 레벨5: \n"
                + "############################################\n"
                + "과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주";
        System.out.println(result);
        return Console.readLine();
    }

    public static void printMatchingResult(List<String> shuffled) {
        String result = "페어 매칭 결과입니다.\n";
        for (int i=0; i<shuffled.size(); i+=2) {
            if (i==shuffled.size()-1) {
                result += " : "+shuffled.get(i)+"";
            }
            if (i!=shuffled.size()-1) {
                result += "\n"+shuffled.get(i)+" : "+shuffled.get(i+1);
            }
        }
        result += "\n";
        System.out.println(result);
    }
}
