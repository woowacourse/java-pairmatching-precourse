package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.match.MatchData;
import pairmatching.util.Separator;
import pairmatching.util.Validator;

import java.util.List;

public class InputView {
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final Separator separator = new Separator();

    public String readFunction() {
        outputView.printFunctionSelectMessage();
        String func = Console.readLine();
        validator.validateSelectFunctionValue(func);

        return func;
    }

    public MatchData readMatchData() {
        outputView.printMatchDataInputMessage();
        String inputMatchData = Console.readLine();
        List<String> separatedMatchData = separator.separateMatchData(inputMatchData);
        MatchData matchData = validator.validateMatchDataIsExist(separatedMatchData);

        return matchData;
    }
}
