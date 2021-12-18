package pairmatching.domain.mission;

public enum MissionName {
    // level 1
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),

    // level 2
    POCKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),

    // level 4
    PERFORMANCE("성능개선"),
    RELEASE("배포");

    private String name;

    MissionName(String name) {
        this.name = name;
    }

    public static boolean isNotValid(String input) {
        return ! ("자동차경주".equals(input) ||
                "로또".equals(input)||
                "숫자야구게임".equals(input)||
                "장바구니".equals(input)||
                "결제".equals(input)||
                "지하철노선도".equals(input)||
                "성능개선".equals(input)||
                "배포".equals(input));
    }

    public String getName() {
        return name;
    }

    public boolean isSame(String comparison) {
        return name.equals(comparison);
    }
}
