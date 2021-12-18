package pairmatching;

public class ValidatorMessage {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String NO_MISSION = "존재하지 않는 미션입니다.";
    public static final String NO_MATCHING_RECORD = "매칭 이력이 없습니다.";
    public static final String ALREADY_HAVE_MATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
