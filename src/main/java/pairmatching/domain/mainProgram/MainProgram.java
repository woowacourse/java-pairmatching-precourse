package pairmatching.domain.mainProgram;

import pairmatching.domain.pairMatcher.PairMatcher;

public class MainProgram {
    OptionNumber optionNumber;
    PairMatcher pairMatcher;

    public MainProgram() {
        pairMatcher = new PairMatcher();
    }

    public void setOptionNumber(String optionNumber) {
        this.optionNumber = new OptionNumber(optionNumber);
    }

    public String getOptionNumber() {
        return optionNumber.getOptionNumber();
    }

    public void match(String info) {
        pairMatcher.addPairList(info);
    }
}
