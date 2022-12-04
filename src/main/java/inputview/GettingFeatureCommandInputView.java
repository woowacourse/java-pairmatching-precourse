package inputview;

import camp.nextstep.edu.missionutils.Console;
import system.convertion.StringToFeatureCommandConverter;
import vo.FeatureCommand;

public class GettingFeatureCommandInputView implements InputView<FeatureCommand> {
    @Override
    public FeatureCommand getInput() {
        String input = readInput();
        return StringToFeatureCommandConverter.convert(input);
    }

    protected static String readInput() {
        return Console.readLine();
    }
}
