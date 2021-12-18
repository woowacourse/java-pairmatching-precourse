package pairmatching;

public enum Mission {
    RACING("자동차경주", 1),
    LOTTO("로또", 1),
    BASEBALL("숫자야구게임", 1),
    CART("장바구니", 2),
    BUY("결제", 2),
    METRO_LINE("지하철 노선도", 2),
    REFACTORING("성능개선", 4),
    RELEASE("배포", 4);

    private String name;
    private int missionNumber;

    Mission(String name, int missionNumber) {
        this.name = name;
        this.missionNumber = missionNumber;
    }

    public static String returnNamesByMissionNumber(int missionNumber) {
        String returnString = "";
        for (Mission mission : Mission.values()) {
            if(missionNumber == mission.missionNumber) {
                returnString += (mission.name + " | ");
            }
        }
        returnString.substring(0, returnString.length()-2);
        return returnString;
    }

}
