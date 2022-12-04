package system.convertion;

import vo.FeatureCommand;

import java.util.Arrays;

public class StringToFeatureCommandConverter {

    public static final String WRONG_COMMAND_MESSAGE = "잘못된 커멘드를 입력하였습니다.";

    public static FeatureCommand convert(String target) {
        // TODO: 값 검증
        return Arrays.stream(FeatureCommand.values())
                .filter(featureCommand -> featureCommand.getCommand().equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_COMMAND_MESSAGE));
    }
}
