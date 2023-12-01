package pairmatching.validator;

public class InputRetryValidator {

    public static String validateInputRetry(String retry) {
        if (!retry.equals("예") && !retry.equals("아니오")) {
            throw new IllegalArgumentException("[ERROR] 예, 아니오 중에 입력해주세요.");
        }
        return retry;
    }
}
