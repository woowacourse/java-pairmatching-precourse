package pairmatching.outputview;

import pairmatching.vo.FeatureCommand;

import java.util.Map;

public class SelectingFeatureOutputView implements OutputView {

    public static final String SELECT_FEATURE_MESSAGE = "기능을 선택하세요.";
    public static final String FEATURE_FORMAT = "%s. %s%n";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(SELECT_FEATURE_MESSAGE);
        for (FeatureCommand featureCommand : FeatureCommand.values()) {
            System.out.printf(FEATURE_FORMAT, featureCommand.getCommand(), featureCommand.getDescription());
        }
    }
}
