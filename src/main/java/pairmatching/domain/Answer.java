package pairmatching.domain;

import java.util.Arrays;

public enum Answer {
    YES("네"), NO("아니오");

    private final String answerName;

    Answer(final String answerName) {
        this.answerName = answerName;
    }

    public static Answer from(String answerName) {
        return Arrays.stream(values())
                .filter(answer -> answer.answerName.equals(answerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("다시 입력해주세요."));
    }
}
