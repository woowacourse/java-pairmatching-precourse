package pairmatching.model;

public enum Game {
    CARRACE(Level.LEVEL1, "자동차경주"),
    LOTO(Level.LEVEL1, "로또"),
    BASEBALL(Level.LEVEL1, "숫자야구게임"),
    BASKET(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),
    PERFORMANCE(Level.LEVEL4, "성능개선"),
    DISTRIBUTION(Level.LEVEL4, "배포");

    private Level level;
    private String name;

    Game(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public String getName(){
        return name;
    }
}
