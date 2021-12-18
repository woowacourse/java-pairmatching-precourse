package pairmatching.view;

import java.io.IOException;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchCommand;
import pairmatching.domain.PairMission;
import pairmatching.domain.command.MainCommand;

public class InputView {

    private InputView() {
    }

    public static MainCommand mainCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        MainCommand mainCommand = MainCommand.parseMainCommand(Console.readLine());
        System.out.println();
        return mainCommand;
    }

    public static PairMission inputPairMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");

        PairMission pairMission = new PairMission(Console.readLine());
        System.out.println();

        return pairMission;
    }

    public static List<Crew> crews(Course course) throws IOException {
        return course.getCrewsByCourse(course);
    }

    public static MatchCommand matchingInformation() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        MatchCommand matchCommand = MatchCommand.parseMatchCommand(Console.readLine());
        System.out.println();
        return matchCommand;
    }
}