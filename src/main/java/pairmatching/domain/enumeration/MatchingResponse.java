package pairmatching.domain.enumeration;

import pairmatching.utils.ConstantMessages;

import java.util.Arrays;

public enum MatchingResponse {
    YES("네"),
    NO("아니오");

    private String response;

    MatchingResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public static MatchingResponse findResponseByInput(String input) {
        return Arrays.stream(MatchingResponse.values())
                .filter(matchingResponse -> matchingResponse.getResponse().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_INVALID_INPUT));
    }
}
