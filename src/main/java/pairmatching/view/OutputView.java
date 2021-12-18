package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Level;

import java.util.Arrays;

public class OutputView {
    public void printInformation() {
        System.out.println("#############################################");
        printCourse();
        printMission();
        System.out.println("############################################");
    }

    private void printCourse() {
        System.out.println("과정: 백엔드 | 프론트엔드");

    }

    private void printMission() {
        System.out.println("미션:");
        System.out.println("- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("- 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("- 레벨3:");
        System.out.println("- 레벨4: 성능개선 | 배포");
        System.out.println("- 레벨5:");
    }
}
