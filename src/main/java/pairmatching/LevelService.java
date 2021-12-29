package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static pairmatching.Message.DIVIDE_LINE;

public class LevelService {
    private ArrayList<String> levelList = new ArrayList();
    private String[][] missionList = {{"자동차경주", "로또", "숫자야구게임"},
            {"장바구니", "결제", "지하철노선도"}, {}, {"성능개선", "배포"}, {}};

    public ArrayList<String> getLevelList() {
        return levelList;
    }

    public String getMissionList() {
        StringBuilder result = new StringBuilder();
        result.append("미션:\n");
        for (int i = 0; i < missionList.length; i++) {
            result.append("  - 레벨:" + (i + 1) + " ");
            result.append(Arrays.stream(missionList[i])
                    .map(String::valueOf)
                    .collect(Collectors.joining(" | ")));
            result.append("\n");
        }
        result.append(DIVIDE_LINE);
        return result.toString();
    }

    public void isExistMission(String level, String mission) throws IllegalArgumentException {
        int index = levelList.indexOf(level);
//        if(!missionList[index].contains(mission)) {
//            throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다.");
//        }
    }
}
