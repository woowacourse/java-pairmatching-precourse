package pairmatching.inputview;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Mission;
import pairmatching.system.convertion.StringToPairMatchingInfoConverter;
import pairmatching.vo.PairMatchingInfo;

import java.util.List;
import java.util.Map;

public class SelectingMissionInputView implements InputView<PairMatchingInfo> {
    @Override
    public PairMatchingInfo getInput(Map<String, Object> model) {
        String input = readInput();
        return StringToPairMatchingInfoConverter.convert(input, (List<Mission>) model.get("missions"));
    }

    protected static String readInput() {
        return Console.readLine();
    }
}
