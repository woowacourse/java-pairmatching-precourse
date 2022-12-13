package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MenuCommand;
import pairmatching.domain.Mission;
import pairmatching.domain.SearchingInfoDto;
import pairmatching.domain.YesNoCommand;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final int INDEX_COURSE = 0;
    private static final int INDEX_LEVEL = 1;
    private static final int INDEX_MISSION = 2;
    private static final String MENU_LIST =
            "기능을 선택하세요.\n"
                    + "1. 페어 매칭\n"
                    + "2. 페어 조회\n"
                    + "3. 페어 초기화\n"
                    + "Q. 종료\n";

    private static final String ASK_INFORMATION_MESSAGE =
            "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주\n";

    private static final String ASK_REMATCH_OR_NOT_MESSAGE =
            "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오\n";

    public MenuCommand readMenuCommand(){
        System.out.println(MENU_LIST);
        try{
            return MenuCommand.fromInput(readLine());
        } catch(IllegalArgumentException error){
            System.out.println(error.getMessage());
            return readMenuCommand();
        }
    }

    public SearchingInfoDto readSearchingInformation(){
        System.out.println(ASK_INFORMATION_MESSAGE);
        String[] information = readLine().split(",");
        try{
            return new SearchingInfoDto(Course.ofName(information[INDEX_COURSE].trim()),
                    Level.ofName(information[INDEX_LEVEL].trim()),
                    Mission.ofValues(Level.ofName(information[INDEX_LEVEL].trim()), information[INDEX_MISSION].trim()));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readSearchingInformation();
        }
    }

    public YesNoCommand readRematchOrNot(){
        System.out.println(ASK_REMATCH_OR_NOT_MESSAGE);
        try{
            return YesNoCommand.fromInput(readLine());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readRematchOrNot();
        }
    }

}
