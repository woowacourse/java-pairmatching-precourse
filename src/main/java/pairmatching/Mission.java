package pairmatching;

public enum Mission {
    MISSION1("자동차경주", 0),
    MISSION2("로또", 1),
    MISSION3("숫자야구게임", 2),
    MISSION4("장바구니", 3),
    MISSION5("결제", 4),
    MISSION6("지하철노선도", 5),
    MISSION7("성능개선", 6),
    MISSION8("배포", 7);

    private final String name;
    private final int resultIndex;

    Mission(String name, int resultIndex) {
        this.name = name;
        this.resultIndex = resultIndex;
    }

    public String getName() {
        return name;
    }

    public int getResultIndex() {
        return resultIndex;
    }
}
