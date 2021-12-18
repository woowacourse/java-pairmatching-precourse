package pairmatching;

public enum Mission {
    RACING("자동차경주",Level.LEVEL1),
    LOTTO("로또",Level.LEVEL1),
    BASEBALL("숫자야구게임",Level.LEVEL1),
    BASKET("장바구니",Level.LEVEL2),
    PAYMENT("결제",Level.LEVEL2),
    SUBWAY("지하철노선도",Level.LEVEL2),
    IMPROVEMENT("성능개선",Level.LEVEL4),
    DISTRIBUTION("배포",Level.LEVEL4);

    private String name;
    private Level level;

    Mission(String name,Level level) {
        this.name = name;
        this.level = level;

        level.addMission(this);
    }

    public void printMission(){
        System.out.print(name);
    }
}
