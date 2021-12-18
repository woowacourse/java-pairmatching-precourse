package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class ResponseValidator {
	private static List<String> responseList = Arrays.asList("네","아니오");
	public static final String ERROR_WRONG_RESPONSE = "[ERROR] 네, 아니오 만 입력가능합니다.";

	public static void validateResponse(String response) {
		if (!responseList.contains(response)) {
			throw new IllegalArgumentException(ERROR_WRONG_RESPONSE);
		}
	}
}
