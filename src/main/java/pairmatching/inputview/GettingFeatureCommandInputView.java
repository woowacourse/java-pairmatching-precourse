package pairmatching.inputview;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.system.convertion.StringToFeatureCommandConverter;
import pairmatching.vo.FeatureCommand;

import java.util.Map;

public class GettingFeatureCommandInputView implements InputView<FeatureCommand> {
    @Override
    public FeatureCommand getInput(Map<String, Object> model) {
        String input = readInput();
        return StringToFeatureCommandConverter.convert(input);
    }

    protected static String readInput() {
        return Console.readLine();
    }
}
