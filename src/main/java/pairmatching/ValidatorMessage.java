package pairmatching;

public class ValidatorMessage {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String INVALID_FUNCTION = "존재하지 않는 기능입니다.";
    public static final String NO_MISSION = "존재하지 않는 미션입니다.";
    public static final String DUPLICATE_MATCHING = "매칭에 실패하였습니다.";

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
