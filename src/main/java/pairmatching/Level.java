package pairmatching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList()),
    NOTHING("없음", Collections.emptyList());

    private String name;
    private List<String> missionList;

    Level(String name, List<String> missionList) {
        this.name = name;
        this.missionList = missionList;
    }

    public static Level findBymissionCode(String code){
        return
                //PayGroup의 Enum 상수들을 순회하며
                Arrays.stream(Level.values())
                        //payCode를 갖고 있는게 있는지 확인합니다.
                        .filter(payGroup -> payGroup.hasPayCode(code))
                        .findAny()
                        .orElse(NOTHING);
    }

    public boolean hasPayCode(String code){
        return missionList.stream()
                .anyMatch(pay -> pay.equals(code));
    }
    // 추가 기능 구현
}